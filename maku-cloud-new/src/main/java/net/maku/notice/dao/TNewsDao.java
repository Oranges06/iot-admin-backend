package net.maku.notice.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.notice.entity.TNewsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 资讯管理
 *
 * @author minder babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface TNewsDao extends BaseDao<TNewsEntity> {

}