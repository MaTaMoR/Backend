package me.matamor.backend.controllers.impl.editorial;

import lombok.RequiredArgsConstructor;
import me.matamor.backend.controllers.api.editorial.EditorialController;
import me.matamor.backend.filter.FilterRequest;
import me.matamor.backend.filter.editorial.EditorialFilter;
import me.matamor.backend.models.editorial.Editorial;
import me.matamor.backend.models.editorial.EditorialMapper;
import me.matamor.backend.models.editorial.EditorialRequest;
import me.matamor.backend.models.editorial.EditorialResponse;
import me.matamor.backend.models.page.PageResponse;
import me.matamor.backend.models.page.PageableMapper;
import me.matamor.backend.models.page.response.PageableResponse;
import me.matamor.backend.services.editorial.EditorialService;
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
public class EditorialControllerImp implements EditorialController {

    private final EditorialService editorialService;
    private final SimpleValidator validator;
    private final EditorialMapper editorialMapper;
    private final PageableMapper pageableMapper;

    @Override
    public ResponseEntity<EditorialResponse> find(Long id) {
        Editorial editorial = this.editorialService.findById(id);
        if (editorial == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            EditorialResponse response = this.editorialMapper.toResponse(editorial);
            return ResponseEntity.ok(response);
        }
    }

    @Override
    public ResponseEntity<PageResponse<EditorialResponse>> find(@Valid FilterRequest<EditorialRequest> request) {
        if (this.validator.isValid(request.getFilter(), request.getPage())) {
            //Create the filter using the request
            EditorialFilter filter = this.editorialMapper.toFilter(request.getFilter());
            PageRequest pageRequest = this.pageableMapper.toRequest(request.getPage());

            //Filter repository
            Page<Editorial> result = this.editorialService.findByFilterPaged(filter, pageRequest);

            //Map result to response
            List<EditorialResponse> resultContent = result.getContent().stream()
                    .map(this.editorialMapper::toResponse)
                    .collect(Collectors.toList());

            PageableResponse resultPageable = this.pageableMapper.toResponse(result);

            //Create page result
            PageResponse<EditorialResponse> response = new PageResponse<>(resultContent, resultPageable);

            return ResponseEntity.ok(response);
        } else {
            System.out.println("invalid");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
