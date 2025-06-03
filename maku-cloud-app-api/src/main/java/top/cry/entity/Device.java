package top.cry.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.dl.mybatis.entity.BaseEntity;

/**
 * @author cry
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_device")
public class Device extends BaseEntity {
 private String deviceId;
 private String name;
 private Integer type;
 private Boolean status;
}