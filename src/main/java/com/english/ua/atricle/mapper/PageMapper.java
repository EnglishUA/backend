package com.english.ua.atricle.mapper;

import com.english.ua.atricle.dto.request.PageCreateRequest;
import com.english.ua.atricle.dto.request.PageUpdateRequest;
import com.english.ua.atricle.dto.response.PageResponse;
import com.english.ua.atricle.entity.Page;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface PageMapper {

    @Mapping(source = "articleId", target = "article.id")
    Page toEntity(PageCreateRequest request);

    @Mapping(source = "articleId", target = "article.id")
    Page toEntity(PageUpdateRequest request);

    @Mapping(source = "article.id", target = "articleId")
    PageResponse toResponseModel(Page page);

    @Mapping(source = "article.id", target = "articleId")
    List<PageResponse> toResponseModel(List<Page> pages);
}
