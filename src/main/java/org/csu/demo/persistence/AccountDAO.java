package org.csu.demo.persistence;

import org.csu.demo.domain.Account;

import java.util.ArrayList;

public interface AccountDAO {
    String FIND_BY_USERNAME_AND_PASSWORD="Select * from user_info where name=? and password=?";
    String FIND_ALL="Select * from user_info";

    public Account findByUsernameAndPassword(Account account);
    public ArrayList<Account> findAll();

}
