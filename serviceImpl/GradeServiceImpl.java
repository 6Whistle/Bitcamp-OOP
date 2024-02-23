package serviceImpl;

import model.SubjectDTO;
import service.GradeService;

public class GradeServiceImpl implements GradeService {
    private static GradeService instance = new GradeServiceImpl();

    public GradeServiceImpl(){}

    public static GradeService getInstance(){
        return instance;
    }
    @Override
    public int getTotalScore(SubjectDTO subject) {
        return subject.getKor() + subject.getEng() + subject.getMath();
    }

    @Override
    public double getAvgScore(int total) {
        return total / 3.0;
    }
}
