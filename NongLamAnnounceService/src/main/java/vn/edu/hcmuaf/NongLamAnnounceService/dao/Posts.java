package vn.edu.hcmuaf.NongLamAnnounceService.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import vn.edu.hcmuaf.NongLamAnnounceService.model.Post;

public class Posts {
	public static List<Post> getPosts() {
		List<Post> list = new ArrayList<Post>();
		return list;
	}

	public static Post getRecentPost() {
		Post p = new Post();
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
				Date postDate = rs.getDate("post_date");
				p.setPostId(postId);
				p.setId(id);
				p.setTitle(title);
				p.setContent(content);
				p.setClassId(classId);
				p.setPostDate(postDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
}
