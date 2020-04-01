package org.csu.demo.persistence;

import org.csu.demo.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    private DataSource dataSource;
    @Override
    public Account findByUsernameAndPassword(Account account) {
        Account loginAccount=null;
        try{
            Connection connection=dataSource.getConnection();
            PreparedStatement pStatement=connection.prepareStatement(FIND_BY_USERNAME_AND_PASSWORD);
            pStatement.setString(1,account.getUsername());
            pStatement.setString(2,account.getPassword());

            ResultSet resultSet=pStatement.executeQuery();
            if(resultSet.next()){
                loginAccount=new Account();
                loginAccount.setId(resultSet.getInt("id"));
                loginAccount.setUsername(resultSet.getString("name"));
                loginAccount.setPassword(resultSet.getString("password"));
                loginAccount.setAge(resultSet.getInt("age"));
                loginAccount.setGender(resultSet.getInt("gender"));
                loginAccount.setEmail(resultSet.getString("email"));
            }
            resultSet.close();
            pStatement.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return loginAccount;
    }

    @Override
    public ArrayList<Account> findAll() {
        ArrayList<Account> accountList=new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet=pStatement.executeQuery();

            while (resultSet.next()){
                Account temp=new Account();
                temp.setId(resultSet.getInt("id"));
                temp.setUsername(resultSet.getString("name"));
                temp.setPassword(resultSet.getString("password"));
                temp.setAge(resultSet.getInt("age"));
                temp.setGender(resultSet.getInt("gender"));
                temp.setEmail(resultSet.getString("email"));
                accountList.add(temp);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return accountList;
    }
}
