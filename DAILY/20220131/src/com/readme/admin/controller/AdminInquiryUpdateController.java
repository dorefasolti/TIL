package com.readme.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readme.admin.model.service.AdminService;

/**
 * Servlet implementation class AdminInquiryUpdateController
 */
@WebServlet("/inquiryAnswer.ad")
public class AdminInquiryUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInquiryUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int qno = Integer.parseInt(request.getParameter("qno"));
		String qStat = request.getParameter("qstat");
		String qAnswer = request.getParameter("qanswer");

		
		if(qAnswer == null || qAnswer.equals("null")) { 
			qStat = "N"; 
		} else {
			qStat = "Y";
		}
	
		
		int result = new AdminService().updateAnswer(qno, qStat, qAnswer);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "성공적으로 답변이 등록되었습니다");
			response.sendRedirect(request.getContextPath() + "/inquiryList.ad?currentPage=1");
		} else {
			request.getSession().setAttribute("alertMsg", "실패");
			response.sendRedirect(request.getContextPath() + "/inquiryList.ad");
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
