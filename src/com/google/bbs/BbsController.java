package com.google.bbs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BbsController")
public class BbsController extends HttpServlet {
	private BbsService bbsService = null;

	public BbsController() {
		super();
		bbsService = new BbsService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");

		String command = request.getPathInfo();
		String method = request.getMethod();
		String path = "";
		boolean check = true;
		
		getServletConfig(); //현재 Servlet의 객체 저장 - web.xml의 <servlet>의 정보
		getServletContext(); //전체 정보를 저장하는 객체(=application, context) - web.xml의 전체 정보

//		System.out.println(command);
//		System.out.println(method);
		try {
			if (command.equals("/bbsList")) {
//				System.out.println("bbsList");

				// DB Select
				ArrayList<BbsDTO> bbsList = bbsService.getBbsList();

				request.setAttribute("bbsList", bbsList);

				path = "../WEB-INF/views/bbs/bbsList.jsp";

			} else if (command.equals("/bbsUpdate")) {
//				System.out.println("bbsUpdate");
				
				if (method.equals("POST")) {
					//DB Update
					
					String title = request.getParameter("title");
					String contents = request.getParameter("contents");
					int no = Integer.parseInt(request.getParameter("no"));
					
					int result = bbsService.bbsUpdate(title, contents, no);
					
					if(result > 0) {
						path = "./bbsSelect?no="+no;
					}
					
				} else {
					int no = Integer.parseInt(request.getParameter("no"));
					BbsDTO bbsDTO =  bbsService.getBbs(no);
					request.setAttribute("bbsDTO", bbsDTO);
					
					path = "../WEB-INF/views/bbs/bbsUpdate.jsp";
				}

			} else if (command.equals("/bbsWrite")) {
//				System.out.println("bbsWrite");
				if (method.equals("POST")) {
					//DB insert 
					
					//HttpSession session = request.getSession();
					
					String title = request.getParameter("title");
					String contents = request.getParameter("contents");
					String name = "admin";
					
					BbsDTO bbsDTO = new BbsDTO();
					bbsDTO.setTitle(title);
					bbsDTO.setContents(contents);
					bbsDTO.setName(name);    //Session 값으로 변경해야됨  <<<<<<<<<<<<<<<<
					
					int result = bbsService.bbsInsert(bbsDTO);
					
					if(result > 0) {
						path = "./bbsList";
					}
					
				} else {
					path = "../WEB-INF/views/bbs/bbsWrite.jsp";
				}
			} else if (command.equals("/bbsSelect")) {
//				System.out.println("bbsSelect");
				//DB select one 
				int no = Integer.parseInt(request.getParameter("no"));
				BbsDTO bbsDTO =  bbsService.getBbs(no);
				
				System.out.println(bbsDTO);
				
				request.setAttribute("bbsDTO", bbsDTO);
				
				path = "../WEB-INF/views/bbs/bbsSelect.jsp";
			}else if(command.equals("/bbsDelete")) {
				
				int no = Integer.parseInt(request.getParameter("no"));
				
				int result = bbsService.bbsDelete(no);
				System.out.println(result);
				
				if(result > 0) {
					check = false;
					path = "./bbsList";
				}
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!path.equals("")) {
			if (check) {
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect(path);
			}
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
