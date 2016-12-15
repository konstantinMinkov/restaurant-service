package ua.kpi.integrations.restaurant.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;


@Data
@EqualsAndHashCode(exclude = "id")
@Entity
public class User {

    @TableGenerator(name="user_generator")
    @Id @GeneratedValue(generator="user_generator")
    private Long id;
    private String username;
    private String email;
    private String password;
    @ManyToMany
    @JoinTable(name = "users_to_authorities")
    private Set<Authority> authorities;
}
