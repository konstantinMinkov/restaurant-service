package ua.kpi.integrations.restaurant.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kpi.integrations.restaurant.domain.Authority;
import ua.kpi.integrations.restaurant.domain.User;
import ua.kpi.integrations.restaurant.dto.RegistrationUserDto;
import ua.kpi.integrations.restaurant.repositories.AuthorityRepository;
import ua.kpi.integrations.restaurant.repositories.UserRepository;

import java.util.Collections;


@Service
public class SimpleUserService implements UserService {

    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;

    @Autowired
    public SimpleUserService(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Transactional
    @Override
    public User registerUser(RegistrationUserDto userDto) {
        User user = User.fromRegistrationUserDto(userDto);
        if (userRepository.existsByUsername(user.getUsername())) {
            return null;
        }
        setAuthorityTo(user);
        return userRepository.save(user);
    }

    private void setAuthorityTo(User user) {
        Authority authority = authorityRepository.findAuthorityByAuthority(Authority.USER);
        user.setAuthorities(Collections.singleton(authority));
    }
}
