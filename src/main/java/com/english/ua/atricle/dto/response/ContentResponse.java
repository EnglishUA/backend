package com.english.ua.atricle.dto.response;

import com.english.ua.atricle.entity.Type;

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
