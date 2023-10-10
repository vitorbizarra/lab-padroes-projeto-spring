package one.digitalinnovation.gof.services;

import one.digitalinnovation.gof.models.User;

public interface UserService {
    Iterable<User> all();

    User find(Long id);

    void insert(User cliente);

    void update(Long id, User cliente);

    void delete(Long id);
}
