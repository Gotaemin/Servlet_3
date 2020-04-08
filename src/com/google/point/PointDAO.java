package com.google.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.google.util.DBConnect;

public class PointDAO {
	
	//list - select all
	public ArrayList<PointDTO> pointList() throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PointDTO pointDTO = null;
		ArrayList<PointDTO> pointList = new ArrayList<PointDTO>();
		
		Connection conn = DBConnect.getConnection();
		String sql = "select * from point order by num asc";
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			pointDTO = new PointDTO();
			pointDTO.setName(rs.getString(1));
			pointDTO.setNum(rs.getInt(2));
			pointDTO.setKor(rs.getInt(3));
			pointDTO.setEng(rs.getInt(4));
			pointDTO.setMath(rs.getInt(5));
			pointDTO.setSum(rs.getInt(6));
			pointDTO.setAvg(rs.getDouble(7));
			
			pointList.add(pointDTO);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return pointList;
	}
	
	//select one
	//insert
	//update
	//delete
	
}
