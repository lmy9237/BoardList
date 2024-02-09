package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnection;
import vo.BoardVo;
import vo.ReplyVo;

public class BoardDao {
	public ArrayList<BoardVo> getAllList(int pageNum) {
		ArrayList<BoardVo> listRet = new ArrayList<BoardVo>();
		Connection conn = DBConnection.getConnection();
		
		int endRnum = pageNum * 20;   // p.1--->20, p.2--->40, p.3--->60
		int startRnum = endRnum - 19;
		
//		String sql = "SELECT * FROM board1 ORDER BY bno DESC";
//		String sql = "SELECT t2.*" + 
//					" FROM (SELECT rownum rnum, t1.* FROM (SELECT * FROM board1 ORDER BY bno DESC) t1) t2" + 
//					" WHERE t2.rnum>=? AND t2.rnum<=?";
		String sql = "SELECT t2.*, (SELECT count(*) FROM reply1 WHERE bno=t2.bno) nor" 
					+ " FROM (SELECT rownum rnum, t1.* FROM (SELECT * FROM board1 ORDER BY bno DESC) t1) t2" 
					+ " WHERE t2.rnum>=? AND t2.rnum<=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRnum);  // ex. 21
			pstmt.setInt(2, endRnum);  // ex. 40
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String writedate = rs.getString("writedate");
				int nor = rs.getInt("nor");  // num of replies
				listRet.add(new BoardVo(bno, title, content, writer, writedate, nor));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return listRet;
	}
	
	// 마지막 페이지번호를 리턴.
	public int getLastPageNum() {
		Connection conn = DBConnection.getConnection();
		
		String sql = "SELECT count(*) FROM board1";
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		if(cnt%20==0)
			return cnt/20;
		return cnt/20 + 1;
	}
	
	// bno --> BoardVO 객체를 리턴.
	public BoardVo getBoardVOByBno(int bno) {
		Connection conn = DBConnection.getConnection();
		BoardVo vo = null;
		
		String sql = "SELECT b.*, (SELECT count(*) FROM reply1 WHERE bno=b.bno) nor"
					+ " FROM board1 b WHERE bno=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String writedate = rs.getString("writedate");
				int nor = rs.getInt("nor");
				vo = new BoardVo(bno, title, content, writer, writedate, nor);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public void write(String title,String content, String writer) {
		Connection conn = DBConnection.getConnection();
		String sql = "INSERT INTO  board1(bno,title,content,writer,writedate) "
				+ " VALUES (SEQ_BOARD1.nextval, ?, ?, ?, sysdate)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, writer);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public void delete(int bno) {
		Connection conn = DBConnection.getConnection();
		try {
			String sql = "DELETE FROM board1 WHERE bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void update(BoardVo vo) {
		Connection conn = DBConnection.getConnection();
		try {
			String sql = "UPDATE board1 SET title=?, content=? WHERE bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBno());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ReplyVo> getReplyListByBno(int bno) {
		ArrayList<ReplyVo> listRet = new ArrayList<ReplyVo>();
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT * FROM reply1 WHERE bno=? ORDER BY rno DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rno = rs.getInt("rno");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String writedate = rs.getString("writedate");
				ReplyVo vo = new ReplyVo(rno, bno, content, writer, writedate);
				listRet.add(vo);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return listRet;
	}
	
	public boolean replyDeleteByRno(int rno) {
		Connection conn = DBConnection.getConnection();
		String sql = "DELETE FROM reply1 WHERE rno=?";
		int ret = -1;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rno);
			ret = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return ret==1;
	}
}
















