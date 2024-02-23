package service;

import model.SubjectDTO;

public interface GradeService {
    public int getTotalScore(SubjectDTO subject);

    public double getAvgScore(int total);
}
