package ir.maktab.service.order;

import ir.maktab.model.Order;

public interface OrderService {

    void save(Order order);

    Order findById(long id);

}
