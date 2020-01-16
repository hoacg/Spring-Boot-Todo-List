package my.app.has.products.services;

import my.app.has.products.models.*;
import my.app.has.products.repository.CustomerRepository;
import my.app.has.products.repository.DiscountRepository;
import my.app.has.products.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

class OrderServiceTest {

    private final OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
    private final CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
    private final DiscountRepository discountRepository = Mockito.mock(DiscountRepository.class);

    private final IOrderService orderService = new OrderService(orderRepository, customerRepository, discountRepository);

    private List<Product> initProductList() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("iPhone XX");
        product1.setPrice(50000000D);

        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("MacBook Pro 2019");
        product2.setPrice(50000000D);

        return Arrays.asList(product1, product2);
    }

    private List<OrderItem> initOrderItemList() {
        List<Product> products = this.initProductList();
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProduct(products.get(0));
        orderItem1.setQuantity(2);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct(products.get(1));
        orderItem2.setQuantity(1);

        return Arrays.asList(orderItem1, orderItem2);
    }

    Customer initCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Test Customer");
        return customer;
    }

    Order initOrder() {
        Order order = new Order();
        order.setCustomer(initCustomer());
        order.setProducts(this.initProductList());
        order.setPurchaseTotal(150000000D);

        return order;
    }

    Order initDiscountOrder() {
        Order order = new Order();
        order.setCustomer(initCustomer());
        order.setProducts(this.initProductList());
        order.setPurchaseTotal(150000000D);
        return order;
    }

    @BeforeEach
    void init() {
        Order newOrder = this.initOrder();
        newOrder.setPurchaseTotal(150000000D);
//        Order noDiscountOrder = new Order();
//        noDiscountOrder.setId(1L);
//        noDiscountOrder.setCustomer(initCustomer());


        Order discountOrder = this.initDiscountOrder();
//        Order discountedOrder = new Order();
//        discountedOrder.setId(1L);
//        discountedOrder.setCustomer(initCustomer());
        discountOrder.setPurchaseTotal(12750000D);

        doReturn(newOrder).when(orderRepository).save(newOrder);
        doReturn(discountOrder).when(orderRepository).save(discountOrder);
    }

    @Test
    void create_order_without_discount() {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Test Customer");

        Order newOrder = orderService.createOrder(customer, null, this.initOrderItemList());

        double expected = 150000000D;

        // assertEquals(expected, actual);
        assertThat(newOrder).isNotNull();
        assertThat(newOrder.getPurchaseTotal()).isEqualTo(expected);
    }

    @Test
    void create_order_with_discount() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Test Customer");

        Discount discount = new Discount();
        discount.setPercent(15);
        Order discountedOrder = orderService.createOrder(customer, discount, this.initOrderItemList());

        double expected = 127500000D;

        assertThat(discountedOrder).isNotNull();
        assertThat(discountedOrder.getPurchaseTotal()).isEqualTo(expected);
    }
}