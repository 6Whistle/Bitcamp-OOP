package view;

import builder.UserBuilder;
import model.UserDTO;
import service.KaupService;
import service.UtilService;
import serviceImpl.KaupServiceImpl;
import serviceImpl.UtilServiceImpl;

public class KaupView {
    public static void main(String[] args) {
        {
            UtilService utilService = UtilServiceImpl.getInstance();
            KaupService kaupService = KaupServiceImpl.getInstance();

            UserDTO user = new UserBuilder()
                    .height(utilService.createRandomDouble(150, 50))
                    .weight(utilService.createRandomInt(30, 70))
                    .build();

            System.out.println("입력값(키, 몸무게");
            System.out.println(user.toString());


            double bmi = kaupService.createBMI();
            String bodyMass = kaupService.createBodyMass();
//
//            System.out.println("===BMI 계산기====");
//            System.out.println("BMI: " + bmi);
//            System.out.println("BodyMass: " + bodyMass);
        }
    }
}
