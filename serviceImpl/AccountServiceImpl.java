package serviceImpl;

import model.AccountDTO;
import service.AccountService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private static AccountService instance = new AccountServiceImpl();

    private final List<AccountDTO> accountDTOList;
    private AccountServiceImpl(){
        accountDTOList = new ArrayList<>();
    }

    public static AccountService getInstance() {
        return instance;
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
        AccountDTO findAccount = accountDTOList.stream()
                .filter(i->i.getAccountNumber().equals(account.getAccountNumber()))
                .findFirst()
                .orElse(null);
        if(findAccount == null) return  "We can't find your account";

        double left = findAccount.getBalance() - account.getBalance();
        if(left < 0)    return "You don't have enough amount";

        findAccount.setBalance(account.getBalance());
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
        if(findAccount == null) return  "We can't find your account";

        return "Balance of " + findAccount.getAccountHolder() + " : " + findAccount.getBalance();
    }

    @Override
    public String deleteAccount(AccountDTO account) {
        for(int i = 0; i < accountDTOList.size(); i++){
            if(accountDTOList.get(i).getAccountNumber().equals(account.getAccountNumber())){
                accountDTOList.remove(i);
                return "Your Account was deleted";
            }
        }
        return "We can't find your account";
    }
}
