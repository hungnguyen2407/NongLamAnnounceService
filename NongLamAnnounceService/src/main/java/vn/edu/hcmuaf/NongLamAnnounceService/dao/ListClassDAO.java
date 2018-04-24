package vn.edu.hcmuaf.NongLamAnnounceService.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import vn.edu.hcmuaf.NongLamAnnounceService.model.ListClass;

public class ListClassDAO {
	public static ListClass getListClass(String id) {	
		try {
			Connection conn = MyConnection.getConnection();
			String sql = "SELECT * FROM notiapp.list inner join notiapp.class on list.class_id= class.class_id where id=?;";
			PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
			pr.setString(1, id);
			ResultSet rs = pr.executeQuery();
			ListClass listClass = new ListClass();
			listClass.setId(id);
			List<String> listID = new ArrayList<String>();
			List<String> listName = new ArrayList<String>();
			while (rs.next()) {
				String classID = rs.getString("class_id");
				listID.add(classID);
				String className = rs.getString("class_name");
				listName.add(className);
			}
			listClass.setListClassID(listID);
			listClass.setListClassName(listName);
			
			pr.close();
			conn.close();
			return listClass;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
