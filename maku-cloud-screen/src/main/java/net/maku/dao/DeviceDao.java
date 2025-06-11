package net.maku.dao;

import net.maku.entity.Device;
import net.maku.framework.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: minder
 * @createTime: 2025/06/09 16:47
 * @description:
 **/
@Mapper
public interface DeviceDao extends BaseDao<Device> {
}
