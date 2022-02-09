package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {

	/*
	 * 기존 JDBC
	 * 
	 * public static Connection getConnection(){
	 *	//driver.properties 파일 읽어들여서
	 *  // 해당 DB와 접속된 Connection 객체를 생성 리턴
	 * }
	 * 
	 * public static void close(JDBC용 객체){
	 * 	//전달받은 JDBC용 객체를 반납시키는 구문
	 * }
	 * 
	 * public static void commit/rollback(Connection 객체){
	 * 	//트랜잭션처리
	 * }
	 * 
	 * */
	
	// 마이바티스
	public static SqlSession getSqlSession() {
		//myBatis-config.xml 파일을 읽어들여서
		//해당 DB와 접속된 SqlSession 객체를 생성해서 반환
		SqlSession sqlSession = null;
		
		//sqlSession 객체를 생성하기 위해서는 sqlSessionFactory 객체가 필요
		//sqlSessionFactory 객체를 생성하기 위해서는 SqlSessionFactoryBuilder 객체가 필요
		
		String resource = "/mybatis-config.xml";
		// /는 모든 소스폴더의 최상위 폴더들을 의미(resources, src)
		
		try {
			InputStream stream= Resources.getResourceAsStream(resource);// 자원으로부터 통로를 얻어내겠다
			//1단계) new SqlSessionFactoryBuilder : SqlSessionFactoryBuilder객체 생성
			//2단계) .build(stream) : 통로로부터 mybatis-config.xml파일을 읽어들여서 sqlSessionFactory 객체를 만들겠다
			//3단계) .openSession(false) : SqlSession 객체 생성 및 앞으로 트랜잭션 처리 시 자동으로 commit을 할건지 안할건지 여부를 지정
			// => false == 자동 commit을 하지 않겠다. == 개발자가 직접 commit을 하겠다.
			// => openSession() 기본값은 false긴함
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return sqlSession;
	}
	
}
