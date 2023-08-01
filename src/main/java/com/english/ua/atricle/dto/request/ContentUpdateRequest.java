package com.english.ua.atricle.dto.request;

import com.english.ua.atricle.entity.Type;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Map;

public record ContentUpdateRequest(
        @NotNull(message = "Id cannot be null")
        String id,
        @Min(value = 1, message = "Parent Content Id cannot be less than 1")
        String parentId,
        @NotNull(message = "Type cannot be null")
        Type type,
        @NotNull(message = "Properties cannot be null")
        @Size(min = 1, message = "Properties must not be empty")
        Map<String, String> properties,
        List<String> contentIds
) {
}
