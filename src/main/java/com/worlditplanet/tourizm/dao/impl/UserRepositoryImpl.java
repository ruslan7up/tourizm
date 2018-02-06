package com.worlditplanet.tourizm.dao.impl;

import com.worlditplanet.tourizm.dao.UserRepository;
import com.worlditplanet.tourizm.domain.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Admin on 14.01.2018.
 */
@Repository
public class UserRepositoryImpl implements UserRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getByLogin(String login) {
        Query query = entityManager.createQuery("FROM User WHERE login = :login");
        query.setParameter("login", login);
        return (User) query.getSingleResult();
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUserById(Long id) {
        Query query = entityManager.createQuery("DELETE FROM User WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void updateFullName(String login, String fullName) {

    }

    @Override
    public void updateCountry(String login, String country) {

    }

    @Override
    public void updateCity(String login, String city) {

    }

    @Override
    public void updatePassword(String login, String password) {

    }
}
