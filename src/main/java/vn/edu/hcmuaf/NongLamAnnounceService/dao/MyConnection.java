package vn.edu.hcmuaf.NongLamAnnounceService.dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class MyConnection {
	public static Connection getConnection() {
		Connection connection = null;
//		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://localhost:3306/NotiApp?verifyServerCertificate=true&useSSL=true";
//		String user = "root";
//		String pass = "admin";
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://projectmid.database.windows.net:1433;database=NotiApp";
		String user = "nguyentu@projectmid";
		String pass = "Microsoft@24";
		try {
			Class.forName(driver);
			connection = (Connection) DriverManager.getConnection(url, user, pass);
			
		} catch (Exception e) {
			// Orther err
			e.printStackTrace();
		}
		return connection;
	}

	public static void main(String[] args) {
		//Kiem tra
		Connection connection = getConnection();
		if (connection != null) {
			System.out.println("Kết nối thành công");
		} else {
			System.out.println("Kết nối thất bại");
		}
	}
}
