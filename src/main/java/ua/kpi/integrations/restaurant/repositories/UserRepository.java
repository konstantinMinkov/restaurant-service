package ua.kpi.integrations.restaurant.repositories;


import org.springframework.data.repository.CrudRepository;
import ua.kpi.integrations.restaurant.domain.User;


public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUsername(String username);
}
