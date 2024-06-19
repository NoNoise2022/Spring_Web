package org.zerock.projectWeb.dto;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * A Data Transfer Object (DTO) for paginated requests.
 */
@Data
@Builder
@AllArgsConstructor
public class PageRequestDTO {

    private int page;
    private int size;

    /**
     * Default constructor initializing page to 1 and size to 10.
     */
    public PageRequestDTO() {
        this.page = 1;
        this.size = 10;
    }

    /**
     * Converts this DTO to a Pageable object with the given sort order.
     *
     * @param sort the sort order
     * @return a Pageable object
     */
    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page - 1, size, sort);
    }
}
