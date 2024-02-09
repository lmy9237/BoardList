package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConnection;

public class MemberDao {
	
	// 로그인 
	public boolean loginCheck(String id, String pw) {
		Connection conn = DBConnection.getConnection();
		String password = "";
		try {
			String sql = "SELECT pw FROM member1 WHERE id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				password = rs.getString("pw");
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return password.equals(pw);
	}
	
	public void join(String id, String pw, String name) {
		Connection conn = DBConnection.getConnection();
		String sql =  "INSERT INTO member1 values(?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	 }
}
