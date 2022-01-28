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

		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String birth = request.getParameter("birth");
		String eventAssent = request.getParameter("eventAssent");
		String infoAssent= request.getParameter("infoAssent");
		
	
		Member m = new Member(userId, userName, email, gender, birth, eventAssent, infoAssent);
				
		

		Member updateMem = new MemberService().updateMember(m);


		
		if(updateMem != null) {
			HttpSession session = request.getSession(); 
			session.setAttribute("loginUser", updateMem);
			request.getSession().setAttribute("alertMsg", "사용자 정보 변경에 성공하였습니다.");
			request.getRequestDispatcher("views/member/myPageProfileUpdateForm.jsp").forward(request, response);
		} 
		else { 
			request.getSession().setAttribute("alertMsg", "사용자 정보 변경에 실패하였습니다.");
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
