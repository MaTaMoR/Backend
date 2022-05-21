package me.matamor.backend.controllers.impl.book;

import lombok.RequiredArgsConstructor;
import me.matamor.backend.controllers.api.book.BookController;
import me.matamor.backend.filter.FilterRequest;
import me.matamor.backend.filter.book.BookFilter;
import me.matamor.backend.models.book.Book;
import me.matamor.backend.models.book.BookMapper;
import me.matamor.backend.models.book.BookRequest;
import me.matamor.backend.models.book.BookResponse;
import me.matamor.backend.models.page.PageResponse;
import me.matamor.backend.models.page.PageableMapper;
import me.matamor.backend.models.page.response.PageableResponse;
import me.matamor.backend.services.book.BookService;
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
public class BookControllerImpl implements BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;
    private final SimpleValidator validator;
    private final PageableMapper pageableMapper;

    @Override
    public ResponseEntity<BookResponse> find(Long id) {
        Book book = this.bookService.findById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            BookResponse response = this.bookMapper.toResponse(book);
            return ResponseEntity.ok(response);
        }
    }

    @Override
    public ResponseEntity<PageResponse<BookResponse>> find(@Valid FilterRequest<BookRequest> request) {
        if (this.validator.isValid(request.getFilter(), request.getPage())) {
            //Create the filter using the request
            BookFilter filter = this.bookMapper.toFilter(request.getFilter());
            PageRequest pageRequest = this.pageableMapper.toRequest(request.getPage());

            //Filter repository
            Page<Book> result = this.bookService.findByFilterPaged(filter, pageRequest);

            //Map result to response
            List<BookResponse> resultContent = result.getContent().stream()
                    .map(this.bookMapper::toResponse)
                    .collect(Collectors.toList());

            PageableResponse resultPageable = this.pageableMapper.toResponse(result);

            //Create page result
            PageResponse<BookResponse> response = new PageResponse<>(resultContent, resultPageable);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}