package ua.kpi.integrations.restaurant.domain;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
public class Authority implements GrantedAuthority {

    public static final String USER = "ROLE_USER";

    @Id
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
