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
		
		int result = bbsDAO.bbsUpdate(title, contents, no); 
		
		return result;
	}
	
	public int bbsInsert(BbsDTO bbsDTO) throws Exception{
		return bbsDAO.bbsInsert(bbsDTO);
	}
	
	
	public BbsDTO getBbs(int no) throws Exception{
		
		BbsDTO bbsDTO = bbsDAO.getBbs(no); 
		
		int count = bbsDTO.getCount()+1;
		bbsDAO.countUpdate(count,no);

		bbsDTO.setCount(count);
		
		return bbsDTO;
	}
	
	public ArrayList<BbsDTO> getBbsList() throws Exception{
		
		return bbsDAO.getBbsList();
	}
}
