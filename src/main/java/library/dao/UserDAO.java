package library.dao;

import library.entity.User;

import java.util.List;

public interface UserDAO {

    void saveUser(User user);

    boolean isExist(String name);

    List<User> findAll();

    default User findUser(String name) {
        return null;
    }
}
