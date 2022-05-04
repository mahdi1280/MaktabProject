package ir.maktab.service.user;

import ir.maktab.model.User;
import ir.maktab.repository.UserRepository;

import java.util.List;

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

    @Override
    public void update(User user) {
        this.userRepository.update(user);
    }

    @Override
    public List<User> findAllSpecialty() {
        return userRepository.findALlSpecialty();
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAllUser();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll(User.class);
    }
}
