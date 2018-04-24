package vn.edu.hcmuaf.NongLamAnnounceService.code;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import vn.edu.hcmuaf.NongLamAnnounceService.dao.MyConnection;

public class TestSQL {
public static void main(String[] args) throws SQLException {
	Connection conn = MyConnection.getConnection();
	String sql = "SELECT * FROM notiapp.accounts where id='14130126';";

	PreparedStatement pr = (PreparedStatement) conn.prepareStatement(sql);
	ResultSet rs = pr.executeQuery();
//    pstm.setString(1, userName);
//    pstm.setString(2, password);
//    ResultSet rs = pstm.executeQuery();

    if (rs.next()) {
    	String userID = rs.getString("id");
    	String userName = rs.getString("fname");
    	System.out.println(userID + userName);
    }
    
}
}
