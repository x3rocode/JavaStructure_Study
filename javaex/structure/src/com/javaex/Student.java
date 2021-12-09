package javaex.structure.src.com.javaex;

/*
 성적 처리
 1. 입력(이름, 국 영 수)
 2. 검색(이름, 평균(50점 이상))
 3. 출력(전체출력)
 */


public class Student {

    private String name;
    private int kor_grade;
    private int eng_grade;
    private int mat_grade;
    private float average;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getKor_grade() {
        return kor_grade;
    }
    public void setKor_grade(int kor_grade) {
        this.kor_grade = kor_grade;
    }
    public int getEng_grade() {
        return eng_grade;
    }
    public void setEng_grade(int eng_grade) {
        this.eng_grade = eng_grade;
    }
    public int getMat_grade() {
        return mat_grade;
    }
    public void setMat_grade(int mat_grade) {
        this.mat_grade = mat_grade;
    }
    public float getAverage() {
        return average;
    }
    public void setAverage(float average) {
        this.average = average;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        String data = "name : " + this.name + "kor : " + this.kor_grade + 
        "eng : " + this.eng_grade + "math : " + this.mat_grade;
        return data;
    }
    
}
