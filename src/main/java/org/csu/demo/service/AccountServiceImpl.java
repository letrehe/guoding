package org.csu.demo.service;

import org.csu.demo.domain.Account;
import org.csu.demo.persistence.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;
    @Override
    public Account login(Account account) {
        return accountDAO.findByUsernameAndPassword(account);
    }

    @Override
    public ArrayList<Account> getAllAccountInfo() {
        return accountDAO.findAll();
    }
}
