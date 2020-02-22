package library.service;

import library.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    void registerUser(String name);

    Optional<User> login(String name);
}
