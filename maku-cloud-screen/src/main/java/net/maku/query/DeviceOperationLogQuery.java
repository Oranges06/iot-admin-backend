package net.maku.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.query.Query;

/**
 * 设备运行日志查询
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "设备运行日志查询")
public class DeviceOperationLogQuery extends Query {

    @Schema(description = "设备ID")
    private String deviceId;

    @Schema(description = "事件类型")
    private Integer type;
}