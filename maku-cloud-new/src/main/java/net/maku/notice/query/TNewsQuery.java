package net.maku.notice.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.common.query.Query;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;;

/**
 * 资讯管理查询
 *
 * @author minder babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "资讯管理查询")
public class TNewsQuery extends Query {
    @Schema(description = "标题")
    private String title;

}