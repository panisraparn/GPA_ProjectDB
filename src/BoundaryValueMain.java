import model.TestingInput;
import model.TestingInputList;
import service.Database;
import service.Input_DBConnect;

public class BoundaryValueMain {

    public static void main(String args[])
    {
        TestingInputList list = new TestingInputList();

        //อ่าน database ของ document
        Database<TestingInput, TestingInputList> database = new Input_DBConnect();
        String query1 = "Select * FROM boundary_value;";
        //เอาที่อ่านจาก database มาใส่ list
        list = database.readDatabase(query1); //ได้  list ทั้งหมดจากตาราง boundary_value

//        System.out.println(list.toCsv());





    }
}
