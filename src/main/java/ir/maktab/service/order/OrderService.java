package ir.maktab.service.order;

import ir.maktab.model.Order;

import java.util.List;

public interface OrderService {

    void save(Order order);

    Order findById(long id);

    List<Order> findAll();
}
