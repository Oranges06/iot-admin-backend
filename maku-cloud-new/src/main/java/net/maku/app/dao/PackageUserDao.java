package net.maku.app.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 套餐用户关联
 */
@Mapper
public interface PackageUserDao {

    /**
     * 根据用户ID查询套餐ID
     */
    @Select("SELECT package_id FROM t_package_user WHERE user_id = #{userId} AND deleted = 0")
    List<Integer> getPackageIdsByUserId(Integer userId);
}