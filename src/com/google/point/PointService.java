package com.google.point;

import java.util.ArrayList;

public class PointService {

	private PointDAO pointDAO = null;
	
	public PointService() {
		pointDAO = new PointDAO();
	}
	
	public ArrayList<PointDTO> pointList() throws Exception{
		
		ArrayList<PointDTO> pointList = pointDAO.pointList();
		
		return pointList;
	}
	
	
	public PointDTO pointSelect(int num) throws Exception{
		PointDTO pointDTO  = pointDAO.pointSelect(num);
		
		return pointDTO;
	}
	
	public int pointDelete(int num) throws Exception{
		
		return pointDAO.pointDelete(num);
	}
	
}
