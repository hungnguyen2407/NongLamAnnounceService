package vn.edu.hcmuaf.NongLamAnnounceService.dao;

import java.sql.DriverManager;

public class Connection {
	public static Connection getConnection() {
		Connection connection = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/NotiApp";
		String user = "root";
		String pass = "admin";
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
		Connection connection = getConnection();
		if (connection != null) {
			System.out.println("Kết nối thành công");
		} else {
			System.out.println("Kết nối thất bại");
		}
	}
}
