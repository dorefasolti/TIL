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
 * Servlet implementation class MemberMyPageController
 */
@WebServlet("/myPage.me")
public class MemberMyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberMyPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("loginUser");
		int userNo = m.getUserNo();
//		로그인된 유저 정보에서 userNo를 가져옴

	
		int wishCount = new MemberService().selectWishCount(userNo);
		
		request.setAttribute("wishCount", wishCount);
//		userNo를 이용해 wishCount를 가져옴(유저아이디가 ?고 status가 y인 컬럼의 갯수를 조회)
		request.getRequestDispatcher("views/member/myPageMain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
