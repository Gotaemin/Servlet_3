package com.google.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.google.util.DBConnect;

import sun.security.pkcs11.Secmod.DbMode;

public class MemberDAO {

	public int memberInsert(MemberDTO memberDTO) throws Exception {
		Connection conn = DBConnect.getConnection();
		
		PreparedStatement pstmt = null;
		
		String sql = "insert into member values(?,?,?,?,?,?)"; //id,pwd,name,phone,email,age
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberDTO.getId());
		pstmt.setString(2, memberDTO.getPwd());
		pstmt.setString(3, memberDTO.getName());
		pstmt.setString(4, memberDTO.getPhone());
		pstmt.setString(5, memberDTO.getEmail());
		pstmt.setInt(6, memberDTO.getAge());
		
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
		
	}
	
	public MemberDTO memeberLogin(MemberDTO memberDTO) throws Exception{
		
		Connection conn = DBConnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member where id = ? and pwd = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberDTO.getId());
		pstmt.setString(2, memberDTO.getPwd());
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			memberDTO.setName(rs.getString(3));
			memberDTO.setPhone(rs.getString(4));
			memberDTO.setEmail(rs.getString(5));
			memberDTO.setAge(rs.getInt(6));
		}else {
			memberDTO = null;
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return memberDTO;
	}
}




















