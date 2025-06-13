package net.maku.iot.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.iot.entity.TMessageEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 告警管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Mapper
public interface TMessageDao extends BaseDao<TMessageEntity> {

}