package me.matamor.backend.services.book;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.matamor.backend.models.book.Book;
import me.matamor.backend.repositories.BookRepository;
import me.matamor.backend.services.BasicService;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class BookService implements BasicService<Book, BookRepository> {

    private final BookRepository repository;

}
