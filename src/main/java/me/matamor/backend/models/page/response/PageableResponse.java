package me.matamor.backend.models.page.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.domain.Page;

@Getter
@ToString
@AllArgsConstructor
public class PageableResponse {

    private int page;
    private int size;
    private int totalElements;
    private SortResponse sort;

    public PageableResponse(Page<?> page) {
        this.page = page.getNumber();
        this.size = page.getSize();
        this.totalElements = Long.valueOf(page.getTotalElements()).intValue();
        this.sort = new SortResponse(page.getSort());
    }
}
