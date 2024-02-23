package view;

import builder.SubjectBuilder;
import builder.UserBuilder;
import model.SubjectDTO;
import model.UserDTO;
import service.GradeService;
import service.UtilService;
import serviceImpl.GradeServiceImpl;
import serviceImpl.UtilServiceImpl;


import java.util.Scanner;

public class GradeView {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        GradeService grade = GradeServiceImpl.getInstance();
        UtilService util = UtilServiceImpl.getInstance();

        System.out.print("이름 입력 : ");
        UserDTO user = new UserBuilder()
                .username(scan.next())
                .build();
        SubjectDTO sub = new SubjectBuilder()
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
