package me.matamor.backend.models.autor;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "autors")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Size(min = 1, max = 64)
    @Column(name = "surnames")
    private String surnames;

    @Nullable
    @Column(name = "image")
    private String image;

    public Autor(String name, String surnames) {
        this(name, surnames, null);
    }

    public Autor(String name, String surnames, String image) {
        this.name = name;
        this.surnames = surnames;
        this.image = image;
    }

    public String fullName() {
        return this.name + " " + this.surnames;
    }

    public boolean hasImage() {
        return image != null && !image.isEmpty();
    }
}
