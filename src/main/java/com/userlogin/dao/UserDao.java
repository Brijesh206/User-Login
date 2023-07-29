package com.userlogin.dao;

import com.userlogin.model.User;
import com.userlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserDao {

    @Autowired
    private UserRepository userRepository;

    public UserDao() {
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User findByEmail(String email){

        return userRepository.findByEmail(email);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    public Optional<User> getUserWithId(int userId) {
        return userRepository.findById(userId);
    }

    public void updateUser(int userId, User user) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isPresent()){

        User user1 = optionalUser.get();
        user1.setUserName(user.getUserName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());

        userRepository.save(user1);
        }
    }
}
