package ir.maktab.service.user;

import ir.maktab.model.User;

public interface UserService {

    void save(User user);

    User findById(long id);
}
