package me.matamor.backend.models.page.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SortRequest {

    private List<OrderRequest> orders;

    public Sort toSort() {
        return Sort.by(this.orders.stream()
                .map(OrderRequest::toOrder)
                .collect(Collectors.toList()));
    }
}
