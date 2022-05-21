package me.matamor.backend.filter;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface RepositoryFilter<T> extends Specification<T> {

    Specification<T> getSpecifications();

    default String like(String value) {
        return value;
    }

    @Override
    default Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Specification<T> specifications = getSpecifications();
        return (specifications == null ? criteriaBuilder.conjunction() : specifications.toPredicate(root, query, criteriaBuilder));
    }
}
