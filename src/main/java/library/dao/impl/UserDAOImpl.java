package library.dao.impl;

import library.dao.UserDAO;
import library.entity.User;
import org.springframework.beans.factory.annotation.Autowired;;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public boolean isExist(String name) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User findUser(String name) {
        return entityManager
                .createQuery("select u from User u where u.name = " + name, User.class)
                .getSingleResult();
    }
}
