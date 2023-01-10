import model.*;
import service.Database;
import service.Expected_DBConnect;
import service.Input_DBConnect;
import service.Output_DBConnect;

public class BoundaryValueMain {

    public static void main(String args[])
    {
        TestingInputList list = new TestingInputList();

        //อ่าน database ของ document
        Database<TestingInput, TestingInputList> database = new Input_DBConnect();
        String query1 = "Select * FROM boundary_value;";
        //เอาที่อ่านจาก database มาใส่ list
        list = database.readDatabase(query1);//ได้  list ทั้งหมดจากตาราง boundary_value

//        String query2 = "Select * FROM boundary_value;";
        TestingOutputList testingOutputList = new TestingOutputList();
        testingOutputList = testingOutputList.searchPassInput(list); //ได้ list output

        // insert list Output
        // ใช้ Db
        Database<TestingOutput, TestingOutputList> database1 = new Output_DBConnect();

        //for loop วน Output list
        for(int i = 0; i < 9; i++){
            TestingOutput output = new TestingOutput(testingOutputList.getTestingOutputs().get(i).getInputId(), testingOutputList.getTestingOutputs().get(i).getInputId(), testingOutputList.getTestingOutputs().get(i).getResult());
            database1.insertBoundaryOutput(output);
        }


//        System.out.println(testingOutputList.toCsv());

        String query3 = "Select * FROM boundary_value_expected;";
        String query4 = "Select * FROM boundary_value_output;";
        Database<Expected, ExpectedList> database2 = new Expected_DBConnect();
        Database<TestingOutput, TestingOutputList> database3 = new Output_DBConnect();
        ExpectedList expectedList = database2.readDatabase(query3);
        TestingOutputList outputList = database3.readDatabase(query4);

        int x = 0;
        for(int i = 0; i < 9; i++) {
            Expected expected = expectedList.getExpectedList().get(i);
            if(expected.getExpect_result().equals(outputList.getTestingOutputs().get(i).getResult())) {
                x++;
            }
        }

        if(x == 9) {
            System.out.println("Test Pass :)");
        } else {
            System.out.println("Test Fail :(");
        }





    }
}
