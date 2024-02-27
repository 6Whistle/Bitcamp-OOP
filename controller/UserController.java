package controller;

import builder.UserBuilder;
import java.util.Scanner;
import service.UserService;
import serviceImpl.UserServiceImpl;

public class UserController {

    UserService auth;

    public UserController(){
        this.auth = UserServiceImpl.getInstance();
    }
    public void addUsers(){
        System.out.println(auth.addUsers());
    }

    public void join(Scanner scan){
        System.out.println("=== 회원가입 ===");
        System.out.println("입력(ID, 비밀번호, 비빌번호 확인, 이름, 주민번호, 전화번호, 주소, 직업)");
        System.out.println(auth.join(new UserBuilder()
                .username(scan.next())
                .password(scan.next())
                .passwordConfirm(scan.next())
                .name(scan.next())
                .socialSecurityNumber(scan.next())
                .phoneNumber(scan.next())
                .address(scan.next())
                .job(scan.next())
                .build()));
    }
    public void login(Scanner scan){
        System.out.println("=== 로그인 ===");
        System.out.println("입력(ID, 비밀번호)");
        System.out.println(auth.login(new UserBuilder()
                .username(scan.next())
                .password(scan.next())
                .build()));
    }
    public void findUserByID(Scanner scan){
        System.out.println("=== ID 검색 ===");
        System.out.println("입력(ID)");
        System.out.println(auth.findUser(scan.next()));
    }

    public void getUsersMap(){
        System.out.println("=== 회원목록 ===");
        auth.getUserMap().forEach((k, v) -> System.out.printf("{%s, %s}\n", k, v));
    }

    public void countUsers(){
        System.out.println("=== 회원수 ===");
        System.out.println(auth.countUsers());
    }
}
