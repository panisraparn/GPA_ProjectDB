package service;

import model.TestingInput;
import model.TestingInputList;
import model.TestingOutputList;

public class RobustnessMain {

    TestingInputList list = new TestingInputList();

    Database<TestingInput, TestingInputList> database = new Input_DBConnect();
    String query1 = "Select * FROM Robustness;";
//    list = database.readDatabase(query1);
}
