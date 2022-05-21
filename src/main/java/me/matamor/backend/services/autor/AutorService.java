package me.matamor.backend.services.autor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.matamor.backend.models.autor.Autor;
import me.matamor.backend.repositories.AutorRepository;
import me.matamor.backend.services.BasicService;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class AutorService implements BasicService<Autor, AutorRepository> {

    private final AutorRepository repository;

}
