package model;

import java.util.ArrayList;

public class ExpectedList {

    private ArrayList<Expected> expectedLists;
//    private ArrayList<TestingInput> resultTestingBoundaryInputs;

    public ExpectedList(){
        expectedLists = new ArrayList<>();
    }

    //เพิ่ม testingOutput
    public void add(Expected expected){
        expectedLists.add(expected);
    }



    // เรียกดู input ทั้งหมด
    public ArrayList<Expected> getExpectedList(){
        return expectedLists;
    }

    public String toCsv() {
        String result = "";
        for (Expected expected : this.expectedLists){
            result += expected.toCsv() + "\n";
        }
        return result;
    }
}
