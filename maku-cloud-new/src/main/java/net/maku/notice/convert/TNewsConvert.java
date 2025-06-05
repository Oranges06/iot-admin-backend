package net.maku.notice.convert;

import net.maku.notice.entity.TNewsEntity;
import net.maku.notice.vo.TNewsVO;
import net.maku.notice.vo.TNewsExcelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 资讯管理
 *
 * @author minder babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface TNewsConvert {
    TNewsConvert INSTANCE = Mappers.getMapper(TNewsConvert.class);

    TNewsEntity convert(TNewsVO vo);

    TNewsVO convert(TNewsEntity entity);

    List<TNewsVO> convertList(List<TNewsEntity> list);

    List<TNewsEntity> convertList2(List<TNewsVO> list);

    List<TNewsExcelVO> convertExcelList(List<TNewsEntity> list);

    List<TNewsEntity> convertExcelList2(List<TNewsExcelVO> list);
}