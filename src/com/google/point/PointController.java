package com.google.point;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PointService pointService = null;	
	ArrayList<PointDTO> pointList = null;

	public PointController() {
		super();
		pointService = new PointService();
		pointList = new ArrayList<PointDTO>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String command = request.getPathInfo();
		String method = request.getMethod();

		boolean check = true; // forward: true / redirect: false

		String path = ""; // url경로

		try {
			if (command.equals("/pointList")) {
				// System.out.println("pointList");

				pointList = pointService.pointList();
				request.setAttribute("pointList", pointList);

				path = "../WEB-INF/views/point/pointList.jsp";

			} else if (command.equals("/pointAdd")) {
				// System.out.println("pointAdd");
				if (method.equals("POST")) {
					// Service로 이동 (DB insert)
				} else {
					path = "../WEB-INF/views/point/pointAdd.jsp";
				}

			} else if (command.equals("/pointSelect")) {
				// System.out.println("pointSelect");

				int num = Integer.parseInt(request.getParameter("num"));

				PointDTO pointDTO = pointService.pointSelect(num);
				request.setAttribute("pointSelect", pointDTO);

				path = "../WEB-INF/views/point/pointSelect.jsp";

			} else if (command.equals("/pointMod")) {
				// System.out.println("pointMod");
				if (method.equals("POST")) {
					// Service로 이동(DB Update)
				} else {
					path = "../WEB-INF/views/point/pointMod.jsp";
				}

			} else if (command.equals("/pointDelete")) {
				// System.out.println("pointDelete");
				// Service로 이동(DB Delete)
				int num = Integer.parseInt(request.getParameter("num"));
				
				int result = pointService.pointDelete(num);
				if(result > 0 ) {
					check = false;
					path = "./pointList";
				}
				
			} else {
				// System.out.println("etc");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		if (check) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(path);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
