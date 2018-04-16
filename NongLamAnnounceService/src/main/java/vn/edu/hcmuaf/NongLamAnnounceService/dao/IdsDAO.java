package vn.edu.hcmuaf.NongLamAnnounceService.dao;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class IdsDAO {
	public static String getName(String type, String value) {
		String s = "";
		try {
			Connection conn = MyConnection.getConnection();
			if (type.equals("id")) {
				String sql = "select * from accounts where id = ? ;";
				PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
				pr.setString(1, value);
				ResultSet rs = pr.executeQuery();
				while (rs.next()) {
					String fname = rs.getString("fname");
					String lname = rs.getString("lname");
					s = lname + " " + fname;
				}
				pr.close();
			} else if (type.equals("faculty_id")) {
				String sql = "select * from faculty where faculty_id = ? ;";
				PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
				pr.setString(1, value);
				ResultSet rs = pr.executeQuery();
				while (rs.next()) {
					String faculty_name = rs.getString("faculty_name");
					s = faculty_name;
				}
				pr.close();
			} else if (type.equals("class_id")) {
				String sql = "select * from class where class_id = ? ;";
				PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
				pr.setString(1, value);
				ResultSet rs = pr.executeQuery();
				while (rs.next()) {
					String class_name = rs.getString("class_name");
					s = class_name;
				}
				pr.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
}
