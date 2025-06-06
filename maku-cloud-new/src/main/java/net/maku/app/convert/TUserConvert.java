package net.maku.app.convert;

import net.maku.app.entity.TUserEntity;
import net.maku.app.vo.TUserVO;
import net.maku.app.vo.TUserExcelVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 住户管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface TUserConvert {
    TUserConvert INSTANCE = Mappers.getMapper(TUserConvert.class);

    TUserEntity convert(TUserVO vo);

    TUserVO convert(TUserEntity entity);

    List<TUserVO> convertList(List<TUserEntity> list);

    List<TUserEntity> convertList2(List<TUserVO> list);

    List<TUserExcelVO> convertExcelList(List<TUserEntity> list);

    List<TUserEntity> convertExcelList2(List<TUserExcelVO> list);
}