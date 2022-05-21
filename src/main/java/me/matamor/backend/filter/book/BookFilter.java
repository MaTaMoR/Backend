package me.matamor.backend.filter.book;

import lombok.*;
import me.matamor.backend.filter.FilterCriteria;
import me.matamor.backend.filter.RepositoryFilter;
import me.matamor.backend.filter.SpecificationBuilder;
import me.matamor.backend.filter.autor.AutorFilter;
import me.matamor.backend.filter.category.CategoryFilter;
import me.matamor.backend.filter.editorial.EditorialFilter;
import me.matamor.backend.models.autor.Autor;
import me.matamor.backend.models.book.Book;
import me.matamor.backend.models.book.Book_;
import me.matamor.backend.models.book.type.BookType;
import me.matamor.backend.models.category.Category;
import me.matamor.backend.models.editorial.Editorial;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookFilter implements RepositoryFilter<Book> {

    private Long id;
    private String title;
    private String description;
    private BookType bookType;
    private Date publishedDate;
    private Integer totalPages;

    private AutorFilter autor;
    private EditorialFilter editorial;
    private List<CategoryFilter> categories;

    @Builder.Default
    private FilterCriteria titleCriteria = FilterCriteria.EQUAL;

    @Builder.Default
    private FilterCriteria descriptionCriteria = FilterCriteria.EQUAL;

    @Builder.Default
    private FilterCriteria publishedDateCriteria = FilterCriteria.EQUAL;

    @Builder.Default
    private FilterCriteria totalPagesCriteria = FilterCriteria.EQUAL;

    @Builder.Default
    private FilterCriteria categoriesCriteria = FilterCriteria.AND;

    @Override
    public Specification<Book> getSpecifications() {
        return new SpecificationBuilder<Book>()
                .add(getIdSpecification())
                .add(getTitleSpecification())
                .add(getDescriptionSpecification())
                .add(getBookTypeSpecification())
                .add(getPublishedDateSpecification())
                .add(getTotalPagesSpecification())
                .add(getAutorSpecification())
                .add(getEditorialSpecification())
                .add(getCategoriesSpecification())
                .build();
    }

    private Specification<Book> getIdSpecification() {
        if (this.id == null) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Book_.id), this.id));
    }

    private Specification<Book> getTitleSpecification() {
        if (this.title == null || this.title.isEmpty()) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            if (FilterCriteria.EQUAL.equals(this.titleCriteria)) {
                return criteriaBuilder.equal(root.get(Book_.title), this.title);
            } else if (FilterCriteria.LIKE.equals(this.titleCriteria)) {
                return criteriaBuilder.like(root.get(Book_.title), like(this.title));
            } else {
                throw new IllegalArgumentException("Criteria for the attribute 'title' is not valid: " + this.titleCriteria);
            }
        });
    }

    private Specification<Book> getDescriptionSpecification() {
        if (this.description == null || this.description.isEmpty()) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            if (FilterCriteria.EQUAL.equals(this.descriptionCriteria)) {
                return criteriaBuilder.equal(root.get(Book_.description), this.description);
            } else if (FilterCriteria.LIKE.equals(this.descriptionCriteria)) {
                return criteriaBuilder.like(root.get(Book_.description), like(this.description));
            } else {
                throw new IllegalArgumentException("Criteria for the attribute 'description' is not valid: " + this.descriptionCriteria);
            }
        });
    }

    private Specification<Book> getBookTypeSpecification() {
        if (this.bookType == null) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Book_.bookType), this.bookType));
    }

    private Specification<Book> getPublishedDateSpecification() {
        if (this.publishedDate == null) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            if (FilterCriteria.EQUAL.equals(this.publishedDateCriteria)) {
                return criteriaBuilder.equal(root.get(Book_.publishedDate), this.publishedDate);
            } else if (FilterCriteria.GREATER.equals(this.publishedDateCriteria)) {
                return criteriaBuilder.greaterThan(root.get(Book_.publishedDate), this.publishedDate);
            } else if (FilterCriteria.GREATER_EQUAL.equals(this.publishedDateCriteria)) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get(Book_.publishedDate), this.publishedDate);
            } else if (FilterCriteria.LESS.equals(this.publishedDateCriteria)) {
                return criteriaBuilder.lessThan(root.get(Book_.publishedDate), this.publishedDate);
            } else if (FilterCriteria.LESS_EQUAL.equals(this.publishedDateCriteria)) {
                return criteriaBuilder.lessThanOrEqualTo(root.get(Book_.publishedDate), this.publishedDate);
            } else {
                throw new IllegalArgumentException("Criteria for the attribute 'publishedDate' is not valid: " + this.publishedDateCriteria);
            }
        });
    }

    private Specification<Book> getTotalPagesSpecification() {
        if (this.totalPages == null) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            if (FilterCriteria.EQUAL.equals(this.totalPagesCriteria)) {
                return criteriaBuilder.equal(root.get(Book_.totalPages), this.totalPages);
            } else if (FilterCriteria.GREATER.equals(this.totalPagesCriteria)) {
                return criteriaBuilder.greaterThan(root.get(Book_.totalPages), this.totalPages);
            } else if (FilterCriteria.GREATER_EQUAL.equals(this.totalPagesCriteria)) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get(Book_.totalPages), this.totalPages);
            } else if (FilterCriteria.LESS.equals(this.totalPagesCriteria)) {
                return criteriaBuilder.lessThan(root.get(Book_.totalPages), this.totalPages);
            } else if (FilterCriteria.LESS_EQUAL.equals(this.totalPagesCriteria)) {
                return criteriaBuilder.lessThanOrEqualTo(root.get(Book_.totalPages), this.totalPages);
            } else {
                throw new IllegalArgumentException("Criteria for the attribute 'totalPages' is not valid: " + this.totalPagesCriteria);
            }
        });
    }

    private Specification<Book> getAutorSpecification() {
        if (this.autor == null) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            Subquery<Autor> subQuery = query.subquery(Autor.class);
            Root<Autor> autorRoot = subQuery.from(Autor.class);

            Predicate wherePredicate = criteriaBuilder.equal(root.get(Book_.autor), autorRoot);

            Specification<Autor> autorSpecification = this.autor.getSpecifications();
            subQuery.select(autorRoot).where(wherePredicate, autorSpecification.toPredicate(autorRoot, query, criteriaBuilder));

            return criteriaBuilder.exists(subQuery);
        });
    }

    private Specification<Book> getEditorialSpecification() {
        if (this.editorial == null) {
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            Subquery<Editorial> subQuery = query.subquery(Editorial.class);
            Root<Editorial> editorialRoot = subQuery.from(Editorial.class);

            Predicate wherePredicate = criteriaBuilder.equal(root.get(Book_.editorial), editorialRoot);

            Specification<Editorial> autorSpecification = this.editorial.getSpecifications();
            subQuery.select(editorialRoot).where(wherePredicate, autorSpecification.toPredicate(editorialRoot, query, criteriaBuilder));

            return criteriaBuilder.exists(subQuery);
        });
    }

    private Specification<Book> getCategoriesSpecification() {
        if (this.categories == null || this.categories.isEmpty()) {
            return null;
        }

        if (!FilterCriteria.AND.equals(this.categoriesCriteria) && !FilterCriteria.OR.equals(this.categoriesCriteria)) {
            throw new IllegalArgumentException("Criteria for the attribute 'categories' is not valid: " + this.categoriesCriteria);
        }

        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            for (CategoryFilter filterRequest : this.categories) {
                Subquery<Category> subQuery = query.subquery(Category.class);
                Root<Category> categoryRoot = subQuery.from(Category.class);

                Specification<Category> categorySpecification = filterRequest.getSpecifications();
                Predicate wherePredicate = criteriaBuilder.isMember(categoryRoot, root.get(Book_.categories));

                subQuery.select(categoryRoot).where(wherePredicate, categorySpecification.toPredicate(categoryRoot, query, criteriaBuilder));

                predicates.add(criteriaBuilder.exists(subQuery));
            }

            Predicate predicate;
            if (FilterCriteria.AND.equals(this.categoriesCriteria)) {
                predicate = criteriaBuilder.and(predicates.toArray(Predicate[]::new));
            } else {
                predicate = criteriaBuilder.or(predicates.toArray(Predicate[]::new));
            }

            return predicate;
        });
    }
}
