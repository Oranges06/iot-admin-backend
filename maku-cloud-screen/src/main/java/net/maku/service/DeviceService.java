package net.maku.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.maku.entity.Device;
import net.maku.vo.DeviceStatisticsVO;
import net.maku.vo.DeviceTypeStatisticsVO;

/**
 * @author: minder
 * @createTime: 2025/06/09 16:51
 * @description:
 **/
public interface DeviceService extends IService<Device> {
    /**
     * 获取设备统计数据
     * @return 设备统计数据
     */
    DeviceStatisticsVO getDeviceStatistics();
    
    /**
     * 获取按设备类型分类的统计数据
     * @return 设备类型统计数据
     */
    DeviceTypeStatisticsVO getDeviceTypeStatistics();
}
