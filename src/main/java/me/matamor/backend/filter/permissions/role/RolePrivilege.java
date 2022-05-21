package me.matamor.backend.filter.permissions.role;

import lombok.Builder;
import me.matamor.backend.filter.FilterCriteria;
import me.matamor.backend.filter.RepositoryFilter;
import me.matamor.backend.filter.SpecificationBuilder;
import me.matamor.backend.models.permissions.role.Role;
import me.matamor.backend.models.permissions.role.Role_;
import org.springframework.data.jpa.domain.Specification;

public class RolePrivilege implements RepositoryFilter<Role> {

    private Long id;
    private String name;

    @Builder.Default
    private FilterCriteria nameCriteria = FilterCriteria.EQUAL;

    @Override
    public Specification<Role> getSpecifications() {
        return new SpecificationBuilder<Role>()
                .add(getIdSpecification())
                .add(getNameSpecification())
                .build();
    }

    private Specification<Role> getIdSpecification() {
        if (this.id == null) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Role_.id), this.id));
    }

    private Specification<Role> getNameSpecification() {
        if (this.name == null || this.name.isEmpty()) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            if (FilterCriteria.EQUAL.equals(this.nameCriteria)) {
                return criteriaBuilder.equal(root.get(Role_.name), this.name);
            } else if (FilterCriteria.LIKE.equals(this.nameCriteria)) {
                return criteriaBuilder.equal(root.get(Role_.name), like(this.name));
            } else {
                throw new IllegalArgumentException("Criteria for the attribute 'name' is not valid: " + this.nameCriteria);
            }
        });
    }
}
