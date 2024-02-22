package view;

import builder.SubjectBuilder;
import model.SubjectDTO;

import java.util.Scanner;

public class GradeView {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("입력(국어, 영어, 수학)");
        SubjectDTO sub = new SubjectBuilder()
                .kor(scan.nextInt())
                .eng(scan.nextInt())
                .math(scan.nextInt())
                .build();
        System.out.println(sub.toString());
    }
}
