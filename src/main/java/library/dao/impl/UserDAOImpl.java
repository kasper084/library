package library.dao.impl;

import library.dao.UserDAO;
import library.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
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
    public TypedQuery<User> findUser(String name) {
        return
                entityManager
                        .createQuery("select u from User u where u.name = " + name, User.class);
    }
}
