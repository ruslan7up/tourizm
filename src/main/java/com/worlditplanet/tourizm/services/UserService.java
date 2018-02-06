package com.worlditplanet.tourizm.services;

import com.worlditplanet.tourizm.domain.entity.User;

import java.util.List;

/**
 * Created by Admin on 14.01.2018.
 */
public interface UserService {
    public User getUserById(Long id);
    public User getUserByLogin(String login);
    public List<User> getAllUsers();
    public void addUser(User user);
    public void updateUser(User user);
    public void removeUserById(Long id);
    public void updateFullName(String login, String fullName);
    public void updateCountry(String login, String country);
    public void updateCity(String login, String city);
    public void updatePassword(String login, String password);
}
