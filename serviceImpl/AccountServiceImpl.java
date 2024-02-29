package serviceImpl;

import lombok.Getter;
import model.AccountDTO;
import service.AccountService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    @Getter
    private final static AccountService instance = new AccountServiceImpl();

    private final List<AccountDTO> accountDTOList;

    private AccountServiceImpl(){
        accountDTOList = new ArrayList<>();
    }


    @Override
    public String creatAccount(AccountDTO account) {
        accountDTOList.add(account);
        return "Depositor : " + account.getAccountHolder() +
                ", Account Number : " + account.getAccountNumber() +
                " was created.";
    }

    @Override
    public List<AccountDTO> getAccountsList() {
        return accountDTOList;
    }

    @Override
    public String withdraw(AccountDTO account) {
        double left = - account.getBalance();
        AccountDTO findAccount = accountDTOList.stream()
                .filter(i->i.getAccountNumber().equals(account.getAccountNumber()))
                .findFirst()
                .orElse(null);
        if(findAccount == null) return  "We can't find your account";
        if((left += findAccount.getBalance()) < 0)    return "You don't have enough amount";
        findAccount.setBalance(left);
        findAccount.setTransactionDate(new Date());
        return account.getBalance() + " $ was withdrawn from " + findAccount.getAccountHolder();
    }

    @Override
    public String deposit(AccountDTO account) {
        AccountDTO findAccount = accountDTOList.stream()
                .filter(i->i.getAccountNumber().equals(account.getAccountNumber()))
                .findFirst()
                .orElse(null);
        if(findAccount == null) return  "We can't find your account";
        findAccount.setBalance(findAccount.getBalance() + account.getBalance());
        findAccount.setTransactionDate(new Date());
        return account.getBalance() + " $ was withdrawn from " + findAccount.getAccountHolder();
    }

    @Override
    public String getBalance(AccountDTO account) {
        AccountDTO findAccount = accountDTOList.stream()
                .filter(i->i.getAccountNumber().equals(account.getAccountNumber()))
                .findFirst()
                .orElse(null);
        return (findAccount == null) ?
                "We can't find your account" :
                ("Balance of " + findAccount.getAccountHolder() + " : " + findAccount.getBalance());
    }

    @Override
    public String deleteAccount(AccountDTO account) {
        return accountDTOList.removeIf(i->i.getAccountNumber().equals(account.getAccountNumber())) ?
                "We can't find your account" : "Your Account was deleted";
    }
}
