package vn.edu.hcmuaf.NongLamAnnounceService.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import vn.edu.hcmuaf.NongLamAnnounceService.model.InfoGroupOfUser;

public class UserDAO {

	public static boolean login(String id, String pass)
	{
		boolean valid = false;
		Connection conn = MyConnection.getConnection();
		//TODO
		return valid;
	}
	
	public static List<InfoGroupOfUser> getdsGroupOfUser(String id){
		List<InfoGroupOfUser> list = new ArrayList<InfoGroupOfUser>();
		
		try {
			Connection conn = MyConnection.getConnection();
			String sql = "call p_dsClass(?);";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, id);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				String class_id = rs.getString("class_id");
				String email = rs.getString("email");
				String lname = rs.getString("lname");
				String fname = rs.getString("fname");
				String faculty_id = rs.getString("faculty_id");
				InfoGroupOfUser i = new InfoGroupOfUser(id, class_id, email, lname, fname, faculty_id);
				list.add(i);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
