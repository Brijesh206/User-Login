package com.userlogin.controller;

import com.userlogin.model.Operation;
import com.userlogin.model.User;
import com.userlogin.service.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Optional;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;
    @Autowired
    private Operation operations;

    private ModelAndView modelAndView;

//    show the home page to the user
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
        return "index";
    }


//    Show the registration page to the user
    @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String showRegisterForm(Model model){
        User user = new User();
        model.getAttribute("registerUser");
        model.addAttribute("registerUser", user);
        return "register";
    }

//    user is already exist in DB
    @RequestMapping(value = "/userExist", method = RequestMethod.GET)
    public String userExist(){
        return "userExist";
    }

//    List the existing users
    @RequestMapping(value = "/listUsers", method = RequestMethod.GET)
    public ModelAndView getUsers(){
        modelAndView = new ModelAndView("listUsers");
        List<User> users = registerService.getUsers();
        modelAndView.addObject("listUsers", users);
        return modelAndView;
    }

//    Remove user from the DB
    @RequestMapping(value = "/remove/{userId}", method = RequestMethod.GET)
    public void removeUser(@PathVariable int userId){
        registerService.deleteUser(userId);
    }

//    Show the update page with the user details
    @RequestMapping(value = "/updateForm/{userId}", method = RequestMethod.GET)
    public ModelAndView showUpdateForm(@PathVariable("userId") int userId){
        modelAndView = new ModelAndView("updateUser");
        Optional<User> user = registerService.getUserWithId(userId);
        modelAndView.addObject("updateUser", user.orElse(new User()));
        return modelAndView;
    }

//    User Registration and Update
    @RequestMapping(value = {"/{operation}/{userId}", "/{operation}"}, method = RequestMethod.POST)
    public ModelAndView operations(@PathVariable("operation") String operation,
                                   @Nullable @PathVariable("userId") Integer userId,
                                   @Valid @ModelAttribute("registerUser") User registerUser,
                                   @ModelAttribute("updateUser") User updateUser,
                                   BindingResult result){

        modelAndView = new ModelAndView("success");

        switch (operation.toLowerCase()){
            case "register" -> {
                User existingUser = registerService.findUserByEmail(registerUser.getEmail());

                if(existingUser != null && existingUser.getEmail() != null){
                    result.rejectValue("email", "403",
                            "There is already an account register with this email");
                }

                if(result.hasErrors()){
                    modelAndView = new ModelAndView("error");
                    modelAndView.addObject("registerUser", registerUser);
                    return modelAndView;
                }

                registerService.addUser(registerUser);
                operations.setName("registered");
                modelAndView.addObject("operation", operations);
                return modelAndView;
            }

            case "update" -> {
                registerService.updateUser(userId, updateUser);
                operations.setName("updated");
                modelAndView.addObject("operation", operations);
            }

            default ->{
                return new ModelAndView("redirect: /error");
            }
        }
        return modelAndView;
    }
}

