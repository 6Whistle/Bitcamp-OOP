package view;

import model.User;
import service.KaupService;
import service.UtilService;
import serviceImpl.KaupServiceImpl;
import serviceImpl.UtilServiceImpl;

public class KaupView {
    public static void main() {
        {
            UtilService util = UtilServiceImpl.getInstance();
            KaupService kaup = KaupServiceImpl.getInstance();

            User user = User.builder()
                    .height(util.createRandomDouble(150, 50))
                    .weight(util.createRandomInt(30, 70))
                    .build();

            double bmi = kaup.createBMI(user);

            System.out.printf("=============BMI 계산기==============\n" +
                              "BMI: %.1f\n" +
                              "BodyMass: %s\n" +
                              "====================================\n",
                              bmi, kaup.createBodyMass(bmi));
        }
    }
}
