package Ch08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C02Insert {

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
					 	//DBMS랑 달라서 배포 전 확인 필요
		System.out.println("Driver Loading Success...");
		conn = DriverManager.getConnection(url,id,pw); //만들어놓은 자우너
				//sample DB와 연결하는 작업 : DriverManager
							//연결 정보들이 Connection 객체에 저장됨 : getConnection();
		System.out.println("DB CONNECTED...");
		
		
		
		//sql query 객체 생성
		//Query문 준비
//		pstmt = conn.prepareStatement("insert into tbl_a values(1, 'no') ");
		pstmt = conn.prepareStatement("insert into tbl_a values(?, ?) "); 	//? : 변수
//		pstmt.setInt(1, 2); //첫 번째 물음표에, 들어갈 값
//		pstmt.setString(2, "홍길동"); //두 번째 물음표에, 들어갈 문자열
		//외부인자 받아서 실행
		
		//외부로부터 인자값을 받아서 db로 넣어줌
		pstmt.setInt(1, Integer.parseInt(args[0]));
						//0번째 args는 숫자형이라 가정
		pstmt.setString(2,  args[1]);
		
		//sql를 dbms로 전달
		//전송(전달)
		int result = pstmt.executeUpdate();	//UPDATE(INSERT,UPDATE,DELETE)전달 가능/반환됨 
		//결과값으로 java에서 처리
		if(result>0){
			System.out.println("INSERT 성공");
		}
		else {
			System.out.println("INSERT 실패");
		}
		
		
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
