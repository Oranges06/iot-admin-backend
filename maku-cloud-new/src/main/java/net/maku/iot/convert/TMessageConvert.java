package net.maku.iot.convert;

import net.maku.iot.entity.TMessageEntity;
import net.maku.iot.vo.TMessageVO;
import net.maku.iot.vo.TMessageExcelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 告警管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface TMessageConvert {
    TMessageConvert INSTANCE = Mappers.getMapper(TMessageConvert.class);

    TMessageEntity convert(TMessageVO vo);

    TMessageVO convert(TMessageEntity entity);

    List<TMessageVO> convertList(List<TMessageEntity> list);

    List<TMessageEntity> convertList2(List<TMessageVO> list);

    List<TMessageExcelVO> convertExcelList(List<TMessageEntity> list);

    List<TMessageEntity> convertExcelList2(List<TMessageExcelVO> list);
}