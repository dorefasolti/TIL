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
		
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		System.out.println("컨트롤러 커런트페이지"+currentPage);
		System.out.println("컨트롤러 카테고리가들어오나?/"+searchAnswerCategory);
		System.out.println("컨트롤러 키워드가 들어오나?"+searchAnswerKeyword);
		listCount = new AdminService().selectAnswerListCount(searchAnswerCategory, searchAnswerKeyword);


		
		pageLimit = 10;
		
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		System.out.println("컨트롤러 맥스페이지가 잘 나오나?:"+maxPage);
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);

		
		ArrayList<Answer> list = new AdminService().searchAnswerKeyword(searchAnswerCategory, searchAnswerKeyword, pi);
		
		

		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.getRequestDispatcher("views/admin/admintest.jsp").forward(request, response);
		
//		response.sendRedirect(request.getContextPath() + "/inquirySearch.ad");
//		response.sendRedirect(request.getContextPath() + "/inquirySearch.ad?currentPage="+currentPage);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
