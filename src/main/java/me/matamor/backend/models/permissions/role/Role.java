package me.matamor.backend.models.permissions.role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.matamor.backend.models.permissions.privilege.Privilege;
import me.matamor.backend.models.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private List<Privilege> privileges;

    public Role(String name, List<Privilege> privileges) {
        this.name = name;
        this.privileges = privileges;
    }
}