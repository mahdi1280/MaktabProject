package ir.maktab.service.user;

import ir.maktab.model.User;
import ir.maktab.repository.UserRepository;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepository() {};
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(User.class,id);
    }
}
