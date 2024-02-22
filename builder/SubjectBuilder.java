package builder;

import model.SubjectDTO;

public class SubjectBuilder {
    private int kor;
    private int eng;
    private int math;

    public SubjectBuilder kor(int kor) {
        this.kor = kor;
        return this;
    }

    public SubjectBuilder eng(int eng) {
        this.eng = eng;
        return this;
    }

    public SubjectBuilder math(int math) {
        this.math = math;
        return this;
    }

    public SubjectDTO build() {
        return new SubjectDTO(kor, eng, math);
    }
}
