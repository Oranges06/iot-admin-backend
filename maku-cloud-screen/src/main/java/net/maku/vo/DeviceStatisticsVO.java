package net.maku.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 设备统计数据VO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "设备统计数据")
public class DeviceStatisticsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "设备总数")
    private Integer totalCount;

    @Schema(description = "在线设备数")
    private Integer onlineCount;

    @Schema(description = "离线设备数")
    private Integer offlineCount;
    
    @Schema(description = "告警设备数")
    private Integer alarmCount;
}