package jdbcTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTestConnection {

	// Utility method to get a connection to the MySQL database
	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		return MySQLConnUtils.getMySQLConnection();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("Get connection... ");

		// Get a connection to the database
		Connection conn = MySQLTestConnection.getMyConnection();

		System.out.println("Opened connection: " + conn);

		// Create a statement for executing SQL queries
		Statement statement = conn.createStatement();

		// Define the SQL query
		String sql = "Select Emp.Emp_Id, Emp.First_Name, Emp.Last_Name, Emp.Dept_Id From Employee Emp;";

		// Execute the SQL query and retrieve the result set
		ResultSet rs = statement.executeQuery(sql);

		// Iterate over the result set and retrieve the data
		while (rs.next()) {
			// Retrieve the values of each column for the current row
			int empId = rs.getInt(1);
			String empFirstName = rs.getString(2);
			String empLastName = rs.getString("Last_Name");

			System.out.println("--------------------");
			System.out.println("Emp Id:" + empId);
			System.out.println("Emp Firstname:" + empFirstName);
			System.out.println("Emp Lastname:" + empLastName);
		}

		// Close the connection
		conn.close();
		System.out.println("---------- Closed connection ----------");
	}
}