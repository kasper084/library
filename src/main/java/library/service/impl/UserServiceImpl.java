package library.service.impl;

import library.dao.UserDAO;
import library.entity.User;
import library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void registerUser(String name) {
        User user = new User();
        user.setName(name);
        if (isExist(name)) {
            System.out.println("CHOOSE ANOTHER USERNAME");
        } else {
            userDAO.save(user);
            System.out.println("REGISTERED");
        }
    }

    public Optional<User> login(String name) {
        return userDAO.findByName(name);
    }

    private boolean isExist(String name) {
        return userDAO.findByName(name).isPresent();
    }

}
