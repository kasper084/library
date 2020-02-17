package library.dao;

import library.entity.User;

import javax.persistence.TypedQuery;
import java.util.List;

public interface UserDAO {

    void saveUser(User user);

    boolean isExist(String name);

    List<User> findAll();

    default TypedQuery<User> findUser(String name) {
        return null;
    }
}
