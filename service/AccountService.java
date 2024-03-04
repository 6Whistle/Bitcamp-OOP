package service;

import model.Account;

import java.util.List;

public interface AccountService {

    String creatAccount(Account account);

    List<?> getAccountsList();

    String withdraw(Account account);

    String deposit(Account account);

    String getBalance(Account account);

    String deleteAccount(Account account);

    String findAccount(Account account);
}