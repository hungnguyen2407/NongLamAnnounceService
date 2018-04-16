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
				Date date = rs.getDate("post_date");
				p.setPostId(postId);
				p.setId(id);
				p.setTitle(title);
				p.setContent(content);
				p.setClassId(classId);
				p.setDate(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
}
