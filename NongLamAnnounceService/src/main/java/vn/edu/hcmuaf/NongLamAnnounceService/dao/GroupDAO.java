package vn.edu.hcmuaf.NongLamAnnounceService.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
