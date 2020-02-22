package library.service.impl;

import library.dao.UserDAO;
import library.entity.User;
import library.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Override
    public void registerUser(String name) {
        User user = new User();
        user.setName(name);
        if (!isExist(name)) userDAO.save(user);
    }

    public Optional<User> login(String name) {
        return userDAO.findByName(name);
    }

    private boolean isExist(String name) {
        return userDAO.findByName(name).isPresent();
    }
}
