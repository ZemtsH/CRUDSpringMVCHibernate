package app.dao;

import app.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    public List<User> getUserList() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    public User show(long id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(long id, User user) {
        entityManager.merge(user);
    }

    public void delete(long id) {
        entityManager.createQuery("DELETE FROM User u WHERE u.id = :id")
                .setParameter("id", id).executeUpdate();
    }
}
