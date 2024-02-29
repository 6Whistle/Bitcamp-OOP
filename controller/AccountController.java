package controller;

import builder.AccountBuilder;
import model.AccountDTO;
import service.AccountService;
import service.UtilService;
import serviceImpl.AccountServiceImpl;
import serviceImpl.UtilServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AccountController {
    private final AccountService accountService;
    private final UtilService utilService;

    public AccountController(){
        accountService = AccountServiceImpl.getInstance();
        utilService = UtilServiceImpl.getInstance();
    }

    public String creatAccount(Scanner scan) {
        System.out.println("=== Create Account ===");
        System.out.println("Input(Account Number, Depositor)");
        return accountService.creatAccount(new AccountBuilder()
                .id(utilService.createRandomInt(1, 100))
                .accountNumber(scan.next())
                .accountHolder(scan.next())
                .balance(0.0)
                .transactionDate(new Date())
                .build());
    }

    public String getAccountsList() {
        System.out.println("== Account List ===");
        List<AccountDTO> list = accountService.getAccountsList();
        list.forEach(System.out::println);
        return "------------------";
    }

    public String withdraw(Scanner scan) {
        System.out.println("=== Withdraw ===");
        System.out.println("Input(Account Number, amount)");
        return accountService.withdraw(new AccountBuilder()
                .accountNumber(scan.next())
                .balance(Double.parseDouble(scan.next()))
                .build());
    }

    public String deposit(Scanner scan) {
        System.out.println("=== Deposit ===");
        System.out.println("Input(Account Number, amount)");
        return accountService.deposit(new AccountBuilder()
                .accountNumber(scan.next())
                .balance(Double.parseDouble(scan.next()))
                .build());
    }

    public String getBalance(Scanner scan) {
        System.out.println("=== Get Balance ===");
        System.out.println("Input(Account Number)");
        return accountService.getBalance(new AccountBuilder()
                .accountNumber(scan.next())
                .build());
    }

    public String deleteAccount(Scanner scan) {
        System.out.println("=== Get Balance ===");
        System.out.println("Input(Account Number)");
        return accountService.deleteAccount(new AccountBuilder()
                .accountNumber(scan.next())
                .build());
    }

    public String findAccount(Scanner scan) {
        System.out.println("=== Get Balance ===");
        System.out.println("Input(Account Number)");
        return accountService.findAccount(new AccountBuilder()
                .accountNumber(scan.next())
                .build());
    }
}
