package com.userlogin.controller;

import com.userlogin.model.User;
import com.userlogin.repository.UserRepository;
import com.userlogin.service.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

//    Add User to the DataBase
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registration(@Valid @ModelAttribute("registerUser") User user,
                             BindingResult result,
                             Model model){
        User existingUser = registerService.findUserByEmail(user.getEmail());

        if(existingUser != null && existingUser.getEmail() != null){
            result.rejectValue("email", "403",
                    "There is already an account register with this email");
        }

        if(result.hasErrors()){
            model.addAttribute("registerUser", user);
            return "/userExist";
        }

        registerService.addUser(user);
        return "redirect:/register?success";
    }

//    show the success page to the user
    @RequestMapping(value = "/register", method = RequestMethod.GET, params = "success")
    public String registrationSuccess(){
        return "success";
    }

//    user is already exist in DB
    @RequestMapping(value = "/userExist", method = RequestMethod.GET)
    public String userExist(){
        return "userExist";
    }

//    List the existing users
    @RequestMapping(value = "/listUsers", method = RequestMethod.GET)
    public ModelAndView getUsers(){
        ModelAndView modelAndView = new ModelAndView("listUsers");
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
        ModelAndView modelAndView = new ModelAndView("updateUser");
        Optional<User> user = registerService.getUserWithId(userId);
        modelAndView.addObject("updateUser", user.orElse(new User()));
        return modelAndView;
    }

//    Update User
    @RequestMapping(value = "/update/{userId}", method = RequestMethod.POST)
    public ModelAndView updateUser(@PathVariable("userId") int userID, @ModelAttribute("updateUser") User user){
        ModelAndView modelAndView = new ModelAndView("updateSuccess");
        registerService.updateUser(userID, user);
        return modelAndView;
    }

}

