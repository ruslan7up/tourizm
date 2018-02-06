package com.worlditplanet.tourizm.dao;

import com.worlditplanet.tourizm.domain.entity.User;

import java.util.List;

/**
 * Created by Admin on 07.01.2018.
 */
public interface UserRepository {
    User getByLogin(String login);
    User getById(Long id);
    List<User> getAll();
    void addUser(User user);
    void updateUser(User user);
    void removeUserById(Long id);
    public void updateFullName(String login, String fullName);
    public void updateCountry(String login, String country);
    public void updateCity(String login, String city);
    public void updatePassword(String login, String password);
}
