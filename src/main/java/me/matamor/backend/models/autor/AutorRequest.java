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

    @Size(min = 1, max = 64)
    private String name;

    @Size(min = 1, max = 64)
    private String surnames;

    @Size(min = 1, max = 128)
    private String fullName;

    private FilterCriteria nameCriteria = FilterCriteria.EQUAL;
    private FilterCriteria surnamesCriteria = FilterCriteria.EQUAL;
    private FilterCriteria fullNameCriteria = FilterCriteria.EQUAL;

}
