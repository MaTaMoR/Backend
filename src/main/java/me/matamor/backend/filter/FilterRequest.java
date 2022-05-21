package me.matamor.backend.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import me.matamor.backend.models.page.request.PageableRequest;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@AllArgsConstructor
public class FilterRequest<T> {

    @NotNull
    private T filter;

    @NotNull
    private PageableRequest page;

}
