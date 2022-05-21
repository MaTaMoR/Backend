package me.matamor.backend.filter.autor;

import lombok.*;
import me.matamor.backend.filter.FilterCriteria;
import me.matamor.backend.filter.RepositoryFilter;
import me.matamor.backend.filter.SpecificationBuilder;
import me.matamor.backend.models.autor.Autor;
import me.matamor.backend.models.autor.Autor_;
import org.springframework.data.jpa.domain.Specification;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AutorFilter implements RepositoryFilter<Autor> {

    private Long id;
    private String name;
    private String surnames;

    @Builder.Default
    private FilterCriteria nameCriteria = FilterCriteria.EQUAL;

    @Builder.Default
    private FilterCriteria surnamesCriteria = FilterCriteria.EQUAL;

    @Override
    public Specification<Autor> getSpecifications() {
        return new SpecificationBuilder<Autor>()
                .add(getIdSpecification())
                .add(getNameSpecification())
                .add(getSurnamesSpecification())
                .build();
    }

    private Specification<Autor> getIdSpecification() {
        if (this.id == null) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Autor_.id), this.id));
    }

    private Specification<Autor> getNameSpecification() {
        if (this.name == null || this.name.isEmpty()) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            if (FilterCriteria.EQUAL.equals(this.nameCriteria)) {
                return criteriaBuilder.equal(root.get(Autor_.name), this.name);
            } else if (FilterCriteria.LIKE.equals(this.nameCriteria)) {
                return criteriaBuilder.like(root.get(Autor_.name), like(this.name));
            } else {
                throw new IllegalArgumentException("Criteria for the attribute 'title' is not valid: " + this.nameCriteria);
            }
        });
    }

    private Specification<Autor> getSurnamesSpecification() {
        if (this.surnames == null || this.surnames.isEmpty()) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            if (FilterCriteria.EQUAL.equals(this.surnamesCriteria)) {
                return criteriaBuilder.equal(root.get(Autor_.surnames), this.surnames);
            } else if (FilterCriteria.LIKE.equals(this.surnamesCriteria)) {
                return criteriaBuilder.like(root.get(Autor_.surnames), like(this.surnames));
            } else {
                throw new IllegalArgumentException("Criteria for the attribute 'description' is not valid: " + this.surnamesCriteria);
            }
        });
    }
}
