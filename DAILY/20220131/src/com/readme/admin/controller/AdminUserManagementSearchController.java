package com.readme.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readme.admin.model.service.AdminService;
import com.readme.admin.model.vo.PageInfo;
import com.readme.member.model.vo.Member;

/**
 * Servlet implementation class AdminUserManagementSearchController
 */
@WebServlet("/userSearch.ad")
public class AdminUserManagementSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserManagementSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String[] searchUserCategory = request.getParameterValues("searchUserCategory");
		String searchUserKeyword = request.getParameter("searchUserKeyword");

		
		
//		입력받은 카테고리 탈퇴상태이고, 입력 내용이 소문자 y, n일 경우 대문자로 변경시켜주
		if(searchUserCategory[0].equals("searchUserStatus")) {
			if(searchUserKeyword.equals("y")) {
				searchUserKeyword = "Y";
			} else if(searchUserKeyword.equals("n")) {
				searchUserKeyword = "N";
			}
			
		}


		
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
	
		listCount = new AdminService().selectUserListCount(searchUserCategory, searchUserKeyword);

		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));

		
		pageLimit = 10;
		
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Member> list = new AdminService().selectUserList(searchUserCategory, searchUserKeyword, pi);
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		
		request.getRequestDispatcher("views/admin/adminUserManagementView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
