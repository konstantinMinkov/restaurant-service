package ua.kpi.integrations.restaurant.web.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import ua.kpi.integrations.restaurant.domain.User;
import ua.kpi.integrations.restaurant.services.SimpleUserService;
import ua.kpi.integrations.restaurant.services.UserService;

import java.util.Collection;


@Component
@Import(SimpleUserService.class)
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private UserService userService;

    @Autowired
    public CustomAuthenticationProvider(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        User user = userService.findUserByUsername(username);

        if (user == null) {
            throw new BadCredentialsException("{\"error\":\"login_auth_err\"}");
        }

        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("{\"error\":\"password_auth_err\"}");
        }

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}