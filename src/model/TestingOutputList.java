package model;

import java.util.ArrayList;

public class TestingOutputList {

    private ArrayList<TestingOutput> testingOutputs;
//    private ArrayList<TestingInput> resultTestingBoundaryInputs;

    public TestingOutputList(){
        testingOutputs = new ArrayList<>();
    }

    //เพิ่ม testingOutput
    public void addTestingOutput(TestingOutput output){
        testingOutputs.add(output);
    }

    public TestingOutputList searchPassInput(TestingInputList list){
        TestingOutputList outputList = new TestingOutputList();
        for(TestingInput input: list.getTestingInputs()){
//            System.out.println("line 22; " + input.getInputId() + ", " + input.getGrade() + "\n");
            TestingInput inputResult = input;
            TestingOutput outputResult = new TestingOutput(input.getInputId(), input.getInputId(), "N");
            if(input.getGrade() >= 0 && input.getGrade() <= 4 && input.getCredit() >=0 && input.getCredit() <= 134  ){
//                System.out.println("เข้า\n");
                outputResult.setResult("P");
//                System.out.println("line28; " + outputResult.getOutputId() + ", " +outputResult.getResult() + "\n");
            }
            else {
                outputResult.setResult("F");
            }
            outputList.addTestingOutput(outputResult);
        }
        return outputList;
    }

    // เรียกดู input ทั้งหมด
    public ArrayList<TestingOutput> getTestingOutputs(){
        return testingOutputs;
    }

    public String toCsv() {
        String result = "";
        for (TestingOutput output : this.testingOutputs){
            result += output.toCsv() + "\n";
        }
        return result;
    }

}
