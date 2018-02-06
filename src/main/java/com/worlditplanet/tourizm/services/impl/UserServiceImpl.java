package com.worlditplanet.tourizm.services.impl;

import com.worlditplanet.tourizm.dao.UserRepository;
import com.worlditplanet.tourizm.domain.entity.User;
import com.worlditplanet.tourizm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 14.01.2018.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public User getUserById(Long id) throws RuntimeException {
        return userRepository.getById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public User getUserByLogin(String login) throws RuntimeException {
        return userRepository.getByLogin(login);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public List<User> getAllUsers() throws RuntimeException {
        return userRepository.getAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public void updateUser(User user) throws RuntimeException {
        userRepository.updateUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public void removeUserById(Long id) throws RuntimeException {
        userRepository.removeUserById(id);
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
