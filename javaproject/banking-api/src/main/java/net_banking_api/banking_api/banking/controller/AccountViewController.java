package net_banking_api.banking_api.banking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net_banking_api.banking_api.banking.service.AccountService;

@Controller 
@RequestMapping("/accounts")

public class AccountViewController {
    private final AccountService accountService;

    public AccountViewController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping
    public String accountPage(Model model){
        model.addAttribute("accounts", accountService.getAllAccounts());
        return "accounts";
    }
}
