package vn.edu.hcmuaf.NongLamAnnounceService.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import vn.edu.hcmuaf.NongLamAnnounceService.model.InfoGroupOfUser;

public class UserDAO {

	public static boolean login(String id, String pass)
	{
		try {
			Connection conn = MyConnection.getConnection();
			String sql = "call p_login(?, ?);";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, id);
			pr.setString(2, pass);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
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
				String class_name = rs.getString("class_name");
				String faculty_id = rs.getString("faculty_id");
				int number = rs.getInt("SL");
				InfoGroupOfUser i = new InfoGroupOfUser(id, class_id, class_name, faculty_id, number);
				list.add(i);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static boolean setLevel(String id, String target, String lv) {
		int i;
		String sql;
		byte v = 0;//level của người set quyền
		try {
			PreparedStatement pr;
			Connection conn = MyConnection.getConnection();
			byte l =  Byte.parseByte(lv);//level được cấp của người được set quyền
			
			sql = "select levels from accounts where id = ?;";
			pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, id);
			ResultSet rs = pr.executeQuery();
			while(rs.next()){
				v = rs.getByte("levels");
			}
			
			if(l < v){
				return false;
			}
			
			sql = "call p_update_level (?, ?);";
			pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, target);
			pr.setByte(2, l);
			i = pr.executeUpdate();
			pr.close();
			conn.close();
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
