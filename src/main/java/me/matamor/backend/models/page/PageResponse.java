package me.matamor.backend.models.page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import me.matamor.backend.models.page.response.PageableResponse;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class PageResponse<T> {

    private List<T> content;
    private PageableResponse page;

}
