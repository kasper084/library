package library.dao.impl;

import library.dao.UserDAO;
import library.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static SessionFactory sessionFactory;
    private Session session;

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
        return session.createQuery("select u from users u", User.class).getResultList();
    }

    @Override
    public User findUser(String name) {
        return null; //session.createQuery("select User u from users where u.name = " + name, User.class).getSingleResult();
    }
}
