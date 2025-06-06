package net.maku.app.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;;

/**
 * 住户管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */

@Data
@TableName("t_user")
public class TUserEntity {
	/**
	* 主键ID
	*/
	@TableId
	@TableField(value = "id")
	private Integer id;

	/**
	* 用户名
	*/
	@TableField(value = "username")
	private String username;

	/**
	* 密码
	*/
	@TableField(value = "password")
	private String password;

	/**
	* 手机号
	*/
	@TableField(value = "mobile")
	private String mobile;

	/**
	* 昵称
	*/
	@TableField(value = "nickname")
	private String nickname;

	/**
	* 头像
	*/
	@TableField(value = "avatar")
	private String avatar;

	/**
	* 邮箱
	*/
	@TableField(value = "email")
	private String email;

	/**
	* 性别：0=未知，1=男，2=女
	*/
	@TableField(value = "gender")
	private Integer gender;

	/**
	* 状态：0=禁用，1=正常
	*/
	@TableField(value = "status")
	private Integer status;

	/**
	* 社区ID
	*/
	@TableField(value = "community_id")
	private Integer communityId;

	/**
	* 租户ID
	*/
	@TableField(value = "tenant_id")
	private Integer tenantId;

	/**
	* 账号
	*/
	@TableField(value = "account")
	private String account;

	/**
	* 创建时间
	*/
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	* 更新时间
	*/
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

	/**
	* 删除标识
	*/
	@TableField(value = "deleted", fill = FieldFill.INSERT)
	private Integer deleted;

}