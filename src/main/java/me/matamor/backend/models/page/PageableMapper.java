package me.matamor.backend.models.page;

import me.matamor.backend.models.page.request.PageableRequest;
import me.matamor.backend.models.page.response.PageableResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PageableMapper {

    default PageRequest toRequest(PageableRequest request) {
        return request.toRequest();
    }

    default PageableResponse toResponse(Page<?> request) {
        return new PageableResponse(request);
    }
}