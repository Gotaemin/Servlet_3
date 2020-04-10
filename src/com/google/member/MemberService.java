package com.google.member;

public class MemberService {

	private MemberDAO memberDAO = null;
	
	public MemberService() {
		memberDAO = new MemberDAO();
	}
	
	public int memberInsert(MemberDTO memberDTO) throws Exception {
		return memberDAO.memberInsert(memberDTO);
	}
	
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.memeberLogin(memberDTO);
	}
	
	public int memberDelete(String id) throws Exception{
		return memberDAO.memberDelete(id);
	}
	
	public int memberUpdate(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberUpdate(memberDTO);
	}
}
