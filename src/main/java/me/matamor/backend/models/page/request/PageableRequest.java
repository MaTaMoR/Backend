package me.matamor.backend.models.page.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.PageRequest;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Min;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageableRequest {

    @Min(0)
    private int page;

    @Min(1)
    private int size;

    @Nullable
    private SortRequest sort;

    public PageRequest toRequest() {
        if (this.sort == null) {
            return PageRequest.of(this.page, this.size);
        } else {
            return PageRequest.of(this.page, this.size, this.sort.toSort());
        }
    }
}
