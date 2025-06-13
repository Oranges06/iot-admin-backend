package net.maku.iot.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.baomidou.mybatisplus.annotation.*;
import java.time.LocalDateTime;;

/**
 * 告警管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */

@Data
@TableName("t_message")
public class TMessageEntity {
	/**
	* 主键
	*/
	@TableId
	@TableField(value = "id")
	private Integer id;

	/**
	* 设备id
	*/
	@TableField(value = "device_id")
	private String deviceId;

	/**
	* MQTT通信内容
	*/
	@TableField(value = "content")
	private String content;

	/**
	* 0正常 1告警
	*/
	@TableField(value = "type")
	private Integer type;

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