package com.english.ua.atricle.mapper;

import com.english.ua.atricle.dto.request.ContentCreateRequest;
import com.english.ua.atricle.dto.request.ContentUpdateRequest;
import com.english.ua.atricle.dto.response.ContentResponse;
import com.english.ua.atricle.entity.Content;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ContentMapper {

    @Mapping(source = "parentId", target = "parent", qualifiedByName = "parentIdToParent")
    Content toEntity(ContentCreateRequest request);

    @Mappings(value = {
            @Mapping(source = "parentId", target = "parent.id"),
            @Mapping(source = "contentIds", target = "contents", qualifiedByName = "contentIdsToContents"),
    })
    Content toEntity(ContentUpdateRequest request);

    @Mappings(value = {
            @Mapping(source = "parent.id", target = "parentId"),
            @Mapping(source = "contents", target = "contentIds", qualifiedByName = "contentsToContentIds"),
    })
    ContentResponse toResponseModel(Content content);

    List<ContentResponse> toResponseModel(List<Content> contents);

    @Named("parentIdToParent")
    default Content parentIdToParent(final String parentId) {
        if (parentId == null) return null;
        return Content.builder().id(parentId).build();
    }

    @Named("contentIdsToContents")
    default List<Content> contentIdsToContents(final List<String> contentIds) {
        if (contentIds == null || contentIds.isEmpty()) return new ArrayList<>();
        return contentIds.stream().map(contentId -> Content.builder().id(contentId).build()).collect(Collectors.toList());
    }

    @Named("contentsToContentIds")
    default List<String> contentsToContentIds(final List<Content> contents) {
        if (contents == null || contents.isEmpty()) return new ArrayList<>();
        return contents.stream().map(Content::getId).toList();
    }
}
