package me.matamor.backend.models.page.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.domain.Sort;

@Getter
@ToString
@AllArgsConstructor
public class OrderResponse {

    private Sort.Direction direction;
    private String property;

    public OrderResponse(Sort.Order order) {
        this.direction = order.getDirection();
        this.property = order.getProperty();
    }
}
