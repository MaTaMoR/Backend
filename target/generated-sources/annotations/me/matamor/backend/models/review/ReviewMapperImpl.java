package me.matamor.backend.models.review;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import me.matamor.backend.auth.requests.AuthUserResponse;
import me.matamor.backend.filter.review.ReviewFilter;
import me.matamor.backend.models.book.BookMapper;
import me.matamor.backend.models.image.ImageMapper;
import me.matamor.backend.models.permissions.role.Role;
import me.matamor.backend.models.permissions.role.RoleResponse;
import me.matamor.backend.models.user.User;
import me.matamor.backend.models.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-25T22:19:53+0200",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 15.0.2 (Amazon.com Inc.)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    private final BookMapper bookMapper;
    private final UserMapper userMapper;
    private final ImageMapper imageMapper;

    @Autowired
    public ReviewMapperImpl(BookMapper bookMapper, UserMapper userMapper, ImageMapper imageMapper) {

        this.bookMapper = bookMapper;
        this.userMapper = userMapper;
        this.imageMapper = imageMapper;
    }

    @Override
    public Review toEntity(ReviewRequest request) {
        if ( request == null ) {
            return null;
        }

        Review review = new Review();

        if ( request.getId() != null ) {
            review.setId( Long.parseLong( request.getId() ) );
        }
        review.setAutor( userMapper.toEntity( request.getAutor() ) );
        review.setBook( bookMapper.toEntity( request.getBook() ) );
        review.setReview( request.getReview() );
        if ( request.getScore() != null ) {
            review.setScore( request.getScore() );
        }

        return review;
    }

    @Override
    public ReviewFilter toFilter(ReviewRequest request) {
        if ( request == null ) {
            return null;
        }

        ReviewFilter.ReviewFilterBuilder reviewFilter = ReviewFilter.builder();

        if ( request.getId() != null ) {
            reviewFilter.id( Long.parseLong( request.getId() ) );
        }
        reviewFilter.book( bookMapper.toFilter( request.getBook() ) );
        reviewFilter.review( request.getReview() );
        reviewFilter.score( request.getScore() );
        reviewFilter.reviewCriteria( request.getReviewCriteria() );
        reviewFilter.scoreCriteria( request.getScoreCriteria() );
        reviewFilter.reviewDateCriteria( request.getReviewDateCriteria() );

        return reviewFilter.build();
    }

    @Override
    public ReviewResponse toResponse(Review entity) {
        if ( entity == null ) {
            return null;
        }

        ReviewResponse reviewResponse = new ReviewResponse();

        reviewResponse.setId( String.valueOf( entity.getId() ) );
        reviewResponse.setAutor( userToAuthUserResponse( entity.getAutor() ) );
        reviewResponse.setBook( bookMapper.toResponse( entity.getBook() ) );
        reviewResponse.setReview( entity.getReview() );
        reviewResponse.setImage( imageMapper.toResponse( entity.getImage() ) );
        reviewResponse.setScore( entity.getScore() );
        reviewResponse.setReviewDate( entity.getReviewDate() );

        return reviewResponse;
    }

    protected RoleResponse roleToRoleResponse(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleResponse roleResponse = new RoleResponse();

        roleResponse.setName( role.getName() );

        return roleResponse;
    }

    protected List<RoleResponse> roleListToRoleResponseList(List<Role> list) {
        if ( list == null ) {
            return null;
        }

        List<RoleResponse> list1 = new ArrayList<RoleResponse>( list.size() );
        for ( Role role : list ) {
            list1.add( roleToRoleResponse( role ) );
        }

        return list1;
    }

    protected AuthUserResponse userToAuthUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        AuthUserResponse authUserResponse = new AuthUserResponse();

        authUserResponse.setUsername( user.getUsername() );
        authUserResponse.setName( user.getName() );
        authUserResponse.setSurnames( user.getSurnames() );
        authUserResponse.setEmail( user.getEmail() );
        authUserResponse.setImage( imageMapper.toResponse( user.getImage() ) );
        authUserResponse.setRoles( roleListToRoleResponseList( user.getRoles() ) );

        return authUserResponse;
    }
}
