package com.userlogin.service;

import com.userlogin.dao.UserDao;
import com.userlogin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterService {


    @Autowired
    private UserDao userDao;

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public User findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
    }

    public Optional<User> getUserWithId(int userId) {
        return userDao.getUserWithId(userId);
    }


    public void updateUser(int userId, User user) {
        userDao.updateUser(userId, user);
    }
}
