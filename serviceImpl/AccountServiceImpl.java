package serviceImpl;

import builder.AccountBuilder;
import lombok.Getter;
import model.AccountDTO;
import service.AccountService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {
    @Getter
    private final static AccountService instance = new AccountServiceImpl();

    private final List<AccountDTO> accountDTOList;

    private AccountServiceImpl() {
        accountDTOList = new ArrayList<>();
    }


    @Override
    public String creatAccount(AccountDTO account) {
        accountDTOList.add(account);
        return "Account creation success";
    }

    @Override
    public List<AccountDTO> getAccountsList() {
        return new ArrayList<>(accountDTOList);
    }

    @Override
    public String withdraw(AccountDTO account) {
        return accountDTOList.stream()
                .filter(i -> i.getAccountNumber().equals(account.getAccountNumber()))
                .filter(i -> i.getBalance() >= account.getBalance())
                .peek(i -> i.setBalance(i.getBalance() - account.getBalance()))
                .findAny().isPresent() ? "Withdraw success" : "Withdraw fail";
    }

    @Override
    public String deposit(AccountDTO account) {
        return accountDTOList.stream()
                .filter(i -> i.getAccountNumber().equals(account.getAccountNumber()))
                .peek((i -> i.setBalance(i.getBalance() + account.getBalance())))
                .findAny().isPresent() ? "Deposit success" : "Deoposit fail";
    }

    @Override
    public String getBalance(AccountDTO account) {
        return accountDTOList.stream()
                .filter(i -> i.getAccountNumber().equals(account.getAccountNumber()))
                .map(i -> "Balance of " + i.getAccountHolder() + " : " + i.getBalance())
                .findFirst()
                .orElse("We can't find your account");
    }

    @Override
    public String deleteAccount(AccountDTO account) {
        return accountDTOList.removeIf(i -> i.getAccountNumber().equals(account.getAccountNumber())) ?
                "Your Account was deleted" : "We can't find your account";
    }

    @Override
    public String findAccount(AccountDTO account) {
        return accountDTOList.stream()
                .filter(i -> i.getAccountNumber().equals(account.getAccountNumber()))
                .map(AccountDTO::toString)
                .findAny().orElse("We can't find your account");
    }
}
