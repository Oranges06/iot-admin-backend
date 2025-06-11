package net.maku.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import net.maku.dao.DeviceDao;
import net.maku.dao.DeviceOperationLogDao;
import net.maku.entity.Device;
import net.maku.entity.DeviceOperationLog;
import net.maku.framework.mybatis.service.impl.BaseServiceImpl;
import net.maku.service.DeviceService;
import net.maku.vo.DeviceStatisticsVO;
import net.maku.vo.DeviceTypeStatisticsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: minder
 * @createTime: 2025/06/09 16:51
 * @description:
 **/
@Service
public class DeviceServiceImpl extends BaseServiceImpl<DeviceDao, Device> implements DeviceService {
    
    @Autowired
    private DeviceOperationLogDao deviceOperationLogDao;
    
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
    
    @Override
    public DeviceTypeStatisticsVO getDeviceTypeStatistics() {
        // 设备类型映射表
        Map<Integer, String> typeMap = new HashMap<>();
        typeMap.put(1, "灯");
        typeMap.put(2, "风扇");
        typeMap.put(3, "蜂鸣器");
        typeMap.put(4, "温湿度");
        typeMap.put(5, "人体红外");
        typeMap.put(6, "光敏");
        
        // 创建基础查询条件：只查询未删除的设备(deleted=0)
        LambdaQueryWrapper<Device> baseWrapper = new LambdaQueryWrapper<Device>()
                .eq(Device::getDeleted, 0);
        
        List<DeviceTypeStatisticsVO.DeviceTypeItem> items = new ArrayList<>();
        
        // 遍历每种设备类型，统计数量
        for (Map.Entry<Integer, String> entry : typeMap.entrySet()) {
            Integer typeCode = entry.getKey();
            String typeName = entry.getValue();
            
            // 该类型设备的基础查询条件
            LambdaQueryWrapper<Device> typeWrapper = baseWrapper.clone()
                    .eq(Device::getType, typeCode);
            
            // 获取该类型设备总数
            long totalCount = count(typeWrapper);
            
            // 如果该类型没有设备，跳过
            if (totalCount == 0) {
                continue;
            }
            
            // 获取该类型在线设备数
            long onlineCount = count(typeWrapper.clone().eq(Device::getStatus, 1));
            
            // 获取该类型离线设备数
            long offlineCount = count(typeWrapper.clone().eq(Device::getStatus, 0));
            
            // 创建并添加统计项
            DeviceTypeStatisticsVO.DeviceTypeItem item = DeviceTypeStatisticsVO.DeviceTypeItem.builder()
                    .typeCode(typeCode)
                    .typeName(typeName)
                    .totalCount((int)totalCount)
                    .onlineCount((int)onlineCount)
                    .offlineCount((int)offlineCount)
                    .build();
            
            items.add(item);
        }
        
        // 构建并返回统计数据
        return DeviceTypeStatisticsVO.builder()
                .items(items)
                .build();
    }
    
    @Override
    public DeviceStatisticsVO getDeviceStatisticsWithAlarms() {
        // 获取基本设备统计信息
        DeviceStatisticsVO statistics = getDeviceStatistics();
        
        // 查询告警信息数量（type=2的记录）
        LambdaQueryWrapper<DeviceOperationLog> alarmWrapper = new LambdaQueryWrapper<DeviceOperationLog>()
                .eq(DeviceOperationLog::getDeleted, 0)
                .eq(DeviceOperationLog::getType, 2);
        
        // 获取告警数量
        long alarmCount = deviceOperationLogDao.selectCount(alarmWrapper);
        
        // 设置告警数量
        statistics.setAlarmCount((int)alarmCount);
        
        return statistics;
    }
}
