package com.readme.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readme.member.model.service.MemberService;
import com.readme.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String birth = request.getParameter("birth");
		String eventAssent = request.getParameter("eventAssent");
		String infoAssent= request.getParameter("infoAssent");
		
	
		Member m = new Member(userId, userPwd, userName, email, gender, birth, eventAssent, infoAssent);
		

		int result = new MemberService().updateMember(m);
		
		System.out.println(result);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "성공");
			request.getRequestDispatcher("views/member/myPageProfileUpdateForm.jsp").forward(request, response);
		} 
		else {
			request.getSession().setAttribute("alertMsg", "실패");
			response.sendRedirect(request.getContextPath()+"/views/member/myPageProfileUpdateForm.jsp");

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
