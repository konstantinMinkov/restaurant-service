package ua.kpi.integrations.restaurant.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.integrations.restaurant.domain.User;
import ua.kpi.integrations.restaurant.repositories.UserRepository;


@Service
public class SimpleUserService implements UserService {

    private UserRepository userRepository;

    @Autowired
    public SimpleUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
