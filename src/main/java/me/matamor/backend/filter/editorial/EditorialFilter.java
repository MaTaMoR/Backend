package me.matamor.backend.filter.editorial;

import lombok.*;
import me.matamor.backend.filter.FilterCriteria;
import me.matamor.backend.filter.RepositoryFilter;
import me.matamor.backend.filter.SpecificationBuilder;
import me.matamor.backend.models.editorial.Editorial;
import me.matamor.backend.models.editorial.Editorial_;
import org.springframework.data.jpa.domain.Specification;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditorialFilter implements RepositoryFilter<Editorial> {

    @Builder.Default
    private final FilterCriteria nameCriteria = FilterCriteria.EQUAL;
    private Long id;
    private String name;

    @Override
    public Specification<Editorial> getSpecifications() {
        return new SpecificationBuilder<Editorial>()
                .add(getIdSpecification())
                .add(getNameSpecification())
                .build();
    }

    private Specification<Editorial> getIdSpecification() {
        if (this.id == null) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Editorial_.id), this.id));
    }

    private Specification<Editorial> getNameSpecification() {
        if (this.name == null || this.name.isEmpty()) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            if (FilterCriteria.EQUAL.equals(this.nameCriteria)) {
                return criteriaBuilder.equal(root.get(Editorial_.name), this.name);
            } else if (FilterCriteria.LIKE.equals(this.nameCriteria)) {
                return criteriaBuilder.like(root.get(Editorial_.name), like(this.name));
            } else {
                throw new IllegalArgumentException("Criteria for the attribute 'name' is not valid: " + this.nameCriteria);
            }
        });
    }
}
