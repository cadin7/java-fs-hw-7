package com.cadincloud.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public final class CollectionResponse<T> {
    private final List<T> content;
    private final PageInfo pageInfo;
}
