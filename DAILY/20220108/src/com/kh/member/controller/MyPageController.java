package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyPageController
 */

@WebServlet("/myPage.me")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 전
		
		
		// 접속자의 정보 => session
		// 로그인 전 : loginUser 키값에 해당하는 밸류 null => alert으로 경고
		// 로그인 후 : loginUser 키값에 해당하는 밸류가 들어있음 => 포워딩
		HttpSession session = request.getSession();
		//세션객체에 접근
		if(session.getAttribute("loginUser") == null) { //로그인 전
		
			session.setAttribute("alertMsg", "로그인 후 이용 가능한 서비스입니다.");
			//괘씸한 놈 => 메인페이지로 소환 => /jsp => sendRedirect형식
			response.sendRedirect(request.getContextPath());
			
		} else { 		//로그인 후
			
			request.getRequestDispatcher("views/member/myPage.jsp").forward(request, response);
		}
		
		

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
