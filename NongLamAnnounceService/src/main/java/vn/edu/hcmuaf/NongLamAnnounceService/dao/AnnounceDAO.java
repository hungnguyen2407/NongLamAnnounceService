package vn.edu.hcmuaf.NongLamAnnounceService.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import vn.edu.hcmuaf.NongLamAnnounceService.model.Announce;

public class AnnounceDAO {
	public static List<Announce> getAnnounceList() {
		List<Announce> list = new ArrayList<Announce>();
		try {
			Connection conn = MyConnection.getConnection();
			String sql = "select * from post order by post_date desc;";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				String postId = rs.getString("post_id");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String classId = rs.getString("class_id");
				String date = rs.getDate("post_date")+"";
				Announce a = new Announce(postId, id, title, content, classId, date);
				list.add(a);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Announce> getAnnounceList(String group_id) {
		List<Announce> list = new ArrayList<Announce>();
		try {
			Connection conn = MyConnection.getConnection();
			String sql = "select * from post where class_id = ? order by post_date desc;";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, group_id);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				String postId = rs.getString("post_id");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String classId = rs.getString("class_id");
				String date = rs.getDate("post_date")+"";
				Announce a = new Announce(postId, id, title, content, classId, date);
				list.add(a);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Announce> getAnnounceListForUser(String id) {
		List<Announce> list = new ArrayList<Announce>();
		try {
			Connection conn = MyConnection.getConnection();
			String sql = "call p_dsClass(?);";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, id);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				String classId = rs.getString("class_id");
				list.addAll(getAnnounceList(classId));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static Announce getRecentAnnounce() {
		Announce p = new Announce();
		try {
			Connection conn = MyConnection.getConnection();
			String sql = "select * from post order by post_date desc limit 1;";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				String postId = rs.getString("post_id");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String classId = rs.getString("class_id");
				String date = rs.getDate("post_date")+"";
				p.setPostId(postId);
				p.setId(id);
				p.setTitle(title);
				p.setContent(content);
				p.setClassId(classId);
				p.setDate(date);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public static boolean insertAnnounce(String id, String title, String content, String class_id) {
		int i;
		try {
			Connection conn = MyConnection.getConnection();
			String sql = "call p_insert_post (?, ?, ?, ?);";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, id);
			pr.setNString(2, title);
			pr.setNString(3, content);
			pr.setString(4, class_id);
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
