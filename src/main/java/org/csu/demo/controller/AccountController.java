package org.csu.demo.controller;

import org.csu.demo.domain.Account;
import org.csu.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/account")
@SessionAttributes("loginAccount")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public String login(Account account, Model model){
        System.out.println(account.getUsername()+","+account.getPassword());
        Account loginAccount=accountService.login(account);
        if(loginAccount==null){
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }
        else {
            model.addAttribute("loginAccount",loginAccount);
            model.addAttribute("accountlist",accountService.getAllAccountInfo());
            return "main";
        }
    }
}
