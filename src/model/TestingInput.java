package model;

public class TestingInput {

    private int grade;
    private int credit;
    private String result;

    public TestingInput(int grade, int credit, String result) {
        this.grade = grade;
        this.credit = credit;
        this.result = result;
    }

    public int getCredit() {
        return credit;
    }

    public int getGrade() {
        return grade;
    }

    public String getResult() {
        return result;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setResult(String result) {
        this.result = result;
    }

//    public boolean IsGPAPass(TestingInput input){
//        if (input.get){
//
//        }
//    }

    public String toCsv() {
        return grade + "," + credit + "," + result ;
    }
}
