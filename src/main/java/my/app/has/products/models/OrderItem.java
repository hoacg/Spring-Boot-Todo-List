package my.app.has.products.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class OrderItem {
    private Product product;
    private int quantity;
}
