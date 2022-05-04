package ir.maktab.service.user;

import ir.maktab.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User findById(long id);

    void update(User user);

    List<User> findAllSpecialty();

    List<User> findAllUser();

    List<User> findAll();
}
