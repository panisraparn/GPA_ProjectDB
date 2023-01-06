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
