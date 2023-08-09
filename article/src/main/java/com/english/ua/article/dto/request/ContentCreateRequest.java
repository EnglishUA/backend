package com.english.ua.article.dto.request;

import com.english.ua.article.entity.Type;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Map;

public record ContentCreateRequest(
        String parentId,
        @NotNull(message = "Type cannot be null")
        Type type,
        @NotNull(message = "Properties cannot be null")
        @Size(min = 1, message = "Properties must not be empty")
        Map<String, String> properties
) {
}
