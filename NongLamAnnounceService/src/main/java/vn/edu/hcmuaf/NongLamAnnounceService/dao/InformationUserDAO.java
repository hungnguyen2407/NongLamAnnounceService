package vn.edu.hcmuaf.NongLamAnnounceService.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import vn.edu.hcmuaf.NongLamAnnounceService.model.InformationUser;

public class InformationUserDAO {
	public static InformationUser getInforUser(String id){
		try {
			Connection conn = MyConnection.getConnection();
			String sql = "SELECT * FROM notiapp.accounts where id=?;";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, id);
			ResultSet rs = pr.executeQuery();
			InformationUser user = new InformationUser();
			if (rs.next()) {
				String userID = rs.getString("id");
				String userEmail = rs.getString("email");
				String userFName = rs.getString("fname");
				String userLName = rs.getString("lname");
				String userFacultyID = rs.getString("faculty_id");
				String userClassID = rs.getString("class_id");
				user.setId(userID);
				user.setEmail(userEmail);
				user.setfName(userFName);
				user.setlName(userLName);
				user.setFacultyID(userFacultyID);
				user.setClassID(userClassID);
			}
			pr.close();
			conn.close();
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
