package service;

import model.UserDTO;

public interface KaupService {
    public double createBMI(UserDTO user);

    public String createBodyMass(double bmi);
}

