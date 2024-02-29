package service;

import model.AccountDTO;

import java.util.List;

public interface AccountService {

    String creatAccount(AccountDTO account);

    List<AccountDTO> getAccountsList();

    String withdraw(AccountDTO account);

    String deposit(AccountDTO account);

    String getBalance(AccountDTO account);

    String deleteAccount(AccountDTO account);

    String findAccount(AccountDTO account);
}