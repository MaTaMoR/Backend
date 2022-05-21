package me.matamor.backend.repositories;

import me.matamor.backend.controllers.BasicJpaRepository;
import me.matamor.backend.models.likes.Like;

public interface LikeRepository extends BasicJpaRepository<Like, Long> {

}
