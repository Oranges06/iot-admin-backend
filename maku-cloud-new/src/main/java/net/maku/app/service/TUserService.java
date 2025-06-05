package net.maku.app.service;

import net.maku.framework.common.utils.PageResult;
import net.maku.framework.mybatis.service.BaseService;
import net.maku.app.vo.TUserVO;
import net.maku.app.query.TUserQuery;
import net.maku.app.entity.TUserEntity;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

/**
 * 住户管理
 *
 * @author 环游 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface TUserService extends BaseService<TUserEntity> {

    PageResult<TUserVO> page(TUserQuery query);

    TUserVO get(Long id);


    void save(TUserVO vo);

    void update(TUserVO vo);

    void delete(List<Long> idList);

    void importByExcel(MultipartFile file);

    void export();
}