package ir.maktab.service.order;

import ir.maktab.model.Order;
import ir.maktab.repository.OrderRepository;

import java.util.List;

public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(){
        this.orderRepository=new OrderRepository() {};
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order findById(long id) {
        return orderRepository.findById(Order.class,id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll(Order.class);
    }
}
