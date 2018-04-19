package vn.edu.hcmuaf.NongLamAnnounceService.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

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
}
