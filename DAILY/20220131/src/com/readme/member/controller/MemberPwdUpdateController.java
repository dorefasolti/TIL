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
 * Servlet implementation class MemberPwdUpdateController
 */
@WebServlet("/updatePwd.me")
public class MemberPwdUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPwdUpdateController() {
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
		String updatePwd = request.getParameter("updatePwd");
		
		
		Member updateMem = new MemberService().updatePwdMember(userId, userPwd, updatePwd);
	
		
		if(updateMem != null) {
			HttpSession session = request.getSession(); 
			session.setAttribute("loginUser", updateMem);
			request.getSession().setAttribute("alertMsg", "비밀번호 변경 성공");
			request.getRequestDispatcher("views/member/myPageProfileUpdateForm.jsp").forward(request, response);
		} 
		else { 
			request.getSession().setAttribute("alertMsg", "비밀번호 변경 실패");
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
