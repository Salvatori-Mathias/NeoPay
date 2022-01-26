package com.NeoPay.service;

import com.NeoPay.model.Account;
import com.NeoPay.model.User;
import com.NeoPay.repository.AccountRepository;
import com.NeoPay.repository.UserRepository;
import com.NeoPay.service.form.TransferToAccountForm;
import com.NeoPay.service.form.TransferToBankForm;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service("TransferService")
public class TransferService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;



    public TransferService( UserRepository userRepository, AccountRepository accountRepository) {
        
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }


    public String findIban(){
        org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User connectedUser = userRepository.findUserByMail(springUser.getUsername())
                .orElseThrow(() -> new RuntimeException("user with email  not found"));
        Account account = accountRepository.findAccountByUserId(connectedUser.getId());
       return account.getIban();

    }
    public void transferToBank(TransferToBankForm form) {

        if (form != null) {
            org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User connectedUser = userRepository.findUserByMail(springUser.getUsername())
                    .orElseThrow(() -> new RuntimeException("user with email  not found"));


            // get the Account of the coennnected user

            accountRepository.save(connectedUser.getAccount().minus(form.getAmount()));




        } else {

        }
    }
    public void transferToAccount(TransferToAccountForm form) {
        if (form != null) {
            org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User connectedUser = userRepository.findUserByMail(springUser.getUsername())
                    .orElseThrow(() -> new RuntimeException("user with email  not found"));


            // get the Account of the coennnected user

            accountRepository.save(connectedUser.getAccount().plus(form.getAmount()));



        } else {

        }
    }


}

