package ua.kpi.integrations.restaurant.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.kpi.integrations.restaurant.domain.Product;
import ua.kpi.integrations.restaurant.domain.User;
import ua.kpi.integrations.restaurant.dto.ProductWithoutDescriptionDto;
import ua.kpi.integrations.restaurant.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/products")
@Api(value = "products", description = "Contains methods to work with products", produces = "application/json")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "")
    @ApiOperation(value = "Returns all available products")
    public List<ProductWithoutDescriptionDto> getAllProducts() {
        return productService.findAll()
                               .stream()
                               .map(ProductWithoutDescriptionDto::fromProduct)
                               .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Returns product by it's id")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.findProductById(id);
    }
}
