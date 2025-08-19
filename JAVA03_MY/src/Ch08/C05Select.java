package Ch08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C05Select { //db 조회결과물 가져오기

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
//		pstmt = conn.prepareStatement("SELECT * FROM tbl_a ");
		rs = pstmt.executeQuery();
		//result set(rs)은 표 형태의 오브젝트를 그대로 가져옴
		//rs는 0번째 column 가리킴
		
		if(rs!=null) {
			while(rs.next()) { //rs.next() : rs가 가리키고 있는 커서의 위치를 다음으로 내림(행이 있으면 True, 없으면 False)
				  //rs.next() : 한 행씩 건너뛰면서 컬럼값을 가져옴
				System.out.print(rs.getInt("no")+".");
								//rs에서 가리키고 있는 no라고하는 컬럼의 값을 가지고 옴.
								//no의 자료형이 Int이기에 get Int라고 한 것
				System.out.println(rs.getString("name"));
									//현재 커서에 있는 위치의 name이라고 하는 행을 가녀옴
			}
		}
		
		pstmt = conn.prepareStatement("SELECT * FROM tbl_a");
//		pstmt = conn.prepareStatement("SELECT * FROM opendatadb.tbl_a;");
													//db명 필요x,     ;필요x
		
		}catch(ClassNotFoundException e1) {
			System.out.println("클래스 부재 예외발생!");
		}catch(SQLException e2) {
			System.out.println("SQL 예외발생!");
		}finally {
			
			//자원제거(역순으로 : 후에 나온 걸 선 제거)! - Surround with Try/Catch 클릭
			try {rs.close();} catch (SQLException e) {e.printStackTrace();} 
			try {pstmt.close();} catch (SQLException e) {e.printStackTrace();} 
			try {conn.close();} catch (SQLException e) {e.printStackTrace();} 
			
		}
	}

}
