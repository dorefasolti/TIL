package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 *<HttpServletRequest, HttpServletResponse>
		 * - request : 서버로 요청할 때의 정보들이 담겨있음(요청시 전달값, 요청전송방식 등등..)
		 * - response : 요청에 대해 응답하고자 할 대 사용하는 객체 
		 * 
		 * */
		
		//1) Post 방식으로 요청했을 경우 "반드시" 인코딩 설정(get일때는 생략 가능)
		request.setCharacterEncoding("UTF-8");
		
		//2) 요청 시 전달값을 꺼내서 변수에 기록 => request의 parameter 영역
//		request.getParameter("키값") : String
//		request.getParameterValues("키값") : String[] => check박스일때 쓰자
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		System.out.println(userId);
		System.out.println(userPwd);
		
		
		
		//3) 해당 요청을 처리하는 서비스 클래스의 메소드를 호출
		Member loginUser = new MemberService().loginMember(userId, userPwd);
//		SELECT * 
//	    FROM MEMBER
//		WHERE USER_ID = '사용자가 입력한 아이디'
//	    AND USER_PWD = '사용자가 입력한 비밀번호'
//	    AND STATUS = 'Y';
//		일치하는 회원이 있다면 일치하는 회원의 모든 컬럼값들이 담겨저 온 Member객체
//		일치하는 회원이 없다면 null이 담긴 Member 객체
		
		System.out.println(loginUser);
	
//		4) 처리된 결과를 가지고 사용자가 보게 될 응답화면을 지정
//		스텝1. request객체에 응답화면에 보여질 값 담기 => request의 attribute 영역에 
//		스텝2. RequestDispatcher 객체 생성 => 응답할 뷰 화면을 지정
//		스텝3. case1. RequestDispatcher 객체 생성(응답할 뷰 지정) -> forward
//				case2. response.sendRedirect(응답할 화면 또는 url지정);
		
		
		/*
		 * 응답페이지에 전달할 값이 있을 경우 값을 어딘가에 담아야함 => 어딘가에 attribute 영역에 담아서 
		 * (담아줄 수 있는 객체가 4종류 => Servlet Scope 내장 객체) 
		 * 
		 * 크다
		 * 
		 * 1) application : 웹어플리케이션 전역 언제나 꺼내 쓸 수 있음
		 * 
		 * 2) session : 모든 jsp와 servlet에서 꺼내 쓸 수 있음
		 * 				세션이 끊기는 경우까지만 쓸 수 있음 : 브라우저가 종료될 때, 서버가 멈춤
		 * 				내가 직접적으로 session 객체에 담은 값을 지웠을 때
		 * 
		 * 
		 * 3) request : 해당 request를 포워딩한 응답 jsp 페이지에서만 쓸 수 있다.
		 * 				요청 페이지에서부터 응답페이지까지에서만 쓸 수 있다(일회성 느낌)
		 * 
		 * 
		 * 
		 * 4) page : 담은 값을 해당 jsp페이지에서만 쓸 수 있다(화면이 넘어가면 담은 값이 소멸)
		 * 
		 * 
		 * 작다
		 * 
		 * => session, request가 가장 많이 쓰인다.
		 * => 공통적으로 데이터를 담고자 한다면 :  XXX.setAttribute(키, 밸류);
		 * 			데이터를 뽑고자 한다면 : XXX.getAttribute(키);
		 * 			데이터를 지우고자 한다면 : XXX.removeAttribute(키);
		 * 
		 * 예시)
		 * 로그인시 : session.setAttribute("userInfo", loginUser);
		 * 로그아웃시 : session.removeAttribute("userInfo"); 또는 유효화 시키는 메소드
		 * 
		 * 
		 * 
		 * */
	
		if(loginUser == null) { //로그인 실패 =>에러페이지 응답
//			에러메시지 넘기기
//			스텝1. request의 Attribute 영역에 메시지 담기
			request.setAttribute("errorMsg", "로그인에 실패했습니다");
			
//			스텝2. RequestDispatcher 객체 생성
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			
//			스텝3. forward
			view.forward(request, response);
		} else {
//			사용자의 정보 넘기기
//			스텝1. session의 attribute영역에 사용자 정보 담기
			
//			로그인 한 회원의 정보를 로그아웃 하기 전까지 계속 가져다가 쓸 것이기 때문에 session에 담기
			
//			Servlet에서 JSP내장객체인 session에 접근하려면(session객체를 사용하려면)
//			우선적으로 session객체를 얻어와야함
//			=> session객체의 type : HttpSession
//			=> session 객체 생성 방법 : request.getSession
			HttpSession session = request.getSession();
			
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("alertMsg", "성공적으로 로그인하셨습니다.");
			
			
			/*
//			포워딩 응답방식으로 넘길 경우
//			스텝2. RequestDispatcher 객체 생성
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			
//			스텝3. forward 메소드 호출
			view.forward(request, response);
//			=>포워딩 방식의 가장 큰 특징 : url에는 여전히 현재 이 서블릿 매핑값이 남아있음
//						localhost:8000/jsp/login.me
//						응답페이지 index.jsp이기 때문에 localhost:8001/jsp/
			 * 
			 */
			
//			url 재요청방식(sendRedirect방식) : url을 재요청함으로써 응답페이지가 보여지게끔
//			response 객체를 이용하는 방법
//			response.sendRedirect(재요청할경로);
//			=> url재요청 방식의 가장 큰 특징 : 내가 요청한 경로의 url에 보임
			response.sendRedirect("/jsp");
//			localhost:8001/jsp로 url재요청이 갈 것
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
