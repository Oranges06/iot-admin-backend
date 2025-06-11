package net.maku.dao;

import net.maku.entity.DeviceOperationLog;
import net.maku.framework.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 设备运行日志DAO
 */
@Mapper
public interface DeviceOperationLogDao extends BaseDao<DeviceOperationLog> {
}