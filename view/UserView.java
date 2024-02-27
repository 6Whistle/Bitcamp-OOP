package view;

import controller.UserController;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner scan) {
        UserController controller = new UserController();
        controller.addUsers();

        while(true){
            System.out.println("[메뉴] 0.종료, 1.회원가입, 2.로그인, 3.ID 탐색, 4.회원목록, 5.회원수");
            switch (scan.next()){
                case "0" : System.out.println("종료");           return;
                case "1" : controller.join(scan);               break;
                case "2" : controller.login(scan);              break;
                case "3" : controller.findUserByID(scan);       break;
                case "4" : controller.getUsersMap();           break;
                case "5" : controller.countUsers();             break;
                default  :  System.out.println("잘못된 입력입니다");
            }
        }
    }
}
