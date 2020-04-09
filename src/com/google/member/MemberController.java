package com.google.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MemberController")
public class MemberController extends HttpServlet {

	private MemberService memberService = null;

	public MemberController() {
		super();
		memberService = new MemberService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String path = request.getPathInfo();
		boolean check = true;
		String method = request.getMethod();

//		System.out.println("MEthod: " + method );
//		System.out.println("path: "+path);

		try {
			if (path.equals("/memberJoin")) {
				if (method.equals("POST")) {
					// DB에 회원정보 insert

					String id = request.getParameter("id");
					String pwd = request.getParameter("pwd");
					String name = request.getParameter("name");
					String phone = request.getParameter("phone");
					String email = request.getParameter("email");
					int age = Integer.parseInt(request.getParameter("age"));

					MemberDTO memberDTO = new MemberDTO();
					memberDTO.setId(id);
					memberDTO.setPwd(pwd);
					memberDTO.setName(name);
					memberDTO.setPhone(phone);
					memberDTO.setEmail(email);
					memberDTO.setAge(age);

					int result = memberService.memberInsert(memberDTO);
					String msg = "회원 가입 실패";
					if (result > 0) {
						msg = "회원가입 성공";
						path = "../WEB-INF/views/common/result.jsp";
					} else {
						path = "../";
					}
					
					request.setAttribute("msg", msg);
					request.setAttribute("path", "${pageContext.request.contextPath}");

				} else {
					// memberJoin.jsp로 이동
					path = "../WEB-INF/views/member/memberJoin.jsp";
				}
			} else if (path.equals("/memberLogin")) {
				if (method.equals("POST")) {
					
					String id = request.getParameter("id");
					String pwd = request.getParameter("pwd");
					String remember = request.getParameter("remember");
					
					MemberDTO memberDTO =  new MemberDTO();
					memberDTO.setId(id);
					memberDTO.setPwd(pwd);
					
					memberDTO = memberService.memberLogin(memberDTO);
					
					if(memberDTO != null) {
						//System.out.println("로그인 성공");
						
						HttpSession session = request.getSession();
						session.setAttribute("member", memberDTO);
						
						check =false;
						path = "../";
						
					}else {
						//System.out.println("로그인 실패");
						request.setAttribute("msg", "로그인 실패");
						request.setAttribute("path", "./memberLogin");
						
						path = "../WEB-INF/views/common/result.jsp";
					}
				} else {
					// memberLogin.jsp 페이지
					path = "../WEB-INF/views/member/memberLogin.jsp";
				}
			}else if(path.equals("/memberLogout")) {
				HttpSession session = request.getSession();
				session.removeAttribute("member");
				
				check = false;
				path = "../";
			}else if (path.equals("/memberPage")) {
				
				HttpSession session = request.getSession();
				MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
				
				request.setAttribute("member", memberDTO);
				
				path = "../WEB-INF/views/member/memberPage.jsp";
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
