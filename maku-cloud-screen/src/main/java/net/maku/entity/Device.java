package net.maku.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import net.maku.framework.mybatis.entity.BaseEntity;

import java.time.LocalDateTime;

/**
 * @author: minder
 * @createTime: 2025/06/09 16:44
 * @description:
 **/
@Data
@TableName("t_device")
public class Device extends BaseEntity {
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
     * 设备名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 类型 1 灯 2 温湿度传感器 3 蜂鸣器  4 红外传感器
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 开关 0-开 1-关
     */
    @TableField(value = "is_switched")
    private Integer isSwitched;

    /**
     * 状态 0-在线 1-离线
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 温度
     */
    @TableField(value = "temperature")
    private Float temperature;

    /**
     * 湿度
     */
    @TableField(value = "humidity")
    private Float humidity;

    /**
     * 租户id
     */
    @TableField(value = "tenant_id")
    private Integer tenantId;

    /**
     * 管理员id
     */
    @TableField(value = "admin_id")
    private Integer adminId;

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
