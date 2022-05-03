package ir.maktab.service.user;

import ir.maktab.model.User;
import ir.maktab.model.enums.Role;
import ir.maktab.model.enums.UserStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserServiceImplTest {

    UserService userService = new UserServiceImpl();

    @Test
    void saveUser() {
        User user = User.builder()
                .firstname("ali")
                .lastname("mohammadi")
                .email("mahdi@gmail.com")
                .password("asdd")
                .role(Role.CUSTOMER)
                .status(UserStatus.NEW)
                .build();
            userService.save(user);
        Assertions.assertEquals(user.getId(), userService.findById(user.getId()).getId());
    }

}