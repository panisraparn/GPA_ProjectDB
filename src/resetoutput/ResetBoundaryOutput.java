package resetoutput;

import java.sql.*;

public class ResetBoundaryOutput {

    public static void main(String[] args) {
        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/gpa_project", "root", "");

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute the delete query
            int count = stmt.executeUpdate("DELETE FROM boundary_value_output");

            // Print the number of records deleted
            System.out.println(count + " records deleted");

            // Close the resources
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}



