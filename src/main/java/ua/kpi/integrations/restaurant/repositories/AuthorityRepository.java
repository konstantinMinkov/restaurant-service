package ua.kpi.integrations.restaurant.repositories;


import org.springframework.data.repository.Repository;
import ua.kpi.integrations.restaurant.domain.Authority;


public interface AuthorityRepository extends Repository<Authority, String> {

    Authority findAuthorityByAuthority(String authority);
}
