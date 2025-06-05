package net.maku.app.vo;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.vo.TransPojo;
import java.time.LocalDateTime;;

/**
 * 住户管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class TUserExcelVO implements TransPojo {
	@ExcelIgnore
	private Integer id;

	@ExcelProperty("用户名")
	private String username;

	@ExcelProperty("密码")
	private String password;

	@ExcelProperty("手机号")
	private String mobile;

	@ExcelProperty("昵称")
	private String nickname;

	@ExcelProperty("头像")
	private String avatar;

	@ExcelProperty("邮箱")
	private String email;

	@ExcelProperty("性别：0=未知，1=男，2=女")
	private Integer gender;

	@ExcelProperty("状态：0=禁用，1=正常")
	private Integer status;

	@ExcelProperty("社区ID")
	private Integer communityId;

	@ExcelProperty("租户ID")
	private Integer tenantId;

	@ExcelProperty("账号")
	private String account;

}