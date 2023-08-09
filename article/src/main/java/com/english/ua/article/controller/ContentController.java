package com.english.ua.article.controller;

import com.english.ua.article.dto.request.ContentCreateRequest;
import com.english.ua.article.dto.request.ContentUpdateRequest;
import com.english.ua.article.dto.response.ContentResponse;
import com.english.ua.article.mapper.ContentMapper;
import com.english.ua.article.service.ContentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/contents")
public class ContentController {

    private final ContentMapper contentMapper;
    private final ContentService contentService;

    @GetMapping
    public List<ContentResponse> findAll() {
        return contentMapper.toResponseModel(
                contentService.findAll()
        );
    }

    @GetMapping("{id}")
    public ContentResponse findById(@PathVariable("id") String contentId) {
        return contentMapper.toResponseModel(
                contentService.findById(contentId)
        );
    }

    @PostMapping
    public ContentResponse save(@Valid @RequestBody ContentCreateRequest request) {
        return contentMapper.toResponseModel(
                contentService.save(
                        contentMapper.toEntity(request)
                )
        );
    }

    @PutMapping
    public ContentResponse update(@Valid @RequestBody ContentUpdateRequest request) {
        return contentMapper.toResponseModel(
                contentService.update(
                        contentMapper.toEntity(request)
                )
        );
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String contentId) {
        contentService.deleteById(contentId);
    }
}
