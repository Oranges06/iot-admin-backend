package net.maku.iot.vo;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.vo.TransPojo;
import java.time.LocalDateTime;;

/**
 * 告警管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class TMessageExcelVO implements TransPojo {
	@ExcelProperty("主键")
	private Integer id;

	@ExcelProperty("设备id")
	private String deviceId;

	@ExcelProperty("MQTT通信内容")
	private String content;

	@ExcelProperty("0正常 1告警")
	private Integer type;

}