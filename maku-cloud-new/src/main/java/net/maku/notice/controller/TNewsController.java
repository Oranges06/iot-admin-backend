package net.maku.notice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.maku.framework.common.utils.PageResult;
import net.maku.framework.common.utils.Result;
import net.maku.framework.operatelog.annotations.OperateLog;
import net.maku.framework.operatelog.enums.OperateTypeEnum;
import net.maku.notice.service.TNewsService;
import net.maku.notice.query.TNewsQuery;
import net.maku.notice.vo.TNewsVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * 资讯管理
 *
 * @author minder babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@RestController
@RequestMapping("/notice/news")
@Tag(name="资讯管理")
@AllArgsConstructor
public class TNewsController {
    private final TNewsService tNewsService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('notice:news:page')")
    public Result<PageResult<TNewsVO>> page(@ParameterObject @Valid TNewsQuery query){
        PageResult<TNewsVO> page = tNewsService.page(query);

        return Result.ok(page);
    }


    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('notice:news:info')")
    public Result<TNewsVO> get(@PathVariable("id") Long id){
        TNewsVO data = tNewsService.get(id);

        return Result.ok(data);
    }

    @PostMapping
    @Operation(summary = "保存")
    @OperateLog(type = OperateTypeEnum.INSERT)
    @PreAuthorize("hasAuthority('notice:news:save')")
    public Result<String> save(@RequestBody TNewsVO vo){
        tNewsService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @OperateLog(type = OperateTypeEnum.UPDATE)
    @PreAuthorize("hasAuthority('notice:news:update')")
    public Result<String> update(@RequestBody @Valid TNewsVO vo){
        tNewsService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @OperateLog(type = OperateTypeEnum.DELETE)
    @PreAuthorize("hasAuthority('notice:news:delete')")
    public Result<String> delete(@RequestBody List<Long> idList){
        tNewsService.delete(idList);

        return Result.ok();
    }


    @GetMapping("export")
    @Operation(summary = "导出")
    @OperateLog(type = OperateTypeEnum.EXPORT)
    @PreAuthorize("hasAuthority('notice:news:export')")
    public void export() {
        tNewsService.export();
    }
}