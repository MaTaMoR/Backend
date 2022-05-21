package me.matamor.backend.services.like;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.matamor.backend.models.likes.Like;
import me.matamor.backend.repositories.LikeRepository;
import me.matamor.backend.services.BasicService;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class LikeService implements BasicService<Like, LikeRepository> {

    private final LikeRepository repository;

}
