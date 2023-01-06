import model.TestingInput;
import model.TestingInputList;
import model.TestingOutput;
import model.TestingOutputList;
import service.Database;
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
        TestingOutput  output = new TestingOutput();
        database1.insertDatabase(output);





        System.out.println(testingOutputList.toCsv());





    }
}
