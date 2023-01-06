package service;

import model.Expected;
import model.ExpectedList;
import model.TestingOutput;
import model.TestingOutputList;

import java.sql.*;

public class Expected_DBConnect implements Database<Expected, ExpectedList>{

    //database connect
    public Connection conn = null;
    public Statement stmt = null;
    public ResultSet rs = null;

    //prepare for return readData
    private Expected expectedReadData;


    @Override
    public void insertDatabase(Expected expected) {
    }

    //return object
    @Override
    public Expected readRecord(String query) {

        return null;
    }

    //return list
    @Override
    public ExpectedList readDatabase(String q) {
        ExpectedList list = new ExpectedList();
        Expected expectedReadData = new Expected(0,0,"0");

        //DB connect
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/gpa_project", "root", "");
            System.out.println("Connection is created successfully:");

            stmt = conn.createStatement();
            rs = stmt.executeQuery(q);

            while (rs.next()) {
                int outputId = Integer.parseInt(rs.getString(1));
                int inputId  =Integer.parseInt(rs.getString(2));
                String result = rs.getString(3);

                expectedReadData = new Expected(outputId, inputId, result);
                list.add(expectedReadData);
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
}
