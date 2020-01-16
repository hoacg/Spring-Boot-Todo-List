package my.app.has.products.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    private List<Product> products;
    @ManyToOne
    private Customer customer;
    private double purchaseTotal;
}
