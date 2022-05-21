package me.matamor.backend.services.category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.matamor.backend.models.category.Category;
import me.matamor.backend.repositories.CategoryRepository;
import me.matamor.backend.services.BasicService;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class CategoryService implements BasicService<Category, CategoryRepository> {

    private final CategoryRepository repository;

}
