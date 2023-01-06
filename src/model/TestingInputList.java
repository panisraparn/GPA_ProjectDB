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
