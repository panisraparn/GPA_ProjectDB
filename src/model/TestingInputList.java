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

//    public TestingOutputList searchPassInput(TestingInputList list){
//        TestingOutputList outputList = new TestingOutputList();
//        for(TestingInput input: this.testingInputs){
//            TestingInput inputResult = input;
//            TestingOutput outputResult = new TestingOutput(input.getInputId(), input.getInputId(), "N");
//            if(input.getGrade() >= 0 && input.getGrade() <= 4 && input.getCredit() >=0 && input.getCredit() <= 134  ){
//                outputResult.setResult("P");
//            }
//            else {
//                outputResult.setResult("F");
//            }
//            outputList.addTestingOutput(outputResult);
//        }
//        return outputList;
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
