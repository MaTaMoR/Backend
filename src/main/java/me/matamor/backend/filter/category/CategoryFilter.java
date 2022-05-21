package me.matamor.backend.filter.category;

import lombok.*;
import me.matamor.backend.filter.FilterCriteria;
import me.matamor.backend.filter.RepositoryFilter;
import me.matamor.backend.filter.SpecificationBuilder;
import me.matamor.backend.models.category.Category;
import me.matamor.backend.models.category.Category_;
import org.springframework.data.jpa.domain.Specification;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryFilter implements RepositoryFilter<Category> {

    private Long id;
    private String name;

    @Builder.Default
    private FilterCriteria nameCriteria = FilterCriteria.EQUAL;

    @Override
    public Specification<Category> getSpecifications() {
        return new SpecificationBuilder<Category>()
                .add(getIdSpecification())
                .add(getNameSpecification())
                .build();
    }

    private Specification<Category> getIdSpecification() {
        if (this.id == null) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Category_.id), this.id));
    }

    private Specification<Category> getNameSpecification() {
        if (this.name == null || this.name.isEmpty()) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            if (FilterCriteria.EQUAL.equals(this.nameCriteria)) {
                return criteriaBuilder.equal(root.get(Category_.name), this.name);
            } else if (FilterCriteria.LIKE.equals(this.nameCriteria)) {
                return criteriaBuilder.like(root.get(Category_.name), like(this.name));
            } else {
                throw new IllegalArgumentException("Criteria for the attribute 'name' is not valid: " + this.nameCriteria);
            }
        });
    }
}
