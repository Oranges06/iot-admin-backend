package top.cry.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.cry.dto.DeviceDTO;
import top.cry.entity.Device;
import top.cry.vo.DeviceVO;

import java.util.List;
/**
 * 设备表
 *
 * @author cry
 */
@Mapper
public interface DeviceConvert {
 DeviceConvert INSTANCE = Mappers.getMapper(DeviceConvert.class);
 Device convert(DeviceDTO deviceDto);
 DeviceVO convert(Device device);
 List<DeviceVO> convertList(List<Device> list);
}