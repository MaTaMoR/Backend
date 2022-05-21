package me.matamor.backend.filter.user;

import lombok.*;
import me.matamor.backend.filter.FilterCriteria;
import me.matamor.backend.filter.RepositoryFilter;
import me.matamor.backend.filter.SpecificationBuilder;
import me.matamor.backend.models.user.User;
import me.matamor.backend.models.user.User_;
import org.springframework.data.jpa.domain.Specification;

import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFilter implements RepositoryFilter<User> {

    private Long id;

    @Size(min = 3, max = 16)
    private String username;

    @Size(min = 3, max = 16)
    private String name;

    @Size(min = 3, max = 32)
    private String surnames;

    @Builder.Default
    private FilterCriteria usernameCriteria = FilterCriteria.EQUAL;

    @Builder.Default
    private FilterCriteria nameCriteria = FilterCriteria.EQUAL;

    @Builder.Default
    private FilterCriteria surnamesCriteria = FilterCriteria.EQUAL;

    @Override
    public Specification<User> getSpecifications() {
        return new SpecificationBuilder<User>()
                .add(getIdSpecification())
                .add(getUsernameSpecification())
                .add(getNameSpecification())
                .add(getSurnamesSpecification())
                .build();
    }

    private Specification<User> getIdSpecification() {
        if (this.id == null) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(User_.id), this.id));
    }

    private Specification<User> getUsernameSpecification() {
        if (this.username == null || this.username.isEmpty()) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            if (FilterCriteria.EQUAL.equals(this.usernameCriteria)) {
                return criteriaBuilder.equal(root.get(User_.username), this.username);
            } else if (FilterCriteria.LIKE.equals(this.usernameCriteria)) {
                return criteriaBuilder.equal(root.get(User_.username), like(this.username));
            } else {
                throw new IllegalArgumentException("Criteria for the attribute 'username' is not valid: " + this.usernameCriteria);
            }
        });
    }

    private Specification<User> getNameSpecification() {
        if (this.name == null || this.name.isEmpty()) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            if (FilterCriteria.EQUAL.equals(this.nameCriteria)) {
                return criteriaBuilder.equal(root.get(User_.name), this.name);
            } else if (FilterCriteria.LIKE.equals(this.nameCriteria)) {
                return criteriaBuilder.equal(root.get(User_.name), like(this.name));
            } else {
                throw new IllegalArgumentException("Criteria for the attribute 'name' is not valid: " + this.nameCriteria);
            }
        });
    }


    private Specification<User> getSurnamesSpecification() {
        if (this.surnames == null || this.surnames.isEmpty()) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            if (FilterCriteria.EQUAL.equals(this.surnamesCriteria)) {
                return criteriaBuilder.equal(root.get(User_.surnames), this.surnames);
            } else if (FilterCriteria.LIKE.equals(this.surnamesCriteria)) {
                return criteriaBuilder.equal(root.get(User_.surnames), like(this.surnames));
            } else {
                throw new IllegalArgumentException("Criteria for the attribute 'surnames' is not valid: " + this.surnamesCriteria);
            }
        });
    }
}
