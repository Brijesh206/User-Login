package com.userlogin;

import com.userlogin.dao.UserDao;
import com.userlogin.model.Operation;
import com.userlogin.service.RegisterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserLoginApplication {

    @Bean
    public RegisterService registerService(){
        return new RegisterService();
    }

    @Bean
    public UserDao userDao(){
        return new UserDao();
    }

    @Bean
    public Operation operations(){
        return new Operation();
    }

    public static void main(String[] args) {
        SpringApplication.run(UserLoginApplication.class, args);
    }

}
