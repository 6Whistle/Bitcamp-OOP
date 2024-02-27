package controller;


import builder.UserBuilder;
import model.UserDTO;
import service.AuthService;
import serviceImpl.AuthServiceImpl;

import java.util.Scanner;

public class AuthController {

    AuthService auth;

    public AuthController(){
        this.auth = AuthServiceImpl.getInstance();
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
        System.out.println(auth.findUserByID(scan.next()));
    }
    public void updatePassword(Scanner scan){
        System.out.println("=== 비번 변경 ===");
        System.out.println("입력(ID, 비번)");
        auth.updatePassword(scan.next(), scan.next());
    }
    public void deleteUser(Scanner scan){
        System.out.println("=== 탈퇴 ===");
        System.out.println("입력(ID)");
        auth.deleteUser(scan.next());
    }
    public void getUsersList(){
        System.out.println("=== 회원목록 ===");
        auth.getUserMap();
    }
    public void findUsersByName(Scanner scan){
        System.out.println("=== 이름 검색 ===");
        System.out.println("입력(이름)");
        auth.findUsersByJob(scan.next()).forEach(i -> System.out.println(i));
    }
    public void findUsersByJob(Scanner scan){
        System.out.println("=== 직업 검색 ===");
        System.out.println("입력(직업)");
        auth.findUsersByJob(scan.next()).forEach(i -> System.out.println(i));

    }
    public void countUsers(){
        System.out.println("=== 회원수 ===");
        System.out.println(auth.countUsers());
    }


}