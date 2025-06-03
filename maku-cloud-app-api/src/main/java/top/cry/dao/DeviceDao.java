package top.cry.dao;

import org.apache.ibatis.annotations.Mapper;
import top.cry.entity.Device;
import top.cry.framework.mybatis.dao.BaseDao;

import java.util.List;
import java.util.Map;
/**
 * @author cry
 */
@Mapper
public interface DeviceDao extends BaseDao<Device> {
 List<Device> getList(Map<String, Object> params);
}