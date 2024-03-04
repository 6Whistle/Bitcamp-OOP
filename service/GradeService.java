package service;

import model.Subject;

public interface GradeService {
    public int getTotalScore(Subject subject);

    public double getAvgScore(int total);
}
