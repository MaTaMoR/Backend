package me.matamor.backend.models.editorial;

import lombok.*;
import me.matamor.backend.filter.FilterCriteria;
import me.matamor.backend.util.validation.ValidId;

import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EditorialRequest {

    @ValidId
    private String id;
    @Size(min = 1, max = 64)
    private String name;

    private final FilterCriteria nameCriteria = FilterCriteria.EQUAL;
}
