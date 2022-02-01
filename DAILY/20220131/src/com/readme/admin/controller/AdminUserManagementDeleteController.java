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
 * Servlet implementation class AdminUserManagementDeleteController
 */
@WebServlet("/userDelete.ad")
public class AdminUserManagementDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserManagementDeleteController() {
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
		  

		  int result = new AdminService().deleteUser(checkNumbers);
	
//		한명만 삭제하기는 이렇게 할 수 있다
//		int userNo = 0;
//		for(int i = 0; i < checkArr.length; i++) {
//			userNo = Integer.parseInt(checkArr[i]);
//		}
//		
//		System.out.println(userNo);
//		
//		int result = new AdminService().deleteUser(userNo);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "회원 삭제 성공");
			response.sendRedirect(request.getContextPath() + "/userList.ad?currentPage=1");
		} else {
			request.getSession().setAttribute("alertMsg", "작성 게시글이 있는 회원은 삭제할 수 없습니다.");
			response.sendRedirect(request.getContextPath() + "/userList.ad?currentPage=1");
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
