package net.maku.app.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 套餐设备类型关联
 */
@Mapper
public interface PackageDeviceDao {

    /**
     * 根据套餐ID列表查询设备类型
     */
    @Select({"<script>",
            "SELECT device_type FROM t_package_device WHERE deleted = 0 AND package_id IN ",
            "<foreach collection='packageIds' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"})
    List<Integer> getDeviceTypesByPackageIds(List<Integer> packageIds);
}