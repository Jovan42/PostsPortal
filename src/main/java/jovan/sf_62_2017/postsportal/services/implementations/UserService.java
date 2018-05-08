package jovan.sf_62_2017.postsportal.services.implementations;

import jovan.sf_62_2017.postsportal.pojo.User;
import jovan.sf_62_2017.postsportal.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
public class UserService implements IUserService {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<User> get() {
        EntityManager em = emf.createEntityManager();
        return  em.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User get(String userName) {
        EntityManager em = emf.createEntityManager();
        return em.find(User.class, userName);
    }

    @Override
    @SuppressWarnings("Duplicates")
    public User add(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user;
    }

    @Override
    public User update(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User savedUser = em.merge(user);
        em.getTransaction().commit();
        return  savedUser;
    }

    @Override
    public boolean delete(String userName) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(User.class, userName));
        em.getTransaction().commit();
        return true;
    }
}
