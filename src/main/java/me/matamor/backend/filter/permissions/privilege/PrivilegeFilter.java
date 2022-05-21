package me.matamor.backend.filter.permissions.privilege;

import lombok.*;
import me.matamor.backend.filter.FilterCriteria;
import me.matamor.backend.filter.RepositoryFilter;
import me.matamor.backend.filter.SpecificationBuilder;
import me.matamor.backend.models.permissions.privilege.Privilege;
import me.matamor.backend.models.permissions.privilege.Privilege_;
import org.springframework.data.jpa.domain.Specification;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrivilegeFilter implements RepositoryFilter<Privilege> {

    private Long id;
    private String name;

    @Builder.Default
    private FilterCriteria nameCriteria = FilterCriteria.EQUAL;

    @Override
    public Specification<Privilege> getSpecifications() {
        return new SpecificationBuilder<Privilege>()
                .add(getIdSpecification())
                .add(getNameSpecification())
                .build();
    }

    private Specification<Privilege> getIdSpecification() {
        if (this.id == null) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Privilege_.id), this.id));
    }

    private Specification<Privilege> getNameSpecification() {
        if (this.name == null || this.name.isEmpty()) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            if (FilterCriteria.EQUAL.equals(this.nameCriteria)) {
                return criteriaBuilder.equal(root.get(Privilege_.name), this.name);
            } else if (FilterCriteria.LIKE.equals(this.nameCriteria)) {
                return criteriaBuilder.equal(root.get(Privilege_.name), like(this.name));
            } else {
                throw new IllegalArgumentException("Criteria for the attribute 'name' is not valid: " + this.nameCriteria);
            }
        });
    }
}
