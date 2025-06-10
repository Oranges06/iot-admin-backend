package net.maku.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 设备运行日志
 */
@Data
@TableName("t_message")
public class DeviceOperationLog {
    /**
     * 主键
     */
    @TableId
    @TableField(value = "id")
    private Long id;

    /**
     * 设备id
     */
    @TableField(value = "device_id")
    private String deviceId;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 类型 
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