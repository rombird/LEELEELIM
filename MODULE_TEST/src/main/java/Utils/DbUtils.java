package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Dtos.MemberDto;


public class DbUtils {
	// 속성(DB 연결 관련된 멤버)
	// DB CONN DATA
	private static String id = "root";
	private static String pw = "1234";
	private static String url = "jdbc:mysql://localhost:3306/opendatadb";

	// JDBC 참조변수
	private static Connection conn = null; // DBMS의 특정 DB와 연결되는 객체
	private static PreparedStatement pstmt = null; // SQL Query 전송용 객체
	private static ResultSet rs = null; // Select 결과물 담을 객체
	
	// 기능
	public static void conn() throws Exception
	{
		// 드라이브 클래스 메모리 공간 적재
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("---Driver Loading SUCCESS---"); // 클래스 메모리 공간에 잘 적재되었는지 console창에서 확인 가능
		
		//Connection conn  멤버에 Connection 객체 연결
		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("---DB CONNECTED---"); // 잘 연결되었는지 console 창에서 확인가능
	}
	
	public static void disConn() throws Exception {
		// rs / pstmt / conn close 처리
		// select 결과물 담을 객체 rs 가 null이 아니라면 -> close -> pstmt, conn도 마찬가지
		if(rs!=null) 
			rs.close(); 
		if(pstmt!=null)
			pstmt.close();
		if(conn!=null)
			conn.close(); 
	}
	
	public static int insertMember(MemberDto memberDto) throws Exception 
	{
		//tbl_member에 dto 값 저장 후 int 반환
		pstmt = conn.prepareStatement("insert into tbl_member values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		pstmt.setString(1, memberDto.getUserid()); // values 1에 들어갈 Userid 데이터값
		pstmt.setString(2, memberDto.getPassword()); 
		pstmt.setString(3, memberDto.getRePassword());
		pstmt.setString(4, memberDto.getUsername());
		pstmt.setString(5, memberDto.getZipcode());
		pstmt.setString(6, memberDto.getAddr1());
		pstmt.setString(7, memberDto.getAddr2());
		pstmt.setString(8, memberDto.getPhone1());
		pstmt.setString(9, memberDto.getPhone2());
		pstmt.setString(10, memberDto.getPhone3());
		pstmt.setString(11, memberDto.getTel1());
		pstmt.setString(12, memberDto.getTel2());
		pstmt.setString(13, memberDto.getTel3());
		pstmt.setString(14, memberDto.getEmail());
		pstmt.setString(15, memberDto.getYear());
		pstmt.setString(16, memberDto.getMonth());
		pstmt.setString(17, memberDto.getDay());
		
		int result = pstmt.executeUpdate(); // result 에 insert한 데이터값 담음 -> 값(행단위, 멤버당)에 변동이 있으면 1이 올라감
		return result; // result 반환
	}
	
	public static MemberDto selectMember(String userid) throws Exception{	
		//tbl_member에 userid와 일치하는 데이터 받아와 MemberDto로 반환 
		pstmt = conn.prepareStatement("select * from tbl_member where userid=?"); // where userid=? 를 해줘야 userid 값을 아래 코드에서 읽음
		pstmt.setString(1, userid); // tbl_member에서 userid 가져오기(userid는 PK로 동일한 값 없기 때문)
		
		rs = pstmt.executeQuery(); // pstmt에서 select한 결과를 rs로 담겠다.
		MemberDto dto = null; 
		if(rs!=null) { // rs에 값이 있다면
			if(rs.next()) { // 열 다음행부터 읽어들이겠다.
				dto = new MemberDto(); // 
				dto.setUserid(rs.getString("userid"));
				dto.setPassword(rs.getString("password"));
				dto.setRePassword(rs.getString("rePassword"));
				dto.setUsername(rs.getString("username"));
				dto.setZipcode(rs.getString("zipcode"));
				dto.setAddr1(rs.getString("addr1"));
				dto.setAddr2(rs.getString("addr2"));
				dto.setPhone1(rs.getString("phone1"));
				dto.setPhone2(rs.getString("phone2"));
				dto.setPhone3(rs.getString("phone3"));
				dto.setTel1(rs.getString("tel1"));
				dto.setTel2(rs.getString("tel2"));
				dto.setTel3(rs.getString("tel3"));
				dto.setEmail(rs.getString("email"));
				dto.setYear(rs.getString("year"));
				dto.setMonth(rs.getString("month"));
				dto.setDay(rs.getString("day")); 
			}
		}
		return dto; // tbl_member에 userid와 일치하는 데이터 받아와 MemberDto로 반환
	}
	
	public static void TxStart() throws Exception{
		if(conn!=null) // 만약 연결되어있다면 
			conn.setAutoCommit(false); 
	}
	public static void TxEnd() throws Exception {
		if(conn!=null) // 만약 연결되어있다면
			conn.commit(); // 이 기능을 사용
	}
	public static void RollBack() throws Exception {
		if(conn!=null) // 만약 연결되어있다면
			conn.rollback(); // 이 기능을 사용
	}
	
}