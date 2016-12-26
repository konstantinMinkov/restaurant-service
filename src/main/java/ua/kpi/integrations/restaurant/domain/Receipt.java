package ua.kpi.integrations.restaurant.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Data
@Accessors(chain = true)
@EqualsAndHashCode(exclude = "id")
@Entity
public class Receipt {

    @TableGenerator(name = "receipt_generator")
    @Id @GeneratedValue(generator = "receipt_generator")
    private Long id;
    @ManyToOne
    private User user;
    @ManyToMany
    @JoinTable(name = "receipt_to_products")
    private List<Product> products;
    private Timestamp timestamp;
}
