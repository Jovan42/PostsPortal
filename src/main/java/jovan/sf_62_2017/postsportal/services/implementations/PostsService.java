package jovan.sf_62_2017.postsportal.services.implementations;

import jovan.sf_62_2017.postsportal.pojo.Post;
import jovan.sf_62_2017.postsportal.services.interfaces.IPostsService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
public class PostsService implements IPostsService {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
    @Override
    public List<Post> get() {
        EntityManager em = emf.createEntityManager();
        return  em.createQuery("FROM Post", Post.class).getResultList();
    }

    @Override
    public Post get(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Post.class, id);
    }

    @Override
    @SuppressWarnings("Duplicates")
    public Post add(Post post) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(post);
        em.getTransaction().commit();
        return post;
    }

    @Override
    public Post update(Post post) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Post savedPost = em.merge(post);
        em.getTransaction().commit();
        return  savedPost;
    }

    @Override
    public boolean delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Post.class, id));
        em.getTransaction().commit();
        return true;
    }

    @Override
    public List<Post> getFromUser(String userName) {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("FROM Post WHERE user_id = :user", Post.class).setParameter("user", userName).getResultList();
    }
}
