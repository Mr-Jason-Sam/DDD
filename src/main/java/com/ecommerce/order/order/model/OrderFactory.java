package com.ecommerce.order.order.model;

import com.ecommerce.order.common.ddd.Factory;
import com.ecommerce.order.common.utils.Address;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFactory implements Factory {
    private final OrderIdGenerator idGenerator;

    public OrderFactory(OrderIdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public Order create(List<OrderItem> items, Address address) {
        OrderId orderId = idGenerator.generate();
        return Order.create(orderId, items, address);
    }
}
