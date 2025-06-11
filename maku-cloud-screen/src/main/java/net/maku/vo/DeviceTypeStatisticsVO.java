package net.maku.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 设备类型统计数据VO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "设备类型统计数据")
public class DeviceTypeStatisticsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "设备类型统计列表")
    private List<DeviceTypeItem> items;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(description = "设备类型统计项")
    public static class DeviceTypeItem {
        @Schema(description = "设备类型编号")
        private Integer typeCode;

        @Schema(description = "设备类型名称")
        private String typeName;

        @Schema(description = "设备总数")
        private Integer totalCount;

        @Schema(description = "在线设备数")
        private Integer onlineCount;

        @Schema(description = "离线设备数")
        private Integer offlineCount;
    }
}