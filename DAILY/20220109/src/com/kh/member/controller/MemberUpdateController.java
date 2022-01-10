package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

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
		// 1)  post방식 => 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		// 2) request로부터 요청 시 전달한 값 뽑기(parameter영역 안에 잇음)
//		회원한테 입력ㅂ다았던 
//		<td><input type="text" value=<%= userName %> name="userName" maxlength="6" required></td>
//		여기서 name값이 키값이 된다
//		키값을 ()에 넣어주면 밸류가 따라온다~!
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String[] interestArr = request.getParameterValues("interest");
		//배열로 받아와야하는데
		//이걸 스트링으로 바꿔줄래
		//그리고 null이 올 수도 있잖아
		String interest = "";
		if(interestArr != null) { //널이 아닐 경우 , 를 이용해 합쳐줘라~
			interest = String.join(",", interestArr);
		}
	
		// 3) VO 객체에 담기
		Member m = new Member(userId, userName, phone, email, address, interest);
		
//		System.out.println(m);
	
		// 4) Service단으로 토스~
		Member updateMem = new MemberService().updateMember(m);
		if(updateMem == null) { //실패 -> 에러페이지가 뜬다 ==updateMem 이 null
			request.setAttribute("errorMsg", "회원정보 수정에 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
//			포워딩하는방법까먹지말기
		} else { //성공 -> 마이페이지 화면을 그대로 보여주세요(단, 변경된 정보를 뿌려서)
			HttpSession session = request.getSession();
			
			session.setAttribute("loginUser", updateMem); //키값이 중복? : 덮어쓰기
			session.setAttribute("alertMsg", "성공적으로 회원정보 수정");
			
			//마이페이지에서 정보 변경 후 sendRedirect로 넘겨주기
			// localhost:8001/jsp/myPage.me로 다시 전송
			response.sendRedirect(request.getContextPath() + "/myPage.me");
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
