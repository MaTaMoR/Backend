package me.matamor.backend.models.user;

import lombok.*;
import me.matamor.backend.models.image.Image;
import me.matamor.backend.models.permissions.role.Role;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Size(min = 3, max = 16)
    @Column(name = "username")
    private String username;

    @NotBlank
    @Size(min = 3, max = 16)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Size(min = 3, max = 32)
    @Column(name = "surnames")
    private String surnames;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "register_date")
    private Date registerDate;

    @NotBlank
    @Email
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "password")
    private String password;

    @Nullable
    @ManyToOne
    private Image image;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    public User(String username, String name, String surnames, String email, String password, List<Role> roles) {
        this.username = username;
        this.name = name;
        this.surnames = surnames;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
