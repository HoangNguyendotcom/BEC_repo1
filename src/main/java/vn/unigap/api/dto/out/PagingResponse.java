package vn.unigap.api.dto.out;

import java.util.List;

public class PagingResponse<T> {
    private int page;
    private int pageSize;
    private long totalElements;
    private long totalPages;
    private List<T> data;

    // Constructors, getters, and setters
}