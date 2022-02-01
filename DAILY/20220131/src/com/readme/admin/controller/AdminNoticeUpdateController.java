package com.readme.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readme.admin.model.service.AdminService;

/**
 * Servlet implementation class AdminNoticeUpdateController
 */
@WebServlet("/noticeUpdate.ad")
public class AdminNoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	
		
		int nno = Integer.parseInt(request.getParameter("nno"));
		String nTitle = request.getParameter("nTitle");
		String nContent = request.getParameter("nContent");


		int result = new AdminService().updateNotice(nno, nTitle, nContent);
		
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "공지사항이 성공적으로 수정되었습니다.");
			response.sendRedirect(request.getContextPath() + "/noticeList.ad?currentPage=1");
		} else {
			request.getSession().setAttribute("alertMsg", "공지사항 수정 실패");
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
