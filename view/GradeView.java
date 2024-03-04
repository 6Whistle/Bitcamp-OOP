package view;

import model.Subject;
import model.User;
import service.GradeService;
import service.UtilService;
import serviceImpl.GradeServiceImpl;
import serviceImpl.UtilServiceImpl;

import java.util.Scanner;

public class GradeView {
    public static void main(Scanner scan) {
        GradeService grade = GradeServiceImpl.getInstance();
        UtilService util = UtilServiceImpl.getInstance();

        System.out.print("이름 입력 : ");
        User user = User.builder()
                .username(scan.next())
                .build();
        Subject sub = Subject.builder()
                .kor(util.createRandomInt(0, 100))
                .eng(util.createRandomInt(0, 100))
                .math(util.createRandomInt(0, 100))
                .build();

        int totalScore = grade.getTotalScore(sub);

        System.out.printf("================ 성적표 ================\n" +
                          "이름: %s\n" +
                          "국어: %3d\t 영어: %3d\t 수학: %3d\n" +
                          "총점: %3d       \t\t\t 평균: %5.1f\n" +
                          "=======================================\n",
                          user.getUsername(),
                          sub.getKor(), sub.getEng(), sub.getMath(),
                          totalScore, grade.getAvgScore(totalScore));
    }
}
