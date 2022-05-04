package ir.maktab.service.user;

import ir.maktab.dto.request.UserSearchRequest;
import ir.maktab.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User findById(long id);

    void update(User user);

    List<User> findALlExpert();

    List<User> findAllUser();

    List<User> findAll();

    void changePassword(long id,String password);

    List<User> search(UserSearchRequest userSearchRequest);
}
