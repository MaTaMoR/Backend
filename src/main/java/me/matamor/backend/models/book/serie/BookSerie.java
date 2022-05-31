package me.matamor.backend.models.book.serie;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "books_series")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BookSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Size(min = 3, max = 128)
    private String nombre;

    public BookSerie(String nombre) {
        this.nombre = nombre;
    }
}
