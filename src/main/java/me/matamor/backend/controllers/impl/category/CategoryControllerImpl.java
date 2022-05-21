package me.matamor.backend.controllers.impl.category;

import lombok.RequiredArgsConstructor;
import me.matamor.backend.controllers.api.category.CategoryController;
import me.matamor.backend.filter.FilterRequest;
import me.matamor.backend.filter.category.CategoryFilter;
import me.matamor.backend.models.category.Category;
import me.matamor.backend.models.category.CategoryMapper;
import me.matamor.backend.models.category.CategoryRequest;
import me.matamor.backend.models.category.CategoryResponse;
import me.matamor.backend.models.page.PageResponse;
import me.matamor.backend.models.page.PageableMapper;
import me.matamor.backend.models.page.response.PageableResponse;
import me.matamor.backend.services.category.CategoryService;
import me.matamor.backend.util.validation.SimpleValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CategoryControllerImpl implements CategoryController {

    private final CategoryService categoryService;
    private final SimpleValidator validator;
    private final CategoryMapper categoryMapper;
    private final PageableMapper pageableMapper;

    @Override
    public ResponseEntity<CategoryResponse> find(Long id) {
        Category category = this.categoryService.findById(id);
        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            CategoryResponse response = this.categoryMapper.toResponse(category);
            return ResponseEntity.ok(response);
        }
    }

    @Override
    public ResponseEntity<PageResponse<CategoryResponse>> find(@Valid FilterRequest<CategoryRequest> request) {
        if (this.validator.isValid(request.getFilter(), request.getPage())) {
            //Create the filter using the request
            CategoryFilter filter = this.categoryMapper.toFilter(request.getFilter());
            PageRequest pageRequest = this.pageableMapper.toRequest(request.getPage());

            //Filter repository
            Page<Category> result = this.categoryService.findByFilterPaged(filter, pageRequest);

            //Map result to response
            List<CategoryResponse> resultContent = result.getContent().stream()
                    .map(this.categoryMapper::toResponse)
                    .collect(Collectors.toList());

            PageableResponse resultPageable = this.pageableMapper.toResponse(result);

            //Create page result
            PageResponse<CategoryResponse> response = new PageResponse<>(resultContent, resultPageable);

            return ResponseEntity.ok(response);
        } else {
            System.out.println("invalid");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
