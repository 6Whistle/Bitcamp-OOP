package view;

import builder.UserBuilder;
import model.UserDTO;
import java.util.Scanner;

public class JoinView {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("입력(ID, 비밀번호, 비빌번호 확인, 이름, 주민번호, 전화번호, 주소, 직업)");
        UserDTO user = new UserBuilder()
                .username(scan.next())
                .password(scan.next())
                .passwordConfirm(scan.next())
                .name(scan.next())
                .socialSecurityNumber(scan.next())
                .phoneNumber(scan.next())
                .address(scan.next())
                .job(scan.next())
                .build();

        System.out.printf(user.toString());
    }
}
