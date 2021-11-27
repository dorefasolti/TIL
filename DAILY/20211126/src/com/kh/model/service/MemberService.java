package com.kh.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;


//아직 dao에 역할이 많이 남아있어서, 순수하게 sql문만 남기고, 다시 결과를 받아오도록 하고싶다
//엔스큐엘날리려면 커넥션객체가필요한데? 그걸 여기서 만들자
//트랜잭션? 여기서
//그리고 여기서 다시 컨트롤러에 돌려주자
//컨트롤러 - 서비스 - 디에이오 이렇게 연결되었다
//
/*
 * Service : 기존의 DAO의 역할을 분담
 * 			컨트롤러에서 서비스 호출(Connection 객체 생성) 후 서비스를 거쳐서 
 * 			DAO로 넘어갈 것
 * 			DAO 호출 시 커낵션 객체와 기존에 넘기고자 했던 매개변수를 같이 넘겨줌
 * 			DAO 처리가 끝나면 서비스단에서 결과에 따른 트랜잭션 처리도 같이 해줌
 * 			=> 서비스 단을 추가함으로써 DAO에는 순수하게 SQL문을 처리하는 부분만 남음
 * 
 * */


public class MemberService {
	public int insertMember(Member m) { //반환형보이드맞나??확인강사코드
		
		//connection 객체를 여기서 만들것이다!
							//스태틱은 이렇게 바로 사용할수있다..
		
		//Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
									//여기서 만든 conn도 념거주고, 매개변수로 입력받은 m도 넘겨주자
		//DAO호출 시 Connection 객체와 기존에 넘기고자 했던 매개변수를 같이 넘김
		int result = new MemberDao().insertMember(conn, m); //결과값 result(정수)를 들고옴
		//정수에 담아주자
		
		//트랜잭션 처리를 여기서 해주자!
		//결과에 따른 트랜잭션 처리
		if(result > 0) {
			JDBCTemplate.commit(conn);
			//템플릿에 conn을 넘겨주며 미리 작성해둔 것을 가져오면서 
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//Connection 객체 반납
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	
	
	public ArrayList<Member> selectAll() {
		
		//1)Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection(); //겟커넥션 -> 커넥션을 만들어서 돌려줌 => 커넥션으로 담아야한다
									//스태틱 메소드기떄문에 이렇게 호출할 수 있다

		
		//2)DAO 호출해서 리턴받기
		//만약 Controller에서 넘겨준 값이 있다면 conn 객체와 함께 넘겨줘야함
		
		
//		커넥션 객체와 컨트롤러에서 전달받은 데이터 디에이오에 전달하기
//		new MemberDao().selectAll(conn); //
		//conn을 주고 조회결과가 담긴 list를 받아왔다..
//		얘도 불러준 사람에게 다시 돌아가야한다.. 누구?.. 컨트롤러...
		//그냥 돌아가도 되나..? 아니지.. 결과가 나온걸들고가야지..
		//결과가 어떻게 나왔지..? 리스트로나왔지..
		//리스트로 담아서 돌아가야한다
		ArrayList<Member> list =  new MemberDao().selectAll(conn);
		
		//3) Connection 객체 Close 여기서 닫아줘야한다!!!!!! 
		JDBCTemplate.close(conn);
		
		//4) 결과값 리턴
		return list;
	}



	public Member selectByUserId(String userId) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		
		Member m = new MemberDao().selectByUserId(conn, userId);
		//DAO에서 m에 정보를 담아서 돌아왔으니까..
		//m을 만들어서 돌려줘야..
		
		JDBCTemplate.close(conn);
		return m;
	}



	public ArrayList<Member> selectByUserName(String keyword) {
		ArrayList<Member> list = new ArrayList<>();
		
		Connection conn = JDBCTemplate.getConnection();
		list = new MemberDao().selectByUserName(conn, keyword);
		
		JDBCTemplate.close(conn);
		
		return list;
	}



	public int updateMember(Member m) {
		int result = 0;
		
		Connection conn = JDBCTemplate.getConnection();
		
		result = new MemberDao().updateMember(conn, m);
		
		JDBCTemplate.close(conn);

		
		return result;
	}



	public int deleteMember(String userId) {
		//딜리트니까 결과가 숫자로나올것이다..
		int result = 0;
		Connection conn = JDBCTemplate.getConnection();
		result = new MemberDao().deleteMember(conn, userId);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		//커밋롤백빼먹지말자고!!!!!!!!!!!!!!!!!!!!!!
		return result;
	}
}
