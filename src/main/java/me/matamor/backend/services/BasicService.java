package me.matamor.backend.services;

import me.matamor.backend.controllers.BasicJpaRepository;
import me.matamor.backend.filter.RepositoryFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BasicService<K, V extends BasicJpaRepository<K, Long>> {

    V getRepository();

    default K findById(long id) {
        return getRepository().findById(id).orElse(null);
    }

    default K findOneByFilter(RepositoryFilter<K> filter) {
        return getRepository().findOneByFilter(filter);
    }

    default List<K> findByFilter(RepositoryFilter<K> filter) {
        return getRepository().findAllByFilter(filter);
    }

    default Page<K> findByFilterPaged(RepositoryFilter<K> filter, Pageable pageable) {
        return getRepository().findAllByFilterPaged(filter, pageable);
    }

    default K save(K entity) {
        return getRepository().save(entity);
    }

    default List<K> findAll() {
        return getRepository().findAll();
    }

    default void delete(K entity) {
        getRepository().delete(entity);
    }
}
