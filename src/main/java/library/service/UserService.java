package library.service;

import library.entity.User;

import java.util.Optional;

public interface UserService {

    void registerUser(String name);

    Optional<User> login(String name);
}
