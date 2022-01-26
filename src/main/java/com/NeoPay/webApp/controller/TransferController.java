package com.NeoPay.webApp.controller;

import com.NeoPay.model.User;
import com.NeoPay.service.ConnectionService;
import com.NeoPay.service.TransferService;
import com.NeoPay.service.UserService;
import com.NeoPay.service.form.TransferToAccountForm;
import com.NeoPay.service.form.TransferToBankForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class TransferController {

    private final TransferService transferService;
    private final ConnectionService connectionService;
    private final UserService userService;
    public TransferController(TransferService transferService, ConnectionService connectionService, UserService userService) {
        this.transferService = transferService;
        this.connectionService = connectionService;
        this.userService = userService;
    }

    @GetMapping("transfer-to-bank")
    public ModelAndView transferToBank(Model model) {
        String iban = transferService.findIban();
        User account = userService.findAccount();
        model.addAttribute("account", account);
        model.addAttribute("iban", iban);
        return new ModelAndView("transfer-to-bank", "transferToBankForm", new TransferToBankForm());
    }
    @PostMapping("transfer-to-bank")
    public ModelAndView transferCashToBank(Model model, @ModelAttribute("transferToBankForm") TransferToBankForm form) {
        transferService.transferToBank(form);
        String iban = transferService.findIban();
        User account = userService.findAccount();
        model.addAttribute("account", account);
        model.addAttribute("iban", iban);
        return new ModelAndView("transfer-to-bank", "transferToBankForm", new TransferToBankForm());
    }
    @GetMapping("transfer-to-account")
    public ModelAndView transferToaccount(Model model) {

        return new ModelAndView("transfer-to-account", "transferToAccountForm", new TransferToAccountForm());
    }
    @PostMapping("transfer-to-account")
    public ModelAndView transferCashToAccount(Model model, @ModelAttribute("transferToAccountForm") TransferToAccountForm form) {
        transferService.transferToAccount(form);

        return new ModelAndView("transfer-to-account", "transferToAccountForm", new TransferToAccountForm());
    }
}
