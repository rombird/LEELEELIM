package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Dtos.MemberDto;


public class DbUtils {
	//속성(DB 연결관련된 멤버)
	//DB CONN DATA
	private static String id = "root";
	private static String pw = "1234";
	private static String url = "jdbc:mysql://localhost:3306/opendatadb";

	//JDBC참조변수
	private static Connection conn = null; // DBMS 의 특정 DB와 연결되는 객체
	private static PreparedStatement pstmt = null; // SQL Query 전송용 객체
	private static ResultSet rs = null; // Select 결과물 담을 객체
	
	//기능
	public static void conn() throws Exception
	{
		//드라이브 클래스 메모리 공간 적재
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loading Success...");
		
		//Connection conn 멤버에 Connection 객체 연결
		conn = DriverManager.getConnection(url,id,pw);	
		System.out.println("DB CONNECTED...");
		
		
	}
	public static void disConn() throws Exception {
		//rs / pstmt / conn close 처리
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
		if(conn!=null)
			conn.close();
		
		
	}	
	public static int insertMember(MemberDto memberDto) throws Exception 
	{
		//tbl_member 에 dto 값 저장 후 int 반환
		pstmt = conn.prepareStatement("insert into tbl_member values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		pstmt.setString(1, memberDto.getUserid());
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
		int result = pstmt.executeUpdate();			// 값(행 단위, 멤버당)에 변동이 있으면 1이 올라감
		
		return result;
	}
	public static MemberDto selectMember(String userid) throws Exception{	
		//tbl_member 에 userid 와 일치하는 데이터 받아와 MemberDto로 반환  
		
		pstmt = conn.prepareStatement("select * from tbl_member where userid = ?");
		pstmt.setString(1, userid);
		rs= pstmt.executeQuery();
		MemberDto dto = null;
		
		if(rs != null && rs.next()) {		// 변경된 값이 없거나 현재 rs가 가르키는 행의 위치가 0번째(비어있는 행)라면
			dto = new MemberDto();
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
		
		return dto;
	}
	
	public static void TxStart() throws Exception{
		if(conn!=null)	// DB와 연결되어있는 상태
			conn.setAutoCommit(false);	// 자동으로 업데이트 하지말아줘요 
	}
	public static void TxEnd() throws Exception {
		if(conn!=null)		// DB와 연결되어있는 상태
			conn.commit();		// 이제 할거 다 했으니까 업데이트 해줘
	}
	public static void RollBack() throws Exception {
		if(conn!=null)	// DB와 연결되어 있는 상태
			conn.rollback();	// 중간에 문제 있으면 처음으로 돌아가줘요
	}
	
}