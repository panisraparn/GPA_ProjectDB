package service;

import model.TestingInput;
import model.TestingInputList;
import model.TestingOutput;
import model.TestingOutputList;

import java.sql.*;

public class Output_DBConnect implements Database<TestingOutput, TestingOutputList> {

    //database connect
    public Connection conn = null;
    public Statement stmt = null;
    public ResultSet rs = null;

    //prepare for return readData
    private TestingOutput outputReadData;

    @Override
    public void insertDatabase(TestingOutput output) {
        //database connect
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gpa_project", "root", "");
            System.out.println("Connection is created successfully:");
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO  boundary_value_output " + "VALUES ('" + output.getOutputId() + "','" + output.getInputId() + "','" + output.getResult() + "')";
            stmt.executeUpdate(query1);
            System.out.println("Record is inserted in the table successfully..................");
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
    }

    public void insertRobustness(TestingOutput output){
        //database connect
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gpa_project", "root", "");
            System.out.println("Connection is created successfully:");
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO  robustness_output " + "VALUES ('" + output.getOutputId() + "','" + output.getInputId() + "','" + output.getResult() + "')";
            stmt.executeUpdate(query1);
            System.out.println("Record is inserted in the table successfully..................");
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
    }

    public void insertWorstCaseBoundaryOutput(TestingOutput output){
        //database connect
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gpa_project", "root", "");
            System.out.println("Connection is created successfully:");
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO  worst_case_of_boundary_value_output " + "VALUES ('" + output.getOutputId() + "','" + output.getInputId() + "','" + output.getResult() + "')";
            stmt.executeUpdate(query1);
            System.out.println("Record is inserted in the table successfully..................");
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
    }

    public void insertWorstCaseRobustnessOutput(TestingOutput output){
        //database connect
        Connection conn = null;
        Statement stmt = null;
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                System.out.println(e);
            }
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gpa_project", "root", "");
            System.out.println("Connection is created successfully:");
            stmt = (Statement) conn.createStatement();
            String query1 = "INSERT INTO  worst_case_of_robustness_output " + "VALUES ('" + output.getOutputId() + "','" + output.getInputId() + "','" + output.getResult() + "')";
            stmt.executeUpdate(query1);
            System.out.println("Record is inserted in the table successfully..................");
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
    }



    @Override
    public TestingOutput readRecord(String query) {
        //prepare data
        int outputId    ;
        int inputId ;
        String result ;

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
                outputId = Integer.parseInt(rs.getString(1));
                inputId = Integer.parseInt(rs.getNString(2));
                result = rs.getString(3);


                this.outputReadData = new TestingOutput (outputId, inputId, result);
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

        return outputReadData;
    }


    // return list จากในตาราง my sql
    @Override
    public TestingOutputList readDatabase(String q) {
        TestingOutputList list = new TestingOutputList();
        TestingOutput outputReadData = new TestingOutput(0,0,"0");

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

                outputReadData = new TestingOutput(outputId, inputId, result);
                list.addTestingOutput(outputReadData);
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
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/gpa_project", "root", "");
            PreparedStatement st = connection.prepareStatement("DELETE FROM boundary_value_output");
            st.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }


}
