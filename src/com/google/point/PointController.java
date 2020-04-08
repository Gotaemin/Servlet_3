package com.google.point;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PointController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String command = request.getPathInfo();
		String method = request.getMethod();
		
		boolean check = true; //forward: true  / redirect: false
		
		String path = "";  //url경로
		
		if(command.equals("/pointList")) {
			System.out.println("pointList");
		}else if(command.equals("/pointAdd")) {
			System.out.println("pointAdd");
		}else if(command.equals("/pointSelect")) {
			System.out.println("pointSelect");
		}else if(command.equals("/pointMod")) {
			System.out.println("pointMod");
		}else if(command.equals("/pointDelete")) {
			System.out.println("pointDelete");
		}else {
			System.out.println("etc");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
