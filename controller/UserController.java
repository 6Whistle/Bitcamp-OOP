package controller;

import builder.UserBuilder;
import model.UserDTO;
import service.UserService;
import serviceImpl.UserServiceImpl;

import java.util.Map;
import java.util.Scanner;

public class UserController {
    UserService userService;

    public UserController() {
        this.userService = UserServiceImpl.getInstance();
    }


    public String addUser() {
        return userService.addUsers();
    }

    public String join(Scanner scan) {
        System.out.println("=== 회원가입 ===");
        System.out.println("입력(ID, PW, PW 확인, 이름, 주민번호, 전화번호, 주소, 직장");
        return userService.join(new UserBuilder()
                .username(scan.next())
                .password(scan.next())
                .passwordConfirm(scan.next())
                .name(scan.next())
                .socialSecurityNumber(scan.next())
                .phoneNumber(scan.next())
                .address(scan.next())
                .job(scan.next())
                .build());
    }

    public String login(Scanner scan) {
        System.out.println("=== 로그인 ===");
        System.out.println("입력(ID, PW)");
        return userService.login(new UserBuilder()
                .username(scan.next())
                .password(scan.next())
                .build());
    }

    public void getUserByUsername() {
    }

    public void deleteUser() {
    }

    public Map<String, UserDTO> getUserMap() {
        System.out.println("=== 회원 목록 ===");
        Map<String, UserDTO> user = userService.getUserMap();
        user.forEach((k, v) -> System.out.printf("{%s, %s}\n", k, v));
        return user;
    }

    public void findUsersByName() {
    }

    public void findUsersByJob() {
    }

    public String getUsersCount() {
        return userService.getUsersCount();
    }
}
