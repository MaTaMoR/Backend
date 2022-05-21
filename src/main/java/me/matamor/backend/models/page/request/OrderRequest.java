package me.matamor.backend.models.page.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Sort;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private Sort.Direction direction;
    private String property;

    public Sort.Order toOrder() {
        return new Sort.Order(this.direction, this.property);
    }
}