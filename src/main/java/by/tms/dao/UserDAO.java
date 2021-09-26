package by.tms.dao;

import by.tms.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(User user){
        entityManager.persist(user);
    }

    @Transactional
    public void update(User user){
        entityManager.merge(user);
    }

    @Transactional
    public void delete(long id){
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Transactional(readOnly = true)
    public List<User> findAll(){
        List<User> users = entityManager.createQuery("select User from User", User.class).getResultList();
        return users;
    }

    @Transactional(readOnly = true)
    public User findById(long id){
        TypedQuery<User> query = entityManager.createQuery("select User from User where id = :id", User.class);
        query.setParameter("id",id);
        User singleResult = query.getSingleResult();
        return singleResult;
    }
}
