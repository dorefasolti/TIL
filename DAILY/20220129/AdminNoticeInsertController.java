package com.readme.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readme.admin.model.service.AdminService;

/**
 * Servlet implementation class NoticeInsertController
 */
@WebServlet("/noticeInsert.ad")
public class AdminNoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int nWriter = Integer.parseInt(request.getParameter("nWriter"));
		String nTitle = request.getParameter("nTitle");
		String nContent = request.getParameter("nContent");
		
		System.out.println(nWriter + nTitle + nContent);
		
		int result = new AdminService().insertNotice(nWriter, nTitle, nContent);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "공지사항이 등록되었습니다.");
			response.sendRedirect(request.getContextPath() + "/noticeList.ad?currentPage=1");
		
		} else {
			request.getSession().setAttribute("alertMsg", "공지등록실패.");
			response.sendRedirect(request.getContextPath() + "/noticeList.ad?currentPage=1");
		
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
