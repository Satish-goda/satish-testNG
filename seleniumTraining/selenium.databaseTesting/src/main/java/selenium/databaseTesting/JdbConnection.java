package selenium.databaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		String host = "localhost";
		String port = "3306";
		Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo", "root",
				"ctuser"); // jdbc:mysql://<host>:<port><databaseName><username><password>
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from credentials");

		while (rs.next()) {
			System.out.print(rs.getNString("username"));
			System.out.print("   ");
			System.out.print(rs.getNString("scenario"));
			System.out.print("   ");
			System.out.println(rs.getNString("password"));
		}
		
	}

}
