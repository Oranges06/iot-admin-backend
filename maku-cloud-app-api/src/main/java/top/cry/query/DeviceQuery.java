package top.cry.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.dl.common.query.Query;

/**
 *@author cry
**/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "设备查询")
public class DeviceQuery extends Query {
 @Schema(description = "设备类型")
 private Integer type;
 @Schema(description = "设备名称")
 private String name;
 @Schema(description = "设备状态")
 private Boolean status;
}