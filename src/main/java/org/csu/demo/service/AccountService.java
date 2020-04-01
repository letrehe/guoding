package org.csu.demo.service;

import org.csu.demo.domain.Account;

import java.util.ArrayList;

public interface AccountService {
    public Account login(Account account);
    public ArrayList<Account> getAllAccountInfo();
}
