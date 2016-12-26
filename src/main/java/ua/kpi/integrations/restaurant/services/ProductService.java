package ua.kpi.integrations.restaurant.services;


import ua.kpi.integrations.restaurant.domain.Product;

import java.util.List;


public interface ProductService {

    List<Product> findAll();
    Product findProductById(Long id);
}
