package ua.kpi.integrations.restaurant.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ua.kpi.integrations.restaurant.domain.User;


public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUsername(String username);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.username = :username")
    boolean existsByUsername(@Param("username") String username);
}
