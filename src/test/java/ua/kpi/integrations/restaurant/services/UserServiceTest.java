package ua.kpi.integrations.restaurant.services;

import org.junit.Before;
import org.junit.Test;
import ua.kpi.integrations.restaurant.domain.Authority;
import ua.kpi.integrations.restaurant.domain.User;
import ua.kpi.integrations.restaurant.dto.RegistrationUserDto;
import ua.kpi.integrations.restaurant.repositories.AuthorityRepository;
import ua.kpi.integrations.restaurant.repositories.UserRepository;

import java.util.Collections;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UserServiceTest {

    private UserService userService;

    @Before
    public void initMock() {
        Set<Authority> authorities = Collections.singleton(new Authority().setAuthority(Authority.USER));
        User user0 = new User(null, "name", "email", "pass", authorities);

        UserRepository userRepository = mock(UserRepository.class);

        when(userRepository.save(user0)).thenReturn(user0.setId(1L));
        when(userRepository.existsByUsername("name")).thenReturn(false);
        when(userRepository.existsByUsername("name1")).thenReturn(true);
        when(userRepository.findUserByUsername("name")).thenReturn(user0.setId(1L));

        AuthorityRepository authorityRepository = mock(AuthorityRepository.class);

        when(authorityRepository.findAuthorityByAuthority(Authority.USER))
                                .thenReturn(new Authority().setAuthority(Authority.USER));

        userService = new SimpleUserService(userRepository, authorityRepository);
    }

    @Test
    public void findUserByUsername() throws Exception {
        Set<Authority> authorities = Collections.singleton(new Authority().setAuthority(Authority.USER));
        User user = new User(1L, "name", "email", "pass", authorities);

        assertThat(userService.findUserByUsername("name"), is(user));
    }

    @Test
    public void registerUser() throws Exception {
        RegistrationUserDto userDto = new RegistrationUserDto("name", "email", "pass");
        Set<Authority> authorities = Collections.singleton(new Authority().setAuthority(Authority.USER));
        User user = new User(1L, "name", "email", "pass", authorities);

        assertThat(userService.registerUser(userDto), is(user));
    }

    @Test
    public void registerExistingUser() throws Exception {
        RegistrationUserDto userDto = new RegistrationUserDto("name1", "email1", "pass1");

        assertThat(userService.registerUser(userDto), is(nullValue()));
    }
}