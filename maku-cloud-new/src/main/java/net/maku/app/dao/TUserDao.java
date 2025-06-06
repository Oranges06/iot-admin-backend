package net.maku.app.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.app.entity.TUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 住户管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface TUserDao extends BaseDao<TUserEntity> {

}