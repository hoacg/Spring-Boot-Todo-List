package my.app.has.products.services;

import my.app.has.products.models.*;

import java.util.List;

public interface IOrderService {
    Order createOrder(Customer customer,
                      Discount discount,
                      List<OrderItem> orderItems
                      );
}
