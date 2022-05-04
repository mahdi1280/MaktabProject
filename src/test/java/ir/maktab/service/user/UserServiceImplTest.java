package ir.maktab.service.user;

import ir.maktab.model.Service;
import ir.maktab.model.User;
import ir.maktab.model.enums.Role;
import ir.maktab.model.enums.UserStatus;
import ir.maktab.service.service.ServiceService;
import ir.maktab.service.service.ServiceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

class UserServiceImplTest {

    UserService userService = new UserServiceImpl();
    ServiceService serviceService=new ServiceServiceImpl();


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
    void saveExpert(){
        User user = User.builder()
                .firstname("ali")
                .lastname("mohammadi")
                .email("mahdi@gmail.com")
                .password("asdd")
                .role(Role.CUSTOMER)
                .status(UserStatus.NEW)
                .image(getImage())
                .build();
        userService.save(user);
        Assertions.assertEquals(user.getId(), userService.findById(user.getId()).getId());
    }

    @Test
    void changePassword(){
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
    void findAllExpert(){
        List<User> allSpecialty = userService.findALlExpert();
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

    @Test
    void addServiceInExpert(){
        Service service=Service.builder()
                .title("manzel")
                .build();
        serviceService.save(service);

        User user = User.builder()
                .firstname("ali")
                .lastname("mohammadi")
                .email("mahdi@gmail.com")
                .password("asdd")
                .role(Role.CUSTOMER)
                .status(UserStatus.NEW)
                .score(4)
                .build();

        user.getServices().add(service);
        userService.save(user);

        Assertions.assertEquals(user.getServices().size(), userService.findById(user.getId()).getServices().size());

    }

    @Test
    void findAll(){
        List<User> all = userService.findAll();
        Assertions.assertEquals(all.size(),userService.findAll().size());
    }

    public byte[] getImage() {
        File file = new File("./../resources/download.jpg");
        byte[] bFile = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bFile;
    }
}