package vn.edu.hcmuaf.NongLamAnnounceService.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
				String url_img = rs.getString("url_img");
				Announce a = new Announce(postId, id, title, content, classId, date, url_img);
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
				String url_img = rs.getString("url_img");
				Announce a = new Announce(postId, id, title, content, classId, date, url_img);
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
//			String sql = "call p_dsClass(?);";
			String sql = "exec p_dsClass ?;";
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
//			String sql = "select * from post order by post_date desc limit 1;";
			String sql = "select top 1 * from post order by post_date desc;";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				String postId = rs.getString("post_id");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String classId = rs.getString("class_id");
				String date = rs.getDate("post_date")+"";
				String url_img = rs.getString("url_img");
				p.setPostId(postId);
				p.setId(id);
				p.setTitle(title);
				p.setContent(content);
				p.setClassId(classId);
				p.setDate(date);
				p.setUrl_img(url_img);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public static boolean insertAnnounce(String id, String title, String content, String class_id, String url_img) {
		int i;
		try {
			Connection conn = MyConnection.getConnection();
//			String sql = "call p_insert_post (?, ?, ?, ?, ?);";
			String sql = "exec p_insert_post ?, ?, ?, ?, ?;";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, id);
			pr.setNString(2, title);
			pr.setNString(3, content);
			pr.setString(4, class_id);
			pr.setNString(5, url_img);
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

	public static boolean deleteAnnounce(String post_id) {
		int i;
		try {
			Connection conn = MyConnection.getConnection();
//			String sql = "call p_del_post (?);";
			String sql = "exec p_del_post ?;";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			int id = Integer.parseInt(post_id);
			pr.setInt(1, id);
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

	public static boolean updateAnnounce(String post_id, String title, String content, String url_img) {
		int i;
		try {
			Connection conn = MyConnection.getConnection();
//			String sql = "call p_update_post (?, ?, ?, ?);";
			String sql = "exec p_update_post ?, ?, ?, ?;";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			int id = Integer.parseInt(post_id);
			pr.setInt(1, id);
			pr.setNString(2, title);
			pr.setNString(3, content);
			pr.setNString(4, url_img);
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
