package serviceImpl;

import model.User;
import service.KaupService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KaupServiceImpl implements KaupService {
    private static KaupService instance = new KaupServiceImpl();

    Map<?, ?> userDTOMap;
    List<?> userDTOList;
    private KaupServiceImpl() {
        userDTOMap = new HashMap<>();
        userDTOList = new ArrayList<>();
    }

    public static KaupService getInstance() {
        return instance;
    }

    @Override
    public double createBMI(User user) {
        return user.getWeight() / Math.pow(user.getHeight() / 100, 2);
    }

    @Override
    public String createBodyMass(double bmi) {
        return bmi <= 18.5 ? "저체중" :
               bmi <= 25 ? "정상" :
               bmi <= 30 ? "과체중" :
               bmi <= 35 ? "비만" :
               bmi <= 40 ? "고도비만" :
                           "초고도비만";
    }
}

