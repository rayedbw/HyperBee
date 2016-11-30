package net.therap.hyperbee.dao;

import net.therap.hyperbee.domain.Buzz;
import net.therap.hyperbee.domain.enums.DisplayStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author zoha
 * @since 11/22/16
 */
@Repository
public class BuzzDaoImpl implements BuzzDao {

    private final String QUERY_GET_BY_STATUS = "SELECT b FROM Buzz b WHERE b.displayStatus = :displayStatus";
    private final String QUERY_GET_LATEST = "SELECT b FROM Buzz b WHERE b.displayStatus = :displayStatus " +
            "AND b.pinned = :pinned ORDER BY b.id DESC";
    private final String QUERY_GET_PINNED = "SELECT b FROM Buzz b WHERE b.pinned = :pinned " +
            "ORDER BY b.id DESC";
    private final String QUERY_GET_BY_USER = "SELECT b FROM Buzz b WHERE b.userId = :userId";

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Buzz saveOrUpdate(Buzz buzz) {
        if (buzz.getId() == 0) {
            em.persist(buzz);
        } else {
            return em.merge(buzz);
        }

        return buzz;
    }

    @Override
    public List<Buzz> getAll() {
        return em.createQuery("FROM Buzz", Buzz.class).getResultList();
    }

    @Override
    public Buzz getById(int buzzId) {
        return em.find(Buzz.class, buzzId);
    }

    @Override
    public List<Buzz> getByUser(int userId) {
        return em.createQuery(QUERY_GET_BY_USER, Buzz.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public List<Buzz> getByDisplayStatus(DisplayStatus displayStatus) {
        return em.createQuery(QUERY_GET_BY_STATUS, Buzz.class)
                .setParameter("displayStatus", displayStatus.getStatus())
                .getResultList();
    }

    @Override
    public List<Buzz> getLatest(int range) {
        return em.createQuery(QUERY_GET_LATEST, Buzz.class)
                .setParameter("displayStatus", DisplayStatus.ACTIVE)
                .setParameter("pinned", false)
                .setMaxResults(range)
                .getResultList();
    }

    @Override
    public List<Buzz> getPinnedBuzz(int range) {
        return em.createQuery(QUERY_GET_PINNED, Buzz.class)
                .setParameter("pinned", true)
                .setMaxResults(range)
                .getResultList();
    }
}