package net.maku.app.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.app.convert.TUserConvert;
import net.maku.app.entity.TUserEntity;
import net.maku.app.query.TUserQuery;
import net.maku.app.vo.TUserVO;
import net.maku.app.dao.TUserDao;
import net.maku.app.service.TUserService;
import com.fhs.trans.service.impl.TransService;
import net.maku.framework.common.utils.ExcelUtils;
import net.maku.app.vo.TUserExcelVO;
import net.maku.framework.common.excel.ExcelFinishCallBack;
import org.springframework.web.multipart.MultipartFile;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 住户管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class TUserServiceImpl extends BaseServiceImpl<TUserDao, TUserEntity> implements TUserService {
    private final TransService transService;

    @Override
    public PageResult<TUserVO> page(TUserQuery query) {
        IPage<TUserEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(TUserConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<TUserEntity> getWrapper(TUserQuery query){
        LambdaQueryWrapper<TUserEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }


    @Override
    public TUserVO get(Long id) {
        TUserEntity entity = baseMapper.selectById(id);
        TUserVO vo = TUserConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(TUserVO vo) {
        TUserEntity entity = TUserConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TUserVO vo) {
        TUserEntity entity = TUserConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }

    @Override
    public void importByExcel(MultipartFile file) {
        ExcelUtils.readAnalysis(file, TUserExcelVO.class, new ExcelFinishCallBack<>() {
            @Override
            public void doSaveBatch(List<TUserExcelVO> resultList) {
                ExcelUtils.parseDict(resultList);
                saveBatch(TUserConvert.INSTANCE.convertExcelList2(resultList));
            }
        });
    }

    @Override
    public void export() {
    List<TUserExcelVO> excelList = TUserConvert.INSTANCE.convertExcelList(list());
        transService.transBatch(excelList);
        ExcelUtils.excelExport(TUserExcelVO.class, "住户管理", null, excelList);
    }

}