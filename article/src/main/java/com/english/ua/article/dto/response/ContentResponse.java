package com.english.ua.article.dto.response;

import com.english.ua.article.entity.Type;

import java.util.List;
import java.util.Map;

public record ContentResponse(
        String id,
        String parentId,
        Type type,
        Map<String, String> properties,
        List<String> contentIds
) {
}
