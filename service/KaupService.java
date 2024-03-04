package service;

import model.User;

public interface KaupService {
    public double createBMI(User user);

    public String createBodyMass(double bmi);
}

