package com.google.bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.google.util.DBConnect;

public class BbsDAO {
	
	public int bbsDelete(int no) throws Exception{
		Connection conn = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "delete from bbs where no = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}
	
	public int bbsUpdate(String title, String Contents,int no) throws Exception{
		Connection conn = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "update bbs set title=?, contents=? where no=?"; 
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, Contents);
		pstmt.setInt(3, no);
		
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();

		return result;
	}
	
	public int countUpdate(int count,int no) throws Exception{
		Connection conn = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "update bbs set count=? where no=?"; 
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, count);
		pstmt.setInt(2, no);
		
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();

		return result;
	}
	
	public int bbsInsert(BbsDTO bbsDTO) throws Exception{
		Connection conn = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into bbs values(seq.nextval,?,?,0,?)"; //title,name,contents
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bbsDTO.getTitle());
		pstmt.setString(2, bbsDTO.getName());
		pstmt.setString(3, bbsDTO.getContents());
		
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		return result;
	}
	
	public BbsDTO getBbs(int no) throws Exception{
		BbsDTO bbsDTO = new BbsDTO();
		
		Connection conn = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from bbs where no = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		rs = pstmt.executeQuery();

		// no, title, name, day, count,contents
		if (rs.next()) {
			bbsDTO.setNo(rs.getInt(1));
			bbsDTO.setTitle(rs.getString(2));
			bbsDTO.setName(rs.getString(3));
			bbsDTO.setDay(rs.getDate(4));
			bbsDTO.setCount(rs.getInt(5));
			bbsDTO.setContents(rs.getString(6));
		}

		rs.close();
		pstmt.close();
		conn.close();

		return bbsDTO;
	}

	public ArrayList<BbsDTO> getBbsList() throws Exception {
		ArrayList<BbsDTO> bbsList = new ArrayList<BbsDTO>();
		BbsDTO bbsDTO = null;

		Connection conn = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from bbs order by day desc";

		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		// no, title, name, day, count,contents
		while (rs.next()) {
			bbsDTO = new BbsDTO();
			bbsDTO.setNo(rs.getInt(1));
			bbsDTO.setTitle(rs.getString(2));
			bbsDTO.setName(rs.getString(3));
			bbsDTO.setDay(rs.getDate(4));
			bbsDTO.setCount(rs.getInt(5));
			bbsDTO.setContents(rs.getString(6));

			bbsList.add(bbsDTO);
		}

		rs.close();
		pstmt.close();
		conn.close();

		return bbsList;
	}

}
