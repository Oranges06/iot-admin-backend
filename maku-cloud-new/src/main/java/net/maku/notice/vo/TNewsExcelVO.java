package net.maku.notice.vo;

import lombok.Data;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fhs.core.trans.vo.TransPojo;
import java.time.LocalDateTime;;

/**
 * 资讯管理
 *
 * @author minder babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
public class TNewsExcelVO implements TransPojo {
	@ExcelIgnore
	private Integer id;

	@ExcelProperty("标题")
	private String title;

	@ExcelProperty("内容")
	private String content;

	@ExcelProperty("封面")
	private String cover;

	@ExcelProperty("租户id")
	private Integer tenantId;

}