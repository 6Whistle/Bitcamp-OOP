package serviceImpl;

import service.UtilService;

public class UtilServiceImpl implements UtilService {

    private static UtilService instance = new UtilServiceImpl();

    private UtilServiceImpl(){}

    public static UtilService getInstance(){
        return instance;
    }

    @Override
    public int createRandomInt(int begin, int range) {
        return begin + (int)(Math.random() * range);
    }

    @Override
    public double createRandomDouble(double begin, double range) {
        return Math.floor((begin + Math.random() * range) * 10) / 10.0;
    }
}
