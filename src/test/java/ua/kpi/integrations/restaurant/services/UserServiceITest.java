package ua.kpi.integrations.restaurant.services;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.kpi.integrations.restaurant.config.ApplicationConfig;
import ua.kpi.integrations.restaurant.domain.User;
import ua.kpi.integrations.restaurant.dto.RegistrationUserDto;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;


@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class UserServiceITest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UserService userService;

    @Test
    public void findNotExistingUserByUsername()  {
        assertThat(userService.findUserByUsername("name1"), is(nullValue()));
    }

    @Test
    public void registerUser() {
        User user = userService.registerUser(new RegistrationUserDto("name", "email", "password"));

        assertThat(user, is(new User(1L, "name", "email", "password", Collections.singleton(null))));
    }
}
