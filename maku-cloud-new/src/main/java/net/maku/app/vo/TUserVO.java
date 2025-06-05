package net.maku.app.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import lombok.Data;
import java.io.Serializable;
import net.maku.framework.common.utils.DateUtils;
import java.time.LocalDateTime;;

/**
 * 住户管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@Schema(description = "住户管理")
public class TUserVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "主键ID")
	private Integer id;

	@Schema(description = "用户名")
	private String username;

	@Schema(description = "密码")
	private String password;

	@Schema(description = "手机号")
	private String mobile;

	@Schema(description = "昵称")
	private String nickname;

	@Schema(description = "头像")
	private String avatar;

	@Schema(description = "邮箱")
	private String email;

	@Schema(description = "性别：0=未知，1=男，2=女")
	private Integer gender;

	@Schema(description = "状态：0=禁用，1=正常")
	private Integer status;

	@Schema(description = "社区ID")
	private Integer communityId;

	@Schema(description = "租户ID")
	private Integer tenantId;

	@Schema(description = "账号")
	private String account;

	@Schema(description = "创建时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private LocalDateTime createTime;

	@Schema(description = "更新时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private LocalDateTime updateTime;

	@Schema(description = "删除标识")
	private Integer deleted;

}