package vn.edu.hcmuaf.NongLamAnnounceService.dao;

import java.sql.Date;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserDAO {

	public static boolean login(String id, String pass)
	{
		boolean valid = false;
		Connection conn = MyConnection.getConnection();
		//TODO
		return valid;
	}
}
