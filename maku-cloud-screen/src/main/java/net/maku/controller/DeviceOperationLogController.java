package net.maku.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.query.DeviceOperationLogQuery;
import net.maku.service.DeviceOperationLogService;
import net.maku.vo.DeviceOperationLogVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 设备运行日志
 */
@RestController
@AllArgsConstructor
@RequestMapping("/device/operation/log")
@Tag(name="设备运行日志")
public class DeviceOperationLogController {
    private final DeviceOperationLogService deviceOperationLogService;
    
    @GetMapping("/page")
    @Operation(summary = "分页查询")
    public Result<PageResult<DeviceOperationLogVO>> page(@ParameterObject @Valid DeviceOperationLogQuery query) {
        PageResult<DeviceOperationLogVO> page = deviceOperationLogService.page(query);
        return Result.ok(page);
    }
    
    @GetMapping("/alarms")
    @Operation(summary = "查询告警信息")
    public Result<PageResult<DeviceOperationLogVO>> alarms(@ParameterObject @Valid DeviceOperationLogQuery query) {
        PageResult<DeviceOperationLogVO> page = deviceOperationLogService.pageAlarms(query);
        return Result.ok(page);
    }
}