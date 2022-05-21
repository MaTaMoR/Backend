package me.matamor.backend.models.page.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
@AllArgsConstructor
public class SortResponse {

    private List<OrderResponse> orders;

    public SortResponse(Sort sort) {
        this.orders = sort.get().map(OrderResponse::new).collect(Collectors.toList());
    }
}
