package jovan.sf_62_2017.postsportal.services.implementations;

import jovan.sf_62_2017.postsportal.pojo.Comment;
import jovan.sf_62_2017.postsportal.services.interfaces.ICommentsService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
public class CommentsService implements ICommentsService {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Comment> get() {
        EntityManager em = emf.createEntityManager();
        return  em.createQuery("FROM Comment", Comment.class).getResultList();
    }

    @Override
    public Comment get(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Comment.class, id);
    }

    @Override
    public List<Comment> getForPost(Integer postID) {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("FROM Comment WHERE user_id = :post", Comment.class).setParameter("post", postID).getResultList();
    }

    @Override
    @SuppressWarnings("Duplicates")
    public Comment add(Comment comment) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(comment);
        em.getTransaction().commit();
        return  comment;
    }

    @Override
    public Comment update(Comment comment) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Comment savedComment = em.merge(comment);
        em.getTransaction().commit();
        return  savedComment;
    }

    @Override
    public boolean delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Comment.class, id));
        em.getTransaction().commit();
        return true;
    }
}
