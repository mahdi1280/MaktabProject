package ir.maktab.service.user;

import ir.maktab.dto.request.UserSearchRequest;
import ir.maktab.model.Service;
import ir.maktab.model.UnderService;
import ir.maktab.model.User;
import ir.maktab.model.enums.Role;
import ir.maktab.model.enums.UserStatus;
import ir.maktab.service.service.ServiceService;
import ir.maktab.service.service.ServiceServiceImpl;
import ir.maktab.service.underservice.UnderServiceService;
import ir.maktab.service.underservice.UnderServiceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

class UserServiceImplTest {

    UserService userService = new UserServiceImpl();
    ServiceService serviceService=new ServiceServiceImpl();
    UnderServiceService underServiceService = new UnderServiceServiceImpl();


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
        userService.changePassword(user.getId(),"test");
        Assertions.assertEquals("test", userService.findById(user.getId()).getPassword());
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
            Assertions.assertEquals(Role.CUSTOMER, user.getRole());
        }
    }

    @Test
    void addServiceInExpert(){
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
                .score(4)
                .build();

        user.getServices().add(underService);
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

    @Test
    void search(){
        saveAllUser();
        UserSearchRequest userSearchRequest=UserSearchRequest.builder()
//                        .underService()
                                .email("m@gmail.com")
                                        .firstname("ali")
                                                .lastname("mohammadi")
                                                        .build();

        List<User> search = userService.search(userSearchRequest);
        for(User user:search){
            Assertions.assertEquals("m@gmail.com",user.getEmail());
            Assertions.assertEquals("ali",user.getFirstname());
            Assertions.assertEquals("mohammadi",user.getLastname());
        }
    }

    private void saveAllUser(){
        User user = User.builder()
                .firstname("ali")
                .lastname("mohammadi")
                .email("m@gmail.com")
                .password("asdd")
                .role(Role.CUSTOMER)
                .status(UserStatus.NEW)
                .build();
        User user1 = User.builder()
                .firstname("ali")
                .lastname("mohammadi")
                .email("masda@gmail.com")
                .password("asdd")
                .role(Role.CUSTOMER)
                .status(UserStatus.NEW)
                .build();
        userService.save(user1);
        userService.save(user);
    }
}