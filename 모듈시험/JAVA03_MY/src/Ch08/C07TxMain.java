package Ch08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C07TxMain { //트랜젝션 : 명령어를 묶어서 쓰는 하나의 단위, db의 상태를 변화시키기 위해서 수행한느 작업의 단위
//	작업 단위를 확장시켜서 일부나 전체에 문제가 생기면 그전으로 돌아가 없던 상태로 다시 돌아가도록 함
	// 쿼리문이 여러개 동작해야할 때 사용됨

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
		
		
		//TX START
		conn.setAutoCommit(false); //setAutoCommit을 끄면서 임시저장(유예)가 됨
		

		//INSERT
		//트랜잭션이 독립적으로 구현되어있으면 3번에 값이 중복되어있더라도 그 전에 작업했던 것들은 적용이 됨
		//트랜잭션을 하나의 단위로 묶으면 중간에 오류가 생길 시 그 전에 작업됐던 것들도 적용되지 않고 처음 상태로 돌아감
		pstmt = conn.prepareStatement("insert into tbl_a values(1, 'a') ");
		pstmt.executeUpdate();
		//쿼리를 전달하면 자동으로 commit이 됨(==AutoCommit)
		pstmt = conn.prepareStatement("insert into tbl_a values(2, 'b') ");
		pstmt.executeUpdate();
		pstmt = conn.prepareStatement("insert into tbl_a values(1, 'c') ");
		pstmt.executeUpdate();
		pstmt = conn.prepareStatement("insert into tbl_a values(4, 'd') ");
		pstmt.executeUpdate();
		
		//TX END
		conn.commit(); //커밋 직접 해주기
		
		//TX START & TX END => 사이의 코드들은 하나의 트랜젝션 단위로 묶이게 됨
		

		

		
		
		}catch(ClassNotFoundException e1) {
			System.out.println("클래스 부재 예외발생!");
		}catch(SQLException e2) {
//			System.out.println("SQL 예외발생!");
//			e2.printStackTrace();
//			conn.rollback(); //트랜잭션의 실행결과를 전부 무효화 or 특정시점 point로 복원도 가능
							 //rollback하다가 예외사항이 생길 수도 있으니 예외처리 해줘야함!
			try {System.out.println("ROLLBACK 처리!");conn.rollback();} catch (SQLException e) {e.printStackTrace();} 
		}
//		catch(SQLIntegrityConstraintViolationException e3) {
			//제약조건에 위배하는 예외가 발생했을 때 
			//but 위의 SQLException이 상위-상위 클래스여서 중복으로 넣어줄 필요 x
//		}
		finally {
			
			//자원제거! - Surround with Try/Catch 클릭
			try {conn.close();} catch (SQLException e) {e.printStackTrace();} 
			
		}
	}
}