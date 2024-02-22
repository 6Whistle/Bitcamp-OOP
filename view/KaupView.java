package view;

import builder.UserBuilder;
import model.UserDTO;
import service.KaupService;
import serviceImpl.KaupServiceImpl;

public class KaupView {
    public static double returnRandomHeight(){     return Math.random() * 50 + 150;    }
    public static double returnRandomWeight(){     return Math.random() * 30 + 50;     }

    public static void main(String[] args) {
        {
            System.out.println("입력값(키 몸무게)");
            UserDTO user = new UserBuilder()
                    .height(returnRandomHeight())
                    .weight(returnRandomWeight())
                    .build();
            System.out.println(user.toString());;

            KaupService service = new KaupServiceImpl();
            double bmi = service.createBMI();
            String bodyMass = service.createBodyMass();

            System.out.println("===BMI 계산기====");
            System.out.println("이름: " + user.getName());
            System.out.println("몸무게: " + user.getWeight());
            System.out.println("키: " + user.getHeight());
            System.out.println("BMI: " + bmi);
            System.out.println("BodyMass: " + bodyMass);
        }
    }
}
