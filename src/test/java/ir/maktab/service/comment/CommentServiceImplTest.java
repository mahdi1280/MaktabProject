package ir.maktab.service.comment;

import ir.maktab.model.*;
import ir.maktab.model.enums.Role;
import ir.maktab.model.enums.StatusOrder;
import ir.maktab.model.enums.UserStatus;
import ir.maktab.service.offer.OfferService;
import ir.maktab.service.offer.OfferServiceImpl;
import ir.maktab.service.order.OrderService;
import ir.maktab.service.order.OrderServiceImpl;
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

class CommentServiceImplTest {

    OfferService offerService = new OfferServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    UnderServiceService underServiceService = new UnderServiceServiceImpl();
    ServiceService serviceService = new ServiceServiceImpl();
    UserService userService = new UserServiceImpl();
    CommentService commentService = new CommentServiceImpl();

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
        Offer offer = Offer.builder()
                .periodOfTime(LocalDateTime.now())
                .proposedPrice(12)
                .startTime(LocalDateTime.now())
                .order(order)
                .user(user)
                .build();

        offerService.save(offer);
        Comment comment = Comment.builder()
                .details("ASdasd")
                .score(4)
                .offer(offer)
                .build();
        commentService.save(comment);
        Assertions.assertEquals(comment.getDetails(), commentService.findById(comment.getId()).getDetails());
    }

    @Test
    void findAll(){
        List<Comment> all = commentService.findAll();
        Assertions.assertEquals(all.size(), commentService.findAll().size());
    }

}