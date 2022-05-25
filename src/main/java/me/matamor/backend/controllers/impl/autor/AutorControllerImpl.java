package me.matamor.backend.controllers.impl.autor;

import lombok.RequiredArgsConstructor;
import me.matamor.backend.controllers.api.autor.AutorController;
import me.matamor.backend.filter.FilterRequest;
import me.matamor.backend.filter.autor.AutorFilter;
import me.matamor.backend.models.autor.Autor;
import me.matamor.backend.models.autor.AutorMapper;
import me.matamor.backend.models.autor.AutorRequest;
import me.matamor.backend.models.autor.AutorResponse;
import me.matamor.backend.models.page.PageResponse;
import me.matamor.backend.models.page.PageableMapper;
import me.matamor.backend.models.page.response.PageableResponse;
import me.matamor.backend.services.autor.AutorService;
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
public class AutorControllerImpl implements AutorController {

    private final AutorService autorService;
    private final AutorMapper autorMapper;
    private final SimpleValidator validator;
    private final PageableMapper pageableMapper;

    @Override
    public ResponseEntity<AutorResponse> find(Long id) {
        Autor autor = this.autorService.findById(id);
        if (autor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            AutorResponse response = this.autorMapper.toResponse(autor);
            return ResponseEntity.ok(response);
        }
    }

    @Override
    public ResponseEntity<PageResponse<AutorResponse>> find(@Valid FilterRequest<AutorRequest> request) {
        if (this.validator.isValid(request.getFilter(), request.getPage())) {
            //Create the filter using the request
            AutorFilter filter = this.autorMapper.toFilter(request.getFilter());
            PageRequest pageRequest = this.pageableMapper.toRequest(request.getPage());

            //Filter repository
            Page<Autor> result = this.autorService.findByFilterPaged(filter, pageRequest);

            //Map result to response
            List<AutorResponse> resultContent = result.getContent().stream()
                    .map(this.autorMapper::toResponse)
                    .collect(Collectors.toList());

            PageableResponse resultPageable = this.pageableMapper.toResponse(result);

            //Create page result
            PageResponse<AutorResponse> response = new PageResponse<>(resultContent, resultPageable);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
