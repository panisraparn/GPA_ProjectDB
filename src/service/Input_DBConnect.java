package service;

import model.TestingInput;
import model.TestingInputList;

import java.sql.*;

public class Input_DBConnect implements Database<TestingInput, TestingInputList> {

    //database connect
    public Connection conn = null;
    public Statement stmt = null;
    public ResultSet rs = null;

    //prepare for return readData
    private TestingInput inputReadData;

    @Override
    public void insertDatabase(TestingInput input) {

    }




    @Override
    public TestingInput readRecord(String query) {
        //prepare data
        int inputId ;
        int grade    ;
        int credit ;


        //DB connect
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gpa_project", "root", "");
            System.out.println("Connection is created successfully:");

            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()){
                inputId = Integer.parseInt(rs.getString(1));
                grade = Integer.parseInt(rs.getString(2));
                credit = Integer.parseInt(rs.getNString(3));


                this.inputReadData = new TestingInput (inputId, grade, credit);
//                System.out.println(empLoginAccount.toCsv());
            }
            System.out.println("loginAccount can use from jdbc");
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {}
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
//        System.out.println("Please check it in the MySQL Table......... ……..");

        return inputReadData;
    }


    // return list จากในตาราง my sql
    @Override
    public TestingInputList readDatabase(String q) {
        TestingInputList list = new TestingInputList();
        TestingInput inputReadData = new TestingInput(0,0,0);

        //DB connect
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gpa_project", "root", "");
            System.out.println("Connection is created successfully:");

            stmt = conn.createStatement();
            rs = stmt.executeQuery(q);

            while (rs.next()) {
                int inputId = Integer.parseInt(rs.getString(1));
                int grade = Integer.parseInt(rs.getString(2));
                int credit  =Integer.parseInt(rs.getString(3));

                inputReadData = new TestingInput(inputId,grade, credit);
                list.addTestingInput(inputReadData);
//                System.out.println(empLoginAccount.toCsv());
            }
            System.out.println("list can use from jdbc");
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Please check it in the MySQL Table......... ……..");

        return list;
    }

    @Override
    public void updateDatabase(String q) {
    }

    @Override
    public void deleteAllBoundaryValueRecord() {

    }
}
