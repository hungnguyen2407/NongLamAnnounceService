package vn.edu.hcmuaf.NongLamAnnounceService.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import vn.edu.hcmuaf.NongLamAnnounceService.model.InfoGroupOfUser;
import vn.edu.hcmuaf.NongLamAnnounceService.model.InformationUser;

public class UserDAO {

	public static boolean login(String id, String pass) {
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

	public static List<InfoGroupOfUser> getdsGroupOfUser(String id) {
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
		byte v = 0;// level của người set quyền
		try {
			PreparedStatement pr;
			Connection conn = MyConnection.getConnection();
			byte l = Byte.parseByte(lv);// level được cấp của người được set
										// quyền

			sql = "select levels from accounts where id = ?;";
			pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, id);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				v = rs.getByte("levels");
			}

			if (l < v) {
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

	public static InformationUser getInfoUser(String id) {
		InformationUser u = new InformationUser();
		try {
			Connection conn = MyConnection.getConnection();
			String sql = "select * from v_account where id = ?;";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, id);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				String uid = rs.getString("id");
				String email = rs.getString("email");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String birthday = rs.getString("birthday");
				String faculty_id = rs.getString("faculty_id");
				String class_id = rs.getString("class_id");
				u.setId(uid);
				u.setEmail(email);
				u.setfName(fname);
				u.setlName(lname);
				u.setBirthday(birthday);
				u.setFacultyID(faculty_id);
				u.setClassID(class_id);
			}
			conn.close();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			return u;
		}
	}

	public static boolean addUser(String id, String email, String fname, String lname, String birthday,
			String faculty_id, String class_id, String url_avatar) {
		int i;
		try {
			StringTokenizer st = new StringTokenizer(birthday, "-");
			String s = "";
			while (st.hasMoreTokens()) {
				s += st.nextToken();
			}
			
			Connection conn = MyConnection.getConnection();
			String sql = "call p_insert_accounts (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, id);
			pr.setNString(2, email);
			pr.setNString(3, fname);
			pr.setString(4, lname);
			pr.setString(5, birthday);
			pr.setString(6, faculty_id);
			pr.setString(7, class_id);
			pr.setString(8, s);//gán giá trị pass ban đầu là ngày tháng năm sinh theo định dạng yyyymmdd
			pr.setString(9, url_avatar);
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
	
	public static boolean updatePassword(String id, String pass) {
		int i;
		try {
			Connection conn = MyConnection.getConnection();
			String sql = "call p_update_pass (?, ?);";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, id);
			pr.setNString(2, pass);
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
