package net.maku.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import net.maku.dao.DeviceDao;
import net.maku.entity.Device;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.service.DeviceService;
import net.maku.vo.DeviceStatisticsVO;
import org.springframework.stereotype.Service;

/**
 * @author: minder
 * @createTime: 2025/06/09 16:51
 * @description:
 **/
@Service
public class DeviceServiceImpl extends BaseServiceImpl<DeviceDao, Device> implements DeviceService {
    
    @Override
    public DeviceStatisticsVO getDeviceStatistics() {
        // 创建基础查询条件：只查询未删除的设备(deleted=0)
        LambdaQueryWrapper<Device> baseWrapper = new LambdaQueryWrapper<Device>()
                .eq(Device::getDeleted, 0);
        
        // 获取设备总数（未删除的）
        long totalCount = count(baseWrapper);
        
        // 获取在线设备数（status=1表示在线，且未删除）
        long onlineCount = count(baseWrapper.clone().eq(Device::getStatus, 1));
        
        // 获取离线设备数（status=0表示离线，且未删除）
        long offlineCount = count(baseWrapper.clone().eq(Device::getStatus, 0));
        
        // 构建并返回统计数据
        return DeviceStatisticsVO.builder()
                .totalCount((int)totalCount)
                .onlineCount((int)onlineCount)
                .offlineCount((int)offlineCount)
                .build();
    }
}
