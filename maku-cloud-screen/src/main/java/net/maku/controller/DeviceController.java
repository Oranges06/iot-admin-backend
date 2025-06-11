package net.maku.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.entity.Device;
import net.maku.framework.common.utils.Result;
import net.maku.service.DeviceService;
import net.maku.vo.DeviceStatisticsVO;
import net.maku.vo.DeviceTypeStatisticsVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: minder
 * @createTime: 2025/06/09 16:52
 * @description:
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/device")
@Tag(name="设备")
public class DeviceController {
    private DeviceService deviceService;
    
    @GetMapping("/statistics")
    @Operation(summary = "设备状态总览")
    public Result<DeviceStatisticsVO> getDeviceStatistics() {
        DeviceStatisticsVO statistics = deviceService.getDeviceStatistics();
        return Result.ok(statistics);
    }
    
    @GetMapping("/type/statistics")
    @Operation(summary = "设备类型统计")
    public Result<DeviceTypeStatisticsVO> getDeviceTypeStatistics() {
        DeviceTypeStatisticsVO statistics = deviceService.getDeviceTypeStatistics();
        return Result.ok(statistics);
    }
    
    @GetMapping("/statistics/with-alarms")
    @Operation(summary = "设备状态总览（包含告警数）")
    public Result<DeviceStatisticsVO> getDeviceStatisticsWithAlarms() {
        DeviceStatisticsVO statistics = deviceService.getDeviceStatisticsWithAlarms();
        return Result.ok(statistics);
    }
}
