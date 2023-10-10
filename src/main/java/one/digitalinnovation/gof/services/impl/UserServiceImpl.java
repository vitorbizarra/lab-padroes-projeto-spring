package one.digitalinnovation.gof.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import one.digitalinnovation.gof.models.User;
import one.digitalinnovation.gof.models.UserRepository;
import one.digitalinnovation.gof.services.UserService;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> all() {
        return this.userRepository.findAll();
    }

    @Override
    public User find(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.get();
    }

    @Override
    public void insert(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void update(Long id, User user) {
        Optional<User> userDb = this.userRepository.findById(id);

        if (userDb.isPresent()) {
            this.userRepository.save(user);
        }
    }

    @Override
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }

}
