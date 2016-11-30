package net.therap.hyperbee.dao;


import net.therap.hyperbee.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author rayed
 * @since 11/22/16 10:49 AM
 */
@Repository
public class UserDaoImpl implements UserDao {

    private static String FIND_BY_USERNAME = "SELECT u FROM User u WHERE u.username = :username";

    private static String FIND_BY_USERNAME_AND_PASSWORD = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password";

    private static String FIND_ALL = "SELECT u FROM User u";

    private static String FIND_BY_USRNAME_AND_EMAIL = "User.findByUsernameOrEmail";

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public User createUser(User user) {
        em.persist(user);
        em.flush();

        return user;
    }

    @Override
    public User findById(int id) {

        return em.find(User.class, id);
    }

    @Override
    public User findByUsername(String username) {
        User user = null;

        try {
            user = em.createQuery(FIND_BY_USERNAME, User.class)
                        .setParameter("username", username)
                        .getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User findByUsernameOrEmail(String username, String email) {
        User user = null;

        try {
            user = em.createNamedQuery(FIND_BY_USRNAME_AND_EMAIL, User.class)
                        .setParameter("username", username)
                        .setParameter("email", email)
                        .getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User findByUsernameAndPassword(User user) {
        User retrievedUser = null;

        try {
            retrievedUser = em.createQuery(FIND_BY_USERNAME_AND_PASSWORD, User.class)
                                .setParameter("username", user.getUsername())
                                .setParameter("password", user.getPassword())
                                .getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }

        return retrievedUser;
    }

    @Override
    public List<User> findAll() {

        return em.createQuery(FIND_ALL, User.class).getResultList();
    }

    @Override
    @Transactional
    public void updateUser(User user) {

    }

    @Override
    @Transactional
    public void deleteUser(int id) {

    }

    @Override
    @Transactional
    public void inactivate(int userId) {
        em.createQuery("UPDATE User u SET u.displayStatus = 'INACTIVE' WHERE id = :userId")
                .setParameter("userId", userId)
                .executeUpdate();
        em.flush();
    }
}
