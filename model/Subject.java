package model;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Subject {
    private int kor;
    private int eng;
    private int math;

    @Builder
    public Subject(int kor, int eng, int math){
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}
