package ua.kpi.integrations.restaurant.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;


@Data
@Accessors(chain = true)
@EqualsAndHashCode(exclude = "id")
@Entity
public class Product {

    @TableGenerator(name = "product_generator")
    @Id @GeneratedValue(generator = "product_generator")
    private Long id;
    private String name;
    private String imageUrl;
    private String description;
}
