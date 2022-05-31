package me.matamor.backend.models.editorial;

import lombok.*;
import me.matamor.backend.models.image.Image;
import org.springframework.lang.Nullable;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Size(min = 3, max = 64)
    @Column(name = "name")
    private String name;

    @Nullable
    @ManyToOne
    private Image image;

    public Editorial(String name) {
        this.name = name;
    }
}
