package me.matamor.backend.models.autor;

import lombok.*;
import me.matamor.backend.filter.FilterCriteria;
import me.matamor.backend.util.validation.ValidId;

import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AutorRequest {

    @ValidId
    private String id;

    @Size(min = 3, max = 64)
    private String name;

    @Size(min = 3, max = 64)
    private String surnames;

    private FilterCriteria nameCriteria = FilterCriteria.EQUAL;
    private FilterCriteria surnamesCriteria = FilterCriteria.EQUAL;

}
