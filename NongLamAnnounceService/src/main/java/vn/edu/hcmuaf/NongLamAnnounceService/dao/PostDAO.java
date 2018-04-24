package vn.edu.hcmuaf.NongLamAnnounceService.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import vn.edu.hcmuaf.NongLamAnnounceService.model.Post;

public class PostDAO {
	public static List<Post> getPost(String id) {
		try {
			Connection conn = MyConnection.getConnection();
			String sql = "SELECT * FROM notiapp.post where class_id=?;";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, id);
			ResultSet rs = pr.executeQuery();
			List<Post> list = new ArrayList<Post>();
			while (rs.next()) {
				String postID = rs.getString("id");
				String postTitle = rs.getString("title");
				String postContent = rs.getString("content");
				String postClassID = rs.getString("class_id");
				Date postDate = rs.getDate("post_date");
				list.add(new Post(postID, postTitle, postContent, postClassID, postDate));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		List<Post> list = PostDAO.getPost("DHNL");
		
	}
}
