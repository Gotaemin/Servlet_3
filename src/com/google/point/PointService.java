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
	
	public int pointInsert(PointDTO pointDTO) throws Exception{
		pointDTO.setSum(pointDTO.getKor() + pointDTO.getEng() + pointDTO.getMath());
		pointDTO.setAvg(pointDTO.getSum()/3.0);
		
		int result = pointDAO.pointInsert(pointDTO);
		
		return result;
	}
	
	public int pointUpdate(PointDTO pointDTO) throws Exception{
		pointDTO.setSum(pointDTO.getKor() + pointDTO.getEng() + pointDTO.getMath());
		pointDTO.setAvg(pointDTO.getSum()/3.0);
		
		int result = pointDAO.pointUpdate(pointDTO);
		
		return result;
		
	}
	
}
