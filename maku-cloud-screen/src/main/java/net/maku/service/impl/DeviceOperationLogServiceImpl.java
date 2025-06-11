package net.maku.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import net.maku.dao.DeviceOperationLogDao;
import net.maku.entity.DeviceOperationLog;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.query.DeviceOperationLogQuery;
import net.maku.service.DeviceOperationLogService;
import net.maku.vo.DeviceOperationLogVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备运行日志服务实现类
 */
@Service
public class DeviceOperationLogServiceImpl extends BaseServiceImpl<DeviceOperationLogDao, DeviceOperationLog> implements DeviceOperationLogService {

    @Override
    public PageResult<DeviceOperationLogVO> page(DeviceOperationLogQuery query) {
        // 创建查询条件
        LambdaQueryWrapper<DeviceOperationLog> wrapper = Wrappers.lambdaQuery();
        
        // 设置查询条件
        wrapper.eq(DeviceOperationLog::getDeleted, 0); // 只查询未删除的记录
        wrapper.eq(query.getDeviceId() != null, DeviceOperationLog::getDeviceId, query.getDeviceId());
        wrapper.eq(query.getType() != null, DeviceOperationLog::getType, query.getType());
        
        // 按创建时间降序排序
        wrapper.orderByDesc(DeviceOperationLog::getCreateTime);
        
        // 执行分页查询
        IPage<DeviceOperationLog> page = baseMapper.selectPage(getPage(query), wrapper);
        
        // 转换为VO对象
        List<DeviceOperationLogVO> voList = new ArrayList<>();
        for (DeviceOperationLog entity : page.getRecords()) {
            DeviceOperationLogVO vo = new DeviceOperationLogVO();
            vo.setId(entity.getId());
            vo.setDeviceId(entity.getDeviceId());
            vo.setType(entity.getType());
            vo.setContent(entity.getContent());
            vo.setCreateTime(entity.getCreateTime());
            voList.add(vo);
        }
        
        return new PageResult<>(voList, page.getTotal());
    }
    
    @Override
    public PageResult<DeviceOperationLogVO> pageAlarms(DeviceOperationLogQuery query) {
        // 创建查询条件
        LambdaQueryWrapper<DeviceOperationLog> wrapper = Wrappers.lambdaQuery();
        
        // 设置查询条件
        wrapper.eq(DeviceOperationLog::getDeleted, 0); // 只查询未删除的记录
        wrapper.eq(DeviceOperationLog::getType, 2);    // 只查询告警信息（type=1）
        wrapper.eq(query.getDeviceId() != null, DeviceOperationLog::getDeviceId, query.getDeviceId());
        
        // 按创建时间降序排序
        wrapper.orderByDesc(DeviceOperationLog::getCreateTime);
        
        // 执行分页查询
        IPage<DeviceOperationLog> page = baseMapper.selectPage(getPage(query), wrapper);
        
        // 转换为VO对象
        List<DeviceOperationLogVO> voList = new ArrayList<>();
        for (DeviceOperationLog entity : page.getRecords()) {
            DeviceOperationLogVO vo = new DeviceOperationLogVO();
            vo.setId(entity.getId());
            vo.setDeviceId(entity.getDeviceId());
            vo.setType(entity.getType());
            vo.setContent(entity.getContent());
            vo.setCreateTime(entity.getCreateTime());
            voList.add(vo);
        }
        
        return new PageResult<>(voList, page.getTotal());
    }
}