package db;

import java.sql.*;
public class DBConnection {
	private static Connection con;
	
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/participation_record", "root", "");
		return con;
	}
}
