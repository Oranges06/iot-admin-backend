package net.maku.iot.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.iot.vo.TMessageVO;
import net.maku.iot.query.TMessageQuery;
import net.maku.iot.entity.TMessageEntity;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

/**
 * 告警管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface TMessageService extends BaseService<TMessageEntity> {

    PageResult<TMessageVO> page(TMessageQuery query);

    TMessageVO get(Long id);


    void save(TMessageVO vo);

    void update(TMessageVO vo);

    void delete(List<Long> idList);

    void importByExcel(MultipartFile file);

    void export();
}