package jovan.sf_62_2017.postsportal.services.implementations;

import jovan.sf_62_2017.postsportal.pojo.Tag;
import jovan.sf_62_2017.postsportal.services.interfaces.ITagService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
public class TagService implements ITagService {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Tag> getForPost(Integer postId) {
        return null;
    }

    @Override
    public List<Tag> get() {
        EntityManager em = emf.createEntityManager();
        return  em.createQuery("FROM Tag", Tag.class).getResultList();
    }

    @Override
    public Tag get(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Tag.class, id);
    }

    @Override
    @SuppressWarnings("Duplicates")
    public Tag add(Tag tag) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(tag);
        em.getTransaction().commit();
        return tag;
    }

    @Override
    public Tag update(Tag tag) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Tag savedTag = em.merge(tag);
        em.getTransaction().commit();
        return  savedTag;
    }

    @Override
    public boolean delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Tag.class, id));
        em.getTransaction().commit();
        return true;
    }
}
