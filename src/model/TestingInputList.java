package model;

import java.util.ArrayList;

public class TestingInputList {
    private ArrayList<TestingInput> testingInputs;
//    private ArrayList<TestingInput> resultTestingBoundaryInputs;

    public TestingInputList(){
        testingInputs = new ArrayList<>();
    }

    //เพิ่ม testingInput
    public void addTestingInput(TestingInput input){
        testingInputs.add(input);
    }

    //หา set pass and file
    public TestingInputList searchPassInput(TestingInputList list){
        for(TestingInput input: this.testingInputs){
            TestingInput inputResult = input;
            if(input.getGrade() >= 0 && input.getGrade() <= 4 && input.getCredit() >=0 && input.getCredit() <= 134  ){
                input.setResult("P");
            }
            else {
                input.setResult("F");
            }
            list.addTestingInput(inputResult);
        }
        return list; //list ที่รับมา มาเก็บค่า ของ list output
    }

//        //หา set pass and file
//    public ArrayList<TestingInput> searchPassInput() {
//        ArrayList<TestingInput> resultInputList = new ArrayList<TestingInput>();
//        for (TestingInput input : this.testingInputs) {
////            TestingInput inputResult = input;
//            if (input.getGrade() >= 0 && input.getGrade() <= 4 && input.getCredit() >= 0 && input.getCredit() <= 134) {
//                input.setResult("P");
//            } else {
//                input.setResult("F");
//            }
//            System.out.println("here");
////            inputResult.toCsv();
//            resultInputList.add(input);
//        }
//        return resultInputList;
//    }




    // เรียกดู input ทั้งหมด
    public ArrayList<TestingInput> getTestingInputs(){
     return testingInputs;
    }

    public String toCsv() {
        String result = "";
        for (TestingInput testingInput : this.testingInputs){
            result += testingInput.toCsv() + "\n";
        }
        return result;
    }
}
