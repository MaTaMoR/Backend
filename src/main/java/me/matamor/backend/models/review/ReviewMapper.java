package me.matamor.backend.models.review;

import me.matamor.backend.filter.review.ReviewFilter;
import me.matamor.backend.models.book.BookMapper;
import me.matamor.backend.models.image.ImageMapper;
import me.matamor.backend.models.user.UserMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = {BookMapper.class, UserMapper.class, ImageMapper.class})
public interface ReviewMapper {

    Review toEntity(ReviewRequest request);

    ReviewFilter toFilter(ReviewRequest request);

    ReviewResponse toResponse(Review entity);

}
