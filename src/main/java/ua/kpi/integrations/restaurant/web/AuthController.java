package ua.kpi.integrations.restaurant.web;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/auth")
public class AuthController {

    @GetMapping(path = "/logout")
    @ApiOperation(value = "Invalidates current session")
    public void logout() {
    }

    @PostMapping(path = "/login")
    @ApiOperation(value = "Returns session token to use with private API methods")
    public void login() {
    }
}
