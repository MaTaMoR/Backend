package me.matamor.backend.models.category;

import lombok.*;
import me.matamor.backend.filter.FilterCriteria;
import me.matamor.backend.util.validation.ValidId;

import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {

    @ValidId
    private String id;

    @Size(min = 1, max = 64)
    private String name;

    private FilterCriteria nameCriteria = FilterCriteria.EQUAL;

}
