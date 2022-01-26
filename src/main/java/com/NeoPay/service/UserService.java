package com.NeoPay.service;

import com.NeoPay.model.Account;
import com.NeoPay.model.User;
import com.NeoPay.repository.AccountRepository;
import com.NeoPay.repository.UserRepository;
import com.NeoPay.service.form.AddIbanForm;
import com.NeoPay.service.form.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service("UserService")
public class UserService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registration(final RegistrationForm form) {
        User userModel = populateCustomerData(form);
        Account account = new Account();
        account.setAmount(0.0);
        userModel.setAccount(account);
        return userRepository.save(userModel);
    }

    private User populateCustomerData(final RegistrationForm form) {
        User user = new User();
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        return user;
    }


    //  deuxieme maniere de faire userRepository.findUserByMail(form.getEmail()).filter(u->passwordEncoder.matches(rawPassword,u.getPassword())).isPresent();



    /*
        public User getUser(final int id) {
            return userProxy.getUser(id);
        }
    */
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    /*
        public void deleteEmployee(final int id) {
            userProxy.deleteUser(id);;
        }
    */
    public void addIban(final AddIbanForm form) {

        org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User connectedUser = userRepository.findUserByMail(springUser.getUsername())
                .orElseThrow(() -> new RuntimeException("user with email  not found"));
        Account account = connectedUser.getAccount();
       account.setIban(form.getIban());

       accountRepository.save(account);
    }

    public User findAccount(){
        org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       return userRepository.findUserByMail(springUser.getUsername())
                .orElseThrow(() -> new RuntimeException("user with email  not found"));


    }


}