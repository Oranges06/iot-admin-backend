package net.maku.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.entity.Device;
import net.maku.framework.common.utils.Result;
import net.maku.service.DeviceService;
import net.maku.vo.DeviceStatisticsVO;
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
@Tag(name="设备统计")
public class DeviceController {
    private DeviceService deviceService;
    
    @GetMapping("/statistics")
    @Operation(summary = "设备统计数据")
    public Result<DeviceStatisticsVO> getDeviceStatistics() {
        DeviceStatisticsVO statistics = deviceService.getDeviceStatistics();
        return Result.ok(statistics);
    }
}
