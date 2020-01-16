package my.app.has.products.services;

import my.app.has.products.models.*;
import my.app.has.products.repository.CustomerRepository;
import my.app.has.products.repository.DiscountRepository;
import my.app.has.products.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final DiscountRepository discountRepository;

    public OrderService(OrderRepository orderRepository,
                        CustomerRepository customerRepository,
                        DiscountRepository discountRepository
                        ) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.discountRepository = discountRepository;
    }

    @Override
    public Order createOrder(Customer customer, Discount discount, List<OrderItem> orderItems) {

        Order order = new Order();

        order.setCustomer(customer);

        List<Product> products = new ArrayList<>();

        double total = 0;

        for (OrderItem item: orderItems) {
            total += item.getProduct().getPrice() * item.getQuantity();
            products.add(item.getProduct());
        }

        if (discount != null) {
            total -= total * discount.getPercent() / 100;
        }

        order.setPurchaseTotal(total);
        order.setProducts(products);

        Order savedOrder = orderRepository.save(order);
        return savedOrder;
    }
}
