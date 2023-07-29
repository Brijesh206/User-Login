package com.userlogin;

import com.userlogin.dao.UserDao;
import com.userlogin.model.User;
import com.userlogin.repository.UserRepository;
import com.userlogin.service.RegisterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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


    public static void main(String[] args) {
        SpringApplication.run(UserLoginApplication.class, args);
    }

}
