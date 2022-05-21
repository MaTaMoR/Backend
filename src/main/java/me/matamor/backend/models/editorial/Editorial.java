package me.matamor.backend.models.editorial;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "editorials")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Editorial {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private long id;

    @NotBlank
    @Size(min = 3, max = 64)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "image")
    private String image;

    public Editorial(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
