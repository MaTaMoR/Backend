package me.matamor.backend.filter;

import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class SpecificationBuilder<T> {

    private final List<Specification<T>> specifications;
    private final boolean and;

    public SpecificationBuilder() {
        this(true);
    }

    public SpecificationBuilder(boolean and) {
        this(new ArrayList<>(), and);
    }

    public SpecificationBuilder(List<Specification<T>> specifications) {
        this(specifications, true);
    }

    public SpecificationBuilder(List<Specification<T>> specifications, boolean and) {
        this.specifications = specifications;
        this.and = and;
    }

    public SpecificationBuilder<T> add(Specification<T> specification) {
        if (specification != null) {
            this.specifications.add(specification);
        }

        return this;
    }

    public Specification<T> build() {
        if (this.specifications.isEmpty()) {
            return null;
        }

        Specification<T> specification = this.specifications.get(0);

        for (int i = 1; this.specifications.size() > i; i++) {
            if (this.and) {
                specification = specification.and(this.specifications.get(i));
            } else {
                specification = specification.or(this.specifications.get(i));
            }
        }

        return specification;
    }
}
