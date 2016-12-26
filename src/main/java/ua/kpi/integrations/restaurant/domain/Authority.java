package ua.kpi.integrations.restaurant.domain;


import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;


@Data
@Accessors(chain = true)
@Entity
public class Authority implements GrantedAuthority {

    public static final String USER = "ROLE_USER";

    @TableGenerator(name = "auth_generator")
    @Id @GeneratedValue(generator = "auth_generator")
    private Integer id;
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
