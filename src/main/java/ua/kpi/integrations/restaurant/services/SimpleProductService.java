package ua.kpi.integrations.restaurant.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.integrations.restaurant.domain.Product;
import ua.kpi.integrations.restaurant.repositories.ProductRepository;

import java.util.List;


@Service
public class SimpleProductService implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public SimpleProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findProductById(id);
    }
}
