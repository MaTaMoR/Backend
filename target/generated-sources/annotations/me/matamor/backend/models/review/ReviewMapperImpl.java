package me.matamor.backend.models.review;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import me.matamor.backend.auth.requests.AuthUserResponse;
import me.matamor.backend.filter.review.ReviewFilter;
import me.matamor.backend.models.book.BookMapper;
import me.matamor.backend.models.image.Image;
import me.matamor.backend.models.image.ImageMapper;
import me.matamor.backend.models.image.ImageResponse;
import me.matamor.backend.models.likes.Like;
import me.matamor.backend.models.permissions.privilege.Privilege;
import me.matamor.backend.models.permissions.privilege.PrivilegeResponse;
import me.matamor.backend.models.permissions.role.Role;
import me.matamor.backend.models.permissions.role.RoleResponse;
import me.matamor.backend.models.user.User;
import me.matamor.backend.models.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-01T12:36:50+0200",
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
    public Review toEntity(ReviewResponse response) {
        if ( response == null ) {
            return null;
        }

        Review review = new Review();

        if ( response.getId() != null ) {
            review.setId( Long.parseLong( response.getId() ) );
        }
        review.setAutor( authUserResponseToUser( response.getAutor() ) );
        review.setBook( bookMapper.toEntity( response.getBook() ) );
        review.setReview( response.getReview() );
        review.setImage( imageResponseToImage( response.getImage() ) );
        review.setScore( response.getScore() );
        review.setReviewDate( response.getReviewDate() );
        List<Like> list = response.getLikes();
        if ( list != null ) {
            review.setLikes( new ArrayList<Like>( list ) );
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

        if ( entity.getId() != null ) {
            reviewResponse.setId( String.valueOf( entity.getId() ) );
        }
        reviewResponse.setAutor( userToAuthUserResponse( entity.getAutor() ) );
        reviewResponse.setBook( bookMapper.toResponse( entity.getBook() ) );
        reviewResponse.setReview( entity.getReview() );
        reviewResponse.setImage( imageMapper.toResponse( entity.getImage() ) );
        reviewResponse.setScore( entity.getScore() );
        reviewResponse.setReviewDate( entity.getReviewDate() );
        List<Like> list = entity.getLikes();
        if ( list != null ) {
            reviewResponse.setLikes( new ArrayList<Like>( list ) );
        }

        return reviewResponse;
    }

    protected Image imageResponseToImage(ImageResponse imageResponse) {
        if ( imageResponse == null ) {
            return null;
        }

        Image.ImageBuilder image = Image.builder();

        if ( imageResponse.getId() != null ) {
            image.id( Long.parseLong( imageResponse.getId() ) );
        }
        image.name( imageResponse.getName() );
        image.type( imageResponse.getType() );

        return image.build();
    }

    protected Privilege privilegeResponseToPrivilege(PrivilegeResponse privilegeResponse) {
        if ( privilegeResponse == null ) {
            return null;
        }

        Privilege privilege = new Privilege();

        if ( privilegeResponse.getId() != null ) {
            privilege.setId( Long.parseLong( privilegeResponse.getId() ) );
        }
        privilege.setName( privilegeResponse.getName() );

        return privilege;
    }

    protected List<Privilege> privilegeResponseListToPrivilegeList(List<PrivilegeResponse> list) {
        if ( list == null ) {
            return null;
        }

        List<Privilege> list1 = new ArrayList<Privilege>( list.size() );
        for ( PrivilegeResponse privilegeResponse : list ) {
            list1.add( privilegeResponseToPrivilege( privilegeResponse ) );
        }

        return list1;
    }

    protected Role roleResponseToRole(RoleResponse roleResponse) {
        if ( roleResponse == null ) {
            return null;
        }

        Role role = new Role();

        if ( roleResponse.getId() != null ) {
            role.setId( Long.parseLong( roleResponse.getId() ) );
        }
        role.setName( roleResponse.getName() );
        role.setPrivileges( privilegeResponseListToPrivilegeList( roleResponse.getPrivileges() ) );

        return role;
    }

    protected List<Role> roleResponseListToRoleList(List<RoleResponse> list) {
        if ( list == null ) {
            return null;
        }

        List<Role> list1 = new ArrayList<Role>( list.size() );
        for ( RoleResponse roleResponse : list ) {
            list1.add( roleResponseToRole( roleResponse ) );
        }

        return list1;
    }

    protected User authUserResponseToUser(AuthUserResponse authUserResponse) {
        if ( authUserResponse == null ) {
            return null;
        }

        User user = new User();

        if ( authUserResponse.getId() != null ) {
            user.setId( Long.parseLong( authUserResponse.getId() ) );
        }
        user.setUsername( authUserResponse.getUsername() );
        user.setName( authUserResponse.getName() );
        user.setSurnames( authUserResponse.getSurnames() );
        user.setEmail( authUserResponse.getEmail() );
        user.setImage( imageResponseToImage( authUserResponse.getImage() ) );
        user.setRoles( roleResponseListToRoleList( authUserResponse.getRoles() ) );

        return user;
    }

    protected PrivilegeResponse privilegeToPrivilegeResponse(Privilege privilege) {
        if ( privilege == null ) {
            return null;
        }

        PrivilegeResponse privilegeResponse = new PrivilegeResponse();

        if ( privilege.getId() != null ) {
            privilegeResponse.setId( String.valueOf( privilege.getId() ) );
        }
        privilegeResponse.setName( privilege.getName() );

        return privilegeResponse;
    }

    protected List<PrivilegeResponse> privilegeListToPrivilegeResponseList(List<Privilege> list) {
        if ( list == null ) {
            return null;
        }

        List<PrivilegeResponse> list1 = new ArrayList<PrivilegeResponse>( list.size() );
        for ( Privilege privilege : list ) {
            list1.add( privilegeToPrivilegeResponse( privilege ) );
        }

        return list1;
    }

    protected RoleResponse roleToRoleResponse(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleResponse roleResponse = new RoleResponse();

        if ( role.getId() != null ) {
            roleResponse.setId( String.valueOf( role.getId() ) );
        }
        roleResponse.setName( role.getName() );
        roleResponse.setPrivileges( privilegeListToPrivilegeResponseList( role.getPrivileges() ) );

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

        if ( user.getId() != null ) {
            authUserResponse.setId( String.valueOf( user.getId() ) );
        }
        authUserResponse.setUsername( user.getUsername() );
        authUserResponse.setName( user.getName() );
        authUserResponse.setSurnames( user.getSurnames() );
        authUserResponse.setEmail( user.getEmail() );
        authUserResponse.setImage( imageMapper.toResponse( user.getImage() ) );
        authUserResponse.setRoles( roleListToRoleResponseList( user.getRoles() ) );

        return authUserResponse;
    }
}
