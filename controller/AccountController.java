package controller;

import model.Account;
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
        return accountService.creatAccount(Account.builder()
                .id(utilService.createRandomInt(1, 100))
                .accountNumber(scan.next())
                .accountHolder(scan.next())
                .balance(0.0)
                .transactionDate(new Date())
                .build());
    }

    public String getAccountsList() {
        System.out.println("== Account List ===");
        List<Account> list = accountService.getAccountsList();
        list.forEach(System.out::println);
        return "------------------";
    }

    public String withdraw(Scanner scan) {
        System.out.println("=== Withdraw ===");
        System.out.println("Input(Account Number, amount)");
        return accountService.withdraw(Account.builder()
                .accountNumber(scan.next())
                .balance(Double.parseDouble(scan.next()))
                .build());
    }

    public String deposit(Scanner scan) {
        System.out.println("=== Deposit ===");
        System.out.println("Input(Account Number, amount)");
        return accountService.deposit(Account.builder()
                .accountNumber(scan.next())
                .balance(Double.parseDouble(scan.next()))
                .build());
    }

    public String getBalance(Scanner scan) {
        System.out.println("=== Get Balance ===");
        System.out.println("Input(Account Number)");
        return accountService.getBalance(Account.builder()
                .accountNumber(scan.next())
                .build());
    }

    public String deleteAccount(Scanner scan) {
        System.out.println("=== Get Balance ===");
        System.out.println("Input(Account Number)");
        return accountService.deleteAccount(Account.builder()
                .accountNumber(scan.next())
                .build());
    }

    public String findAccount(Scanner scan) {
        System.out.println("=== Get Balance ===");
        System.out.println("Input(Account Number)");
        return accountService.findAccount(Account.builder()
                .accountNumber(scan.next())
                .build());
    }
}
