package vn.edu.hcmuaf.NongLamAnnounceService.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.edu.hcmuaf.NongLamAnnounceService.model.UserGroup;

public class GroupDAO {
	public static boolean joinGroup(String class_id, String id){
		int i;
		try {
			Connection conn = MyConnection.getConnection();
			String sql = "insert into list values (?, ?);";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, class_id);
			pr.setString(2, id);
			i = pr.executeUpdate();
			pr.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		if (i > 0) {
			return true;
		}
		return false;
	}
	
	public static boolean outGroup(String class_id, String id){
		int i;
		try {
			Connection conn = MyConnection.getConnection();
//			String sql = "call p_del_list(?, ?);";
			String sql = "exec p_del_list ?, ?;";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, class_id);
			pr.setString(2, id);
			i = pr.executeUpdate();
			pr.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		if (i > 0) {
			return true;
		}
		return false;
	}

	public static boolean accedeGroup(String class_id, String id) {
		int i;
		try {
			Connection conn = MyConnection.getConnection();
			String sql = "insert into temp_group values (?, ?);";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, class_id);
			pr.setString(2, id);
			i = pr.executeUpdate();
			pr.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		if (i > 0) {
			return true;
		}
		return false;
	}

	public static boolean outAccedeGroup(String class_id, String id) {
		int i;
		try {
			Connection conn = MyConnection.getConnection();
			String sql = "delete from temp_group where class_id = ? and id = ?;";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, class_id);
			pr.setString(2, id);
			i = pr.executeUpdate();
			pr.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		if (i > 0) {
			return true;
		}
		return false;
	}

	public static List<UserGroup> getMembersOfGroup(String class_id) {
		List<UserGroup> list = new ArrayList<UserGroup>();
		try {
			Connection conn = MyConnection.getConnection();
			String sql = "exec p_dsAccount ?";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, class_id);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String email = rs.getString("email");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				byte level = rs.getByte("levels");
				UserGroup a = new UserGroup(id, email, fname, lname, level);
				list.add(a);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
