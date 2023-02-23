package com.cadincloud.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public final class PageInfo {
    private final int totalPages;
    private final long totalElements;
    private final int crtPage;
    private final int pageSize;
}
