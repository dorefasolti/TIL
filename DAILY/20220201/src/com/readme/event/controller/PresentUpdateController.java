package com.readme.event.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.readme.event.model.service.EventService;
import com.readme.member.model.vo.Member;

/**
 * Servlet implementation class PresentUpdateController
 */
@WebServlet("/presentgive.me")
public class PresentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PresentUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userPwd = request.getParameter("userPwd");
		
		HttpSession session = request.getSession();
		
		String userId = ((Member)session.getAttribute("loginUser")).getUserId();

		
		int result = new EventService().point(userId, userPwd);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "축하드립니다! 이벤트 응모 완료!");
			request.getRequestDispatcher("views/event/present.jsp").forward(request, response);
			
			
		} else {
			request.getSession().setAttribute("alertMsg", "포인트가 부족합니다 ㅠㅠ");
			request.getRequestDispatcher("views/event/present.jsp").forward(request, response);
			
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
