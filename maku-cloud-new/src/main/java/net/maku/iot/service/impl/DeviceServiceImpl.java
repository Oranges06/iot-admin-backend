package net.maku.iot.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.app.dao.PackageDeviceDao;
import net.maku.app.dao.PackageUserDao;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.framework.security.user.SecurityUser;
import net.maku.framework.security.user.UserDetail;
import net.maku.iot.convert.DeviceConvert;
import net.maku.iot.entity.DeviceEntity;
import net.maku.iot.query.DeviceQuery;
import net.maku.iot.vo.DeviceVO;
import net.maku.iot.dao.DeviceDao;
import net.maku.iot.service.DeviceService;
import com.fhs.trans.service.impl.TransService;
import net.maku.framework.common.utils.ExcelUtils;
import net.maku.iot.vo.DeviceExcelVO;
import net.maku.framework.common.excel.ExcelFinishCallBack;
import org.springframework.web.multipart.MultipartFile;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备
 *
 * @author cry babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class DeviceServiceImpl extends BaseServiceImpl<DeviceDao, DeviceEntity> implements DeviceService {
    private final TransService transService;
    private final PackageUserDao packageUserDao;
    private final PackageDeviceDao packageDeviceDao;

    @Override
    public PageResult<DeviceVO> page(DeviceQuery query) {
        // 获取当前登录用户ID
        UserDetail user = SecurityUser.getUser();
        if (user != null) {
            // 根据用户ID查询套餐ID
            List<Integer> packageIds = packageUserDao.getPackageIdsByUserId(user.getId().intValue());
            if (packageIds != null && !packageIds.isEmpty()) {
                // 根据套餐ID查询设备类型
                List<Integer> deviceTypes = packageDeviceDao.getDeviceTypesByPackageIds(packageIds);
                if (deviceTypes != null && !deviceTypes.isEmpty()) {
                    // 设置查询条件，只查询指定类型的设备
                    LambdaQueryWrapper<DeviceEntity> wrapper = getWrapper(query);
                    wrapper.in(DeviceEntity::getType, deviceTypes);
                    wrapper.eq(DeviceEntity::getDeleted, 0);
                    
                    IPage<DeviceEntity> page = baseMapper.selectPage(getPage(query), wrapper);
                    return new PageResult<>(DeviceConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
                }
            }
            // 如果用户没有关联套餐或套餐没有关联设备类型，返回空结果
            return new PageResult<>(new ArrayList<>(), 0);
        }
        
        // 如果无法获取当前用户，使用原有逻辑
        IPage<DeviceEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        return new PageResult<>(DeviceConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<DeviceEntity> getWrapper(DeviceQuery query){
        LambdaQueryWrapper<DeviceEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.like(ObjectUtil.isNotEmpty(query.getDeviceId()), DeviceEntity::getDeviceId, query.getDeviceId());
        wrapper.like(ObjectUtil.isNotEmpty(query.getName()), DeviceEntity::getName, query.getName());
        wrapper.eq(ObjectUtil.isNotEmpty(query.getType()), DeviceEntity::getType, query.getType());
        wrapper.eq(ObjectUtil.isNotEmpty(query.getAdminId()), DeviceEntity::getAdminId,query.getAdminId());
        wrapper.eq(ObjectUtil.isNotEmpty(query.getTenantId()), DeviceEntity::getTenantId,query.getTenantId());
        return wrapper;
    }


    @Override
    public DeviceVO get(Long id) {
        DeviceEntity entity = baseMapper.selectById(id);
        DeviceVO vo = DeviceConvert.INSTANCE.convert(entity);

        return vo;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(DeviceVO vo) {
        DeviceEntity entity = DeviceConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }


    @Override
    public void export() {
    List<DeviceExcelVO> excelList = DeviceConvert.INSTANCE.convertExcelList(list());
        transService.transBatch(excelList);
        ExcelUtils.excelExport(DeviceExcelVO.class, "设备", null, excelList);
    }

}