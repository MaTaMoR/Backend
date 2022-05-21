package me.matamor.backend.models.book.serie;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @GeneratedValue
    @EqualsAndHashCode.Include
    private long id;

    @NotBlank
    @Size(min = 3, max = 128)
    private String nombre;

    public BookSerie(String nombre) {
        this.nombre = nombre;
    }
}
