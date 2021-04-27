package com.sbs.edu.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sbs.edu.mvc.vo.MemberVO;

public class MemberDAO {
	// 싱글톤 패턴
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {}
	
	public static MemberDAO getInstance() {
		return dao;
	} 
	
	public Connection connect() {
		Connection conn = null;
		
		try { 		    
		    String dbURL = "jdbc:mysql://localhost:3306/board?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";                             
		    String dbID = "root";
		    String dbPassword = "1234";
		    Class.forName("com.mysql.cj.jdbc.Driver");				 
			conn = DriverManager.getConnection(dbURL,dbID,dbPassword); 
		}
		catch (Exception e) {
			System.out.println("jdbc err : " + e.getMessage());
		}
		
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void close(Connection conn, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		if (conn != null) {
			try {
				conn.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void memberInsert(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connect();
			String sql = " INSERT INTO MEMBER (userid, userpw, name, main, content) ";
			sql += " VALUES(?, ?, ?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserid());
			pstmt.setString(2, member.getUserpw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getMain());
			pstmt.setString(5, "");
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			close(conn, pstmt);
		}
	}
	
	public MemberVO memberSearch(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVO member = null;
		
		try {
			conn = connect();
			String sql = " SELECT * FROM MEMBER WHERE userid = ? ";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				member = new MemberVO();
				member.setUserid(rs.getString(2));
				member.setUserpw(rs.getString(3));
				member.setMain(rs.getString(4));
				member.setName(rs.getString(5));
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			close(conn, pstmt, rs);
		}
		
		return member;
	}
	
	public void memberUpdate(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connect();
			String sql = " UPDATE member SET userpw = ?, name = ?, main = ? WHERE userid = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUserpw());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getMain());
			pstmt.setString(4, member.getUserid());
			pstmt.execute();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			close(conn, pstmt);
		}
	}
	
	public ArrayList<MemberVO> memberList() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		MemberVO member  		= null;		
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("SELECT * FROM MEMBER");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				member = new MemberVO();
				member.setUserid(rs.getString(1));
				member.setUserpw(rs.getString(2));
				member.setName(rs.getString(3));
				member.setMain(rs.getString(4));
				list.add(member);				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("오류 발생 : " + e);
		}
		finally {
			close(conn, pstmt, rs);
		}		
		
		return list;
	}
}
