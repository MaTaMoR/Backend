package me.matamor.backend.controllers;

import me.matamor.backend.filter.RepositoryFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BasicJpaRepository<T, K> extends JpaRepository<T, K>, JpaSpecificationExecutor<T> {

    default T findOneByFilter(RepositoryFilter<T> filter) {
        return findOne(filter.getSpecifications()).orElse(null);
    }

    default List<T> findAllByFilter(RepositoryFilter<T> filter) {
        return findAll(filter.getSpecifications());
    }

    default Page<T> findAllByFilterPaged(RepositoryFilter<T> filter, Pageable pageable) {
        Specification<T> specification = filter.getSpecifications();
        return specification == null ? findAll(pageable) : findAll(specification, pageable);
    }
}
