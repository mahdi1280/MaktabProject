package ir.maktab.service.order;

import ir.maktab.model.Order;
import ir.maktab.model.Service;
import ir.maktab.model.UnderService;
import ir.maktab.model.User;
import ir.maktab.model.enums.Role;
import ir.maktab.model.enums.StatusOrder;
import ir.maktab.model.enums.UserStatus;
import ir.maktab.service.service.ServiceService;
import ir.maktab.service.service.ServiceServiceImpl;
import ir.maktab.service.underservice.UnderServiceService;
import ir.maktab.service.underservice.UnderServiceServiceImpl;
import ir.maktab.service.user.UserService;
import ir.maktab.service.user.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

class OrderServiceImplTest {

    OrderService orderService = new OrderServiceImpl();
    UnderServiceService underServiceService = new UnderServiceServiceImpl();
    ServiceService serviceService = new ServiceServiceImpl();
    UserService userService = new UserServiceImpl();

    @Test
    void save() {
        Service service = Service.builder()
                .title("manzel")
                .build();
        serviceService.save(service);
        UnderService underService = UnderService.builder()
                .details("asdasd")
                .service(service)
                .basePrice(123)
                .build();
        underServiceService.save(underService);
        User user = User.builder()
                .firstname("ali")
                .lastname("mohammadi")
                .email("mahdi@gmail.com")
                .password("asdd")
                .role(Role.CUSTOMER)
                .status(UserStatus.NEW)
                .build();
        userService.save(user);
        Order order = Order.builder()
                .proposedPrice(213)
                .address("asdasd")
                .status(StatusOrder.STARTED)
                .wordTime(LocalDateTime.now())
                .underService(underService)
                .user(user)
                .build();
        orderService.save(order);
        Assertions.assertEquals(order.getId(), orderService.findById(order.getId()).getId());
    }

    @Test
    void findAll(){
        List<Order> all = orderService.findAll();
        Assertions.assertEquals(all.size(), orderService.findAll().size());
    }

}