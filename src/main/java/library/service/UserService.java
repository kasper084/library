package library.service;

import library.entity.User;

import java.util.Optional;

public interface UserService {

    void registerUser(String name);

    void save(User user);

    Optional<User> login(String name);
}
