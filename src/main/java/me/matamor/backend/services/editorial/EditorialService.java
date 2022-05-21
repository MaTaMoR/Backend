package me.matamor.backend.services.editorial;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.matamor.backend.models.editorial.Editorial;
import me.matamor.backend.repositories.EditorialRepository;
import me.matamor.backend.services.BasicService;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class EditorialService implements BasicService<Editorial, EditorialRepository> {

    private final EditorialRepository repository;

}
