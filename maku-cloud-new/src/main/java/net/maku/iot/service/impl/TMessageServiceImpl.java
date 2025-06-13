package net.maku.iot.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.iot.convert.TMessageConvert;
import net.maku.iot.entity.TMessageEntity;
import net.maku.iot.query.TMessageQuery;
import net.maku.iot.vo.TMessageVO;
import net.maku.iot.dao.TMessageDao;
import net.maku.iot.service.TMessageService;
import com.fhs.trans.service.impl.TransService;
import net.maku.framework.common.utils.ExcelUtils;
import net.maku.iot.vo.TMessageExcelVO;
import net.maku.framework.common.excel.ExcelFinishCallBack;
import org.springframework.web.multipart.MultipartFile;
import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 告警管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class TMessageServiceImpl extends BaseServiceImpl<TMessageDao, TMessageEntity> implements TMessageService {
    private final TransService transService;

    @Override
    public PageResult<TMessageVO> page(TMessageQuery query) {
        IPage<TMessageEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(TMessageConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<TMessageEntity> getWrapper(TMessageQuery query){
        LambdaQueryWrapper<TMessageEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }


    @Override
    public TMessageVO get(Long id) {
        TMessageEntity entity = baseMapper.selectById(id);
        TMessageVO vo = TMessageConvert.INSTANCE.convert(entity);

        return vo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(TMessageVO vo) {
        TMessageEntity entity = TMessageConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TMessageVO vo) {
        TMessageEntity entity = TMessageConvert.INSTANCE.convert(vo);

        updateById(entity);


    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);

    }

    @Override
    public void importByExcel(MultipartFile file) {
        ExcelUtils.readAnalysis(file, TMessageExcelVO.class, new ExcelFinishCallBack<>() {
            @Override
            public void doSaveBatch(List<TMessageExcelVO> resultList) {
                ExcelUtils.parseDict(resultList);
                saveBatch(TMessageConvert.INSTANCE.convertExcelList2(resultList));
            }
        });
    }

    @Override
    public void export() {
    List<TMessageExcelVO> excelList = TMessageConvert.INSTANCE.convertExcelList(list());
        transService.transBatch(excelList);
        ExcelUtils.excelExport(TMessageExcelVO.class, "告警管理", null, excelList);
    }

}