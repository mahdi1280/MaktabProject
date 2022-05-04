package ir.maktab.service.user;

import ir.maktab.model.User;
import ir.maktab.model.enums.Role;
import ir.maktab.model.enums.UserStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void updateUser(){
        User user = User.builder()
                .firstname("ali")
                .lastname("mohammadi")
                .email("mahdi@gmail.com")
                .password("asdd")
                .role(Role.CUSTOMER)
                .status(UserStatus.NEW)
                .build();
        userService.save(user);
        user.setPassword("ali");
        userService.update(user);
        Assertions.assertEquals(user.getPassword(), userService.findById(user.getId()).getPassword());
    }

    @Test
    void getAll(){
        List<User> allSpecialty = userService.findAllSpecialty();
        for (User user:
             allSpecialty) {
            Assertions.assertNotEquals(Role.EXPERT, user.getRole());
        }
    }

    @Test
    void getAllUser(){
        List<User> allUser = userService.findAllUser();
        for (User user:
                allUser) {
            Assertions.assertNotEquals(Role.CUSTOMER, user.getRole());
        }
    }


}