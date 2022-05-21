package me.matamor.backend.models.user;

import lombok.*;
import me.matamor.backend.filter.FilterCriteria;

import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private Long id;

    @Size(min = 3, max = 16)
    private String username;

    @Size(min = 3, max = 16)
    private String name;

    @Size(min = 3, max = 32)
    private String surnames;

    private FilterCriteria usernameCriteria = FilterCriteria.EQUAL;
    private FilterCriteria nameCriteria = FilterCriteria.EQUAL;
    private FilterCriteria surnamesCriteria = FilterCriteria.EQUAL;

}
