package com.google.bbs;

import java.util.ArrayList;

public class BbsService {
	
	private BbsDAO bbsDAO = null;
	
	public BbsService() {
		bbsDAO = new BbsDAO();
	}
	
	public int bbsDelete(int no) throws Exception{
		return bbsDAO.bbsDelete(no);
	}
	
	
	public int bbsUpdate(String title,String contents,int no) throws Exception{
		return bbsDAO.bbsUpdate(title, contents, no);
	}
	
	public int bbsInsert(BbsDTO bbsDTO) throws Exception{
		return bbsDAO.bbsInsert(bbsDTO);
	}
	
	
	public BbsDTO getBbs(int no) throws Exception{
		return bbsDAO.getBbs(no);
	}
	
	public ArrayList<BbsDTO> getBbsList() throws Exception{
		
		return bbsDAO.getBbsList();
	}
}
