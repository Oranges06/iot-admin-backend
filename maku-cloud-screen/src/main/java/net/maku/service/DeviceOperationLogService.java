package net.maku.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.maku.entity.DeviceOperationLog;
import net.maku.framework.common.utils.PageResult;
import net.maku.query.DeviceOperationLogQuery;
import net.maku.vo.DeviceOperationLogVO;

/**
 * 设备运行日志服务接口
 */
public interface DeviceOperationLogService extends IService<DeviceOperationLog> {
    /**
     * 分页查询
     * @param query 查询参数
     * @return 分页结果
     */
    PageResult<DeviceOperationLogVO> page(DeviceOperationLogQuery query);
    
    /**
     * 查询告警信息（type=1）
     * @param query 查询参数
     * @return 分页结果
     */
    PageResult<DeviceOperationLogVO> pageAlarms(DeviceOperationLogQuery query);
}