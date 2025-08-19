package Ch08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C01DbConn {

	public static void main(String[] args) {
		//DB CONN DATA
		String id = "root";
		String pw = "1234";
								  //DBMS위치 : Java와 동일한 위치에서 동작하고 있으니 = local host
		String url = "jdbc:mysql://localhost:3306/opendatadb";
						   //DBMS종류				//접속하고자 하는 db명
		
		//JDBC 참조변수
		Connection conn = null;			//DBMS의 특정 DB와 연결되는 객체
		PreparedStatement pstmt = null; //SQL Query 전송용 객체
		ResultSet rs = null;			//Select 결과물 담을 객체
		
		//연결작업
		try {
		Class.forName("com.mysql.cj.jdbc.Driver"); //JDBC 드라이버 로딩
					   //mysql - jdbc- Driver.class를 드라이버에 적재
					 	//DBMS랑 달라서 배포 전 확인 필요
		System.out.println("Driver Loading Success...");
		conn = DriverManager.getConnection(url,id,pw); //만들어놓은 자우너
				//sample DB와 연결하는 작업 : DriverManager
							//연결 정보들이 Connection 객체에 저장됨 : getConnection();
				
		System.out.println("DB CONNECTED...");
		
		}catch(ClassNotFoundException e1) {
			System.out.println("클래스 부재 예외발생!");
		}catch(SQLException e2) {
			System.out.println("SQL 예외발생!");
		}finally {
			
			//자원제거! - Surround with Try/Catch 클릭
			try {conn.close();} catch (SQLException e) {e.printStackTrace();} 
			
		}
	}

}
