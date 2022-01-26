package com.NeoPay.webApp.controller;

import com.NeoPay.model.User;
import com.NeoPay.service.ConnectionService;
import com.NeoPay.service.TransferService;
import com.NeoPay.service.UserService;
import com.NeoPay.service.form.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class UserController {
    private final ConnectionService connectionService;
    private final UserService userService;
    private final TransferService transferService;

    public UserController(ConnectionService connectionService, UserService userService, TransferService transferService) {
        this.connectionService = connectionService;
        this.userService = userService;
        this.transferService = transferService;
    }


    @GetMapping("/")
    public ModelAndView home(Model model) {


        return new ModelAndView("index");
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView processRequest(@ModelAttribute("registrationForm") RegistrationForm form) {
        userService.registration(form);
        return new ModelAndView("login", "loginForm", new LoginForm());
    }

    @GetMapping("/register")
    public ModelAndView showRegisterForm() {
        return new ModelAndView("register", "registrationForm", new RegistrationForm());
    }

    @GetMapping("/home")
    public String logOff(Model model) {
        return "home";
    }

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        return "contact";
    }

    @GetMapping("profile")
    public ModelAndView profile(Model model) {
        User account = userService.findAccount();
        model.addAttribute("account", account);

        return new ModelAndView("profile");


    }

    @GetMapping("add-iban")
    public ModelAndView getAddConnectionForm(Model model) {
        return new ModelAndView("add-iban", "addIbanForm", new AddIbanForm());
    }

    @PostMapping("add-iban")
    public ModelAndView addIban(@ModelAttribute("addIbanForm") AddIbanForm form) {
        userService.addIban(form);
        return new ModelAndView("add-iban", "addIbanForm", new AddIbanForm());
    }
}

