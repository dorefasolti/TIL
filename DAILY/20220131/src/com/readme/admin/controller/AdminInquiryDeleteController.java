package com.readme.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.readme.admin.model.service.AdminService;

/**
 * Servlet implementation class adminInquiryDeleteController
 */
@WebServlet("/inquiryDelete.ad")
public class AdminInquiryDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInquiryDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String[] checkArr = request.getParameterValues("checkList");
		
		
		  ArrayList<Integer> checkNumbers = new ArrayList<Integer>();
		  
		  for(int i = 0; i < checkArr.length; i++) { 
			  Integer.parseInt(checkArr[i]);
			  checkNumbers.add(Integer.parseInt(checkArr[i])); 
		  }
		  

		  int result = new AdminService().deleteInquiryAnswer(checkNumbers);
	
			if(result > 0) {
				request.getSession().setAttribute("alertMsg", "1:1문의 삭제 성공");
				response.sendRedirect(request.getContextPath() + "/inquiryList.ad?currentPage=1");
			} else {
				request.getSession().setAttribute("alertMsg", "1:1문의 삭제 실패");
				response.sendRedirect(request.getContextPath() + "/inquiryList.ad?currentPage=1");
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
