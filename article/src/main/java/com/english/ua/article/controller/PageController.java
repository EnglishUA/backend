package com.english.ua.article.controller;

import com.english.ua.article.dto.request.PageCreateRequest;
import com.english.ua.article.dto.request.PageUpdateRequest;
import com.english.ua.article.dto.response.PageResponse;
import com.english.ua.article.mapper.PageMapper;
import com.english.ua.article.service.PageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pages")
public class PageController {

    private final PageMapper pageMapper;
    private final PageService pageService;

    @GetMapping
    public List<PageResponse> findAll(@RequestParam(name = "articleId", required = false) Long articleId) {
        return pageMapper.toResponseModel(
                articleId == null ?
                        pageService.findAll()
                        :
                        pageService.findAllByArticleId(articleId)
        );
    }

    @GetMapping("{id}")
    public PageResponse findById(@PathVariable("id") Long pageId) {
        return pageMapper.toResponseModel(
                pageService.findById(pageId)
        );
    }

    @PostMapping
    public PageResponse save(@Valid @RequestBody PageCreateRequest request) {
        return pageMapper.toResponseModel(
                pageService.save(
                        pageMapper.toEntity(request)
                )
        );
    }

    @PutMapping
    public PageResponse update(@RequestBody PageUpdateRequest request) {
        return pageMapper.toResponseModel(
                pageService.update(
                        pageMapper.toEntity(request)
                )
        );
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long pageId) {
        pageService.deleteById(pageId);
    }
}
