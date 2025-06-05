package net.maku.notice.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;;

/**
 * 资讯管理
 *
 * @author minder babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */

@Data
@TableName("t_news")
public class TNewsEntity {
	/**
	* 主键
	*/
	@TableId
	@TableField(value = "id")
	private Integer id;

	/**
	* 标题
	*/
	@TableField(value = "title")
	private String title;

	/**
	* 内容
	*/
	@TableField(value = "content")
	private String content;

	/**
	* 封面
	*/
	@TableField(value = "cover")
	private String cover;

	/**
	* 租户id
	*/
	@TableField(value = "tenant_id")
	private Integer tenantId;

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