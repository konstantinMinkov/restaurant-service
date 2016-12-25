package ua.kpi.integrations.restaurant.web;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.kpi.integrations.restaurant.domain.User;
import ua.kpi.integrations.restaurant.dto.RegistrationUserDto;
import ua.kpi.integrations.restaurant.services.UserService;

import javax.validation.Valid;


@RestController
@RequestMapping("api/users")
@Api(value = "users", description = "Contains methods to work with users", produces = "application/json")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{name}")
    @ApiOperation(value = "Returns user entity by name")
    public User getUserByName(@PathVariable("name") String name) {
        return userService.findUserByUsername(name);
    }

    @PostMapping(path = "/new")
    @ApiOperation(value = "Registers new user in application")
    public void createUser(@Valid @RequestBody RegistrationUserDto user) {
        userService.registerUser(user);
    }
}
