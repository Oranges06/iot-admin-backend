package top.cry.service;

import top.cry.entity.Device;
import top.cry.query.DeviceQuery;
import top.cry.vo.DeviceVO;
/**
 * @author cry
 **/
public interface DeviceService extends BaseService<Device> {
 PageResult<DeviceVO> page(DeviceQuery query);
 /**
 * 发送命令
 *
 * @param deviceId 设备id
 * @param command 命令
 */
 void sendCommand(String deviceId, String command);
}