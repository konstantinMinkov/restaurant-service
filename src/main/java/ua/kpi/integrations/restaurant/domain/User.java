package ua.kpi.integrations.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import ua.kpi.integrations.restaurant.dto.RegistrationUserDto;

import javax.persistence.*;
import java.util.Set;


@Data
@Accessors(chain = true)
@EqualsAndHashCode(exclude = "id")
@Entity
public class User {

    @TableGenerator(name = "user_generator")
    @Id
    @GeneratedValue(generator = "user_generator")
    private Long id;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "users_to_authorities")
    @JsonIgnore
    private Set<Authority> authorities;

    public static User fromRegistrationUserDto(RegistrationUserDto userDto) {
        return new User().setUsername(userDto.getLogin())
                          .setEmail(userDto.getEmail())
                          .setPassword(userDto.getPassword());
    }
}
