package ua.kpi.integrations.restaurant.dto;


import lombok.Data;
import lombok.experimental.Accessors;
import ua.kpi.integrations.restaurant.domain.Product;


@Data
@Accessors(chain = true)
public class ProductWithoutDescriptionDto {

    private Long id;
    private String name;
    private String imageUrl;

    public static ProductWithoutDescriptionDto fromProduct(Product product) {
        return new ProductWithoutDescriptionDto()
                        .setId(product.getId())
                        .setName(product.getName())
                        .setImageUrl(product.getImageUrl());
    }
}
