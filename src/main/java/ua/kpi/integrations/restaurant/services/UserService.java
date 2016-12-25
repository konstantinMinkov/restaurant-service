package ua.kpi.integrations.restaurant.services;


import ua.kpi.integrations.restaurant.domain.User;
import ua.kpi.integrations.restaurant.dto.RegistrationUserDto;


public interface UserService {

    User findUserByUsername(String username);
    User registerUser(RegistrationUserDto userDto);
}
