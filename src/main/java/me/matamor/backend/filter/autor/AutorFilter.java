package me.matamor.backend.filter.autor;

import lombok.*;
import me.matamor.backend.filter.FilterCriteria;
import me.matamor.backend.filter.RepositoryFilter;
import me.matamor.backend.filter.SpecificationBuilder;
import me.matamor.backend.models.autor.Autor;
import me.matamor.backend.models.autor.Autor_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Expression;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AutorFilter implements RepositoryFilter<Autor> {

    private Long id;
    private String name;
    private String surnames;
    private String fullName;

    @Builder.Default
    private FilterCriteria nameCriteria = FilterCriteria.EQUAL;

    @Builder.Default
    private FilterCriteria surnamesCriteria = FilterCriteria.EQUAL;

    @Builder.Default
    private FilterCriteria fullNameCriteria = FilterCriteria.EQUAL;

    @Override
    public Specification<Autor> getSpecifications() {
        return new SpecificationBuilder<Autor>()
                .add(getIdSpecification())
                .add(getNameSpecification())
                .add(getSurnamesSpecification())
                .add(getFullNameSpecification())
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

    private Specification<Autor> getFullNameSpecification() {
        if (this.fullName == null || this.fullName.isEmpty()) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            if (FilterCriteria.EQUAL.equals(this.fullNameCriteria)) {
                Expression<String> fullName  = criteriaBuilder.concat(root.get(Autor_.name), " ");
                fullName = criteriaBuilder.concat(fullName, root.get(Autor_.surnames));

                return criteriaBuilder.equal(fullName, this.fullName);
            } else if (FilterCriteria.LIKE.equals(this.fullNameCriteria)) {
                Expression<String> fullName  = criteriaBuilder.concat(root.get(Autor_.name), " ");
                fullName = criteriaBuilder.concat(fullName, root.get(Autor_.surnames));

                return criteriaBuilder.like(fullName, this.fullName);
            } else {
                throw new IllegalArgumentException("Criteria for the attribute 'fullName' is not valid: " + this.fullNameCriteria);
            }
        });
    }
}
