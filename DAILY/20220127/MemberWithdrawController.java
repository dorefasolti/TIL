package com.readme.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.readme.member.model.service.MemberService;
import com.readme.member.model.vo.Member;

/**
 * Servlet implementation class MemberWithdrawController
 */
@WebServlet("/delete.me")
public class MemberWithdrawController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberWithdrawController() {
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

		 
		 int result = new MemberService().deleteMember(userId, userPwd);
		 System.out.println(result);
		 
		 if(result > 0) {
			 session.removeAttribute("loginUser");
			 request.getRequestDispatcher("views/member/myPageWithdrawSuccessView.jsp").forward(request, response);
		 } else {
			 request.getSession().setAttribute("alertMsg", "실패.");
//			 request.getRequestDispatcher("views/member/myPageWithdrawForm.jsp");
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
