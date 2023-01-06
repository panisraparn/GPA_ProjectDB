import model.TestingOutput;
import model.TestingOutputList;
import service.Database;
import service.Output_DBConnect;

public class ResetOutputTableMain {

    public static void main(String args[]) {
        Database<TestingOutput, TestingOutputList> database = new Output_DBConnect();
        database.deleteAllBoundaryValueRecord();
    }

}
