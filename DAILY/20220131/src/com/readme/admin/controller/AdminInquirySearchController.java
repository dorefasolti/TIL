package com.readme.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readme.admin.model.service.AdminService;
import com.readme.admin.model.vo.Answer;
import com.readme.admin.model.vo.PageInfo;

/**
 * Servlet implementation class AdminInquirySearchController
 */
@WebServlet("/inquirySearch.ad")
public class AdminInquirySearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInquirySearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String[] searchAnswerCategory = request.getParameterValues("searchAnswerCategory");
		String searchAnswerKeyword = request.getParameter("searchAnswerKeyword");
		
		
//		검색 카테고리가 처리상태일 때 소문자y, n을 입력했을 경우 대문자로 변경해주기
		if(searchAnswerCategory[0].equals("searchQStatus")) {
			if(searchAnswerKeyword.equals("y")) {
				searchAnswerKeyword = "Y";
			} else if(searchAnswerKeyword.equals("n")) {
				searchAnswerKeyword = "N";
			}
			
		}
		
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		listCount = new AdminService().selectAnswerListCount(searchAnswerCategory, searchAnswerKeyword);


		
		pageLimit = 10;
		
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		

		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);

		
		ArrayList<Answer> list = new AdminService().searchAnswerKeyword(searchAnswerCategory, searchAnswerKeyword, pi);
		
		

		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.getRequestDispatcher("views/admin/adminInquiryAnswerView.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
