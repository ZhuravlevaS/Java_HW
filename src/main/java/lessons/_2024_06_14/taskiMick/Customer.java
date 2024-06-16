package lessons._2024_06_14.taskiMick;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
class Customer {
    private int id;
    private String name;
}

@AllArgsConstructor
@Getter
class Item {
    private int id;
    private String name;
}

@AllArgsConstructor
@Getter
class PurchaseOrder {
    private int id;
    private Customer customer;
    private Item item;
}

interface OrderRepository {
    void save(PurchaseOrder order);
    PurchaseOrder findById(int id);
}

@Getter
class OrderRepositoryImpl implements OrderRepository {
    private Map<Integer, PurchaseOrder> orders = new HashMap<>();

    @Override
    public void save(PurchaseOrder order) {
        orders.put(order.getId(), order);
    }

    @Override
    public PurchaseOrder findById(int id) {
        return orders.get(id);
    }
}

@Getter
class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    public void placeOrder(PurchaseOrder order) {
        orderRepository.save(order);
    }

    public PurchaseOrder getOrder(int id) {

        return orderRepository.findById(id);
    }
}



