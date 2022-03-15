package databaseservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseImpl implements Database{
	
	private Connection con;
	private final String driver;
	private String url;
	private String user;
	private String password;
	
	public DatabaseImpl() {
		this.driver = "com.mysql.jdbc.Driver";
		this.url = "jdbc:mysql://localhost:3306/sms?useSSL=false";
		this.user = "root";
		this.password = "";
	}
	
	@SuppressWarnings("finally")
	@Override
	public Connection getDatabaseConnection() {
		try {
			Class.forName(user);
			con = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("DB Connection Successfull");
		} catch (ClassNotFoundException exc) {
			System.out.println("Class not found");
			System.out.println(exc.getMessage());
		} catch (SQLException exc) {
			System.out.println("SQL Error");
			System.out.println(exc.getMessage());
		} finally {
			return con;
		}
	}

}
