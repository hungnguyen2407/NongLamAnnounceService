package vn.edu.hcmuaf.NongLamAnnounceService.dao;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class UserConnection {
	public static Connection getConnection(String user, String pass) {
		Connection connection = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/NotiApp?verifyServerCertificate=true&useSSL=true";
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
		// Kiem tra
		Connection connection = getConnection("root", "admin");
		if (connection != null) {
			System.out.println("Kết nối thành công");
		} else {
			System.out.println("Kết nối thất bại");
		}
	}
}
