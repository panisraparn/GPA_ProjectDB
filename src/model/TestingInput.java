package model;

public class TestingInput {

    private int inputId;
    private int grade;
    private int credit;


    public TestingInput(int inputId,int grade, int credit) {
        this.inputId = inputId;
        this.grade = grade;
        this.credit = credit;
    }

    public int getCredit() {
        return credit;
    }

    public int getGrade() {
        return grade;
    }

    public int getInputId() {
        return inputId;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setInputId(int inputId) {
        this.inputId = inputId;
    }

    //    public boolean IsGPAPass(TestingInput input){
//        if (input.get){
//
//        }
//    }

    public String toCsv() {
        return inputId + ", " + grade + "," + credit ;
    }

}
