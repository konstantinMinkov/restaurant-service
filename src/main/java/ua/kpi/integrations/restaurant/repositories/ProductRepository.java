package ua.kpi.integrations.restaurant.repositories;


import org.springframework.data.repository.Repository;
import ua.kpi.integrations.restaurant.domain.Product;

import java.util.List;


public interface ProductRepository extends Repository<Product, Long> {

    List<Product> findAll();
    Product findProductById(Long id);
}
