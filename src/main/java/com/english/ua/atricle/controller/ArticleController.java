package com.english.ua.atricle.controller;

import com.english.ua.atricle.dto.request.ArticleCreateRequest;
import com.english.ua.atricle.dto.request.ArticleUpdateRequest;
import com.english.ua.atricle.dto.response.ArticleResponse;
import com.english.ua.atricle.mapper.ArticleMapper;
import com.english.ua.atricle.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ArticleController {

    private final ArticleMapper articleMapper;
    private final ArticleService articleService;

    @GetMapping
    public List<ArticleResponse> findAll() {
        return articleMapper.toResponseModel(
                articleService.findAll()
        );
    }

    @GetMapping("{id}")
    public ArticleResponse findById(@PathVariable("id") Long articleId) {
        return articleMapper.toResponseModel(
                articleService.findById(articleId)
        );
    }

    @PostMapping
    public ArticleResponse save(@Valid @RequestBody ArticleCreateRequest request) {
        return articleMapper.toResponseModel(
                articleService.save(
                        articleMapper.toEntity(request)
                )
        );
    }

    @PostMapping("{id}")
    public ArticleResponse updateImage(
            @PathVariable("id") Long articleId,
            @RequestBody MultipartFile image
    ) {
        return articleMapper.toResponseModel(
                articleService.updateImage(articleId, image)
        );
    }

    @PutMapping
    public ArticleResponse update(@Valid @RequestBody ArticleUpdateRequest request) {
        return articleMapper.toResponseModel(
                articleService.update(
                        articleMapper.toEntity(request)
                )
        );
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long articleId) {
        articleService.deleteById(articleId);
    }
}
