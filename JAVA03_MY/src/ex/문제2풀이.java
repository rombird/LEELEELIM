package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class 문제2풀이 {
	// DB CONN DATA
	private static String id = "root";
	private static String pw = "1234";
	private static String url = "jdbc:mysql://localhost:3306/opendatadb";

	// JDBC참조변수
	private static Connection conn = null; // DBMS 의 특정 DB와 연결되는 객체
	private static PreparedStatement pstmt = null; // SQL Query 전송용 객체
	private static ResultSet rs = null; // Select 결과물 담을 객체

	public static void conn() throws Exception { // 예외가 발생했을 때 실행했던 위치(main내의 conn();)로 던짐
												 // 업캐스팅 형태로 모든 예외 처리
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		System.out.println("Driver Loading Success...");
		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("DB CONNECTED...");
	}

	

	public static List<BookDto> selectAll() throws SQLException {
		pstmt = conn.prepareStatement("SELECT * FROM tbl_book");
		
		rs = pstmt.executeQuery();
		//result set(rs)은 표 형태의 오브젝트를 그대로 가져옴
		//rs는 0번째 column 가리킴
		
		List<BookDto> list = new ArrayList(); //각 행이 List형태로 담김
		BookDto dto = null; //임시로 데이터를 계속 연결할 용도 
		if(rs!=null) {
			while(rs.next()) { //rs.next() : rs가 가리키고 있는 커서의 위치를 다음으로 내림(행이 있으면 True, 없으면 False)
							   //rs.next() : 한 행씩 건너뛰면서 컬럼값을 가져옴
				dto = new BookDto();
				//BookDto단위에 담기
				dto.setBookCode(rs.getLong("bookCode"));
				dto.setBookname(rs.getString("bookName"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setIsbn("isbn");
				//리스트 형태로 반환
				list.add(dto);
				
//				System.out.print(rs.getInt("bookCode")+" ");
//				System.out.print(rs.getString("bookName") + " ");
//				System.out.print(rs.getString("publisher")+" ");
//
//				System.out.println(rs.getString("isbn"));

			}
		}
		return list;
	}

	public static BookDto select(Long bookCode) throws SQLException {
		pstmt = conn.prepareStatement("SELECT * FROM tbl_book where bookCode=?"); //bookCode는 유일한 값이기에 단일 행만 검색됨!
		pstmt.setLong(1, bookCode); 
		rs = pstmt.executeQuery();
		//result set(rs)은 표 형태의 오브젝트를 그대로 가져옴
		//rs는 0번째 column 가리킴
		
		BookDto dto = null; //임시로 데이터를 계속 연결할 용도 
		if(rs!=null) {
			rs.next(); //while문 벗겨냄, 1번만 이동하면 됨
				dto = new BookDto();
				//BookDto단위에 담기
				dto.setBookCode(rs.getLong("bookCode"));
				dto.setBookname(rs.getString("bookName"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setIsbn("isbn");
				//리스트 형태로 반환
		
				
//				System.out.print(rs.getInt("bookCode")+" ");
//				System.out.print(rs.getString("bookName") + " ");
//				System.out.print(rs.getString("publisher")+" ");
//
//				System.out.println(rs.getString("isbn"));

			
		}
		
		return dto;
	}

	public static int insertBook(BookDto bookDto) throws SQLException {
		
		pstmt = conn.prepareStatement("insert into tbl_book values(?, ?, ?, ?) "); //INSERT 쿼리문 생성
		//sql를 dbms로 전달										//받아야 할 인자값 4개
		pstmt.setLong(1, bookDto.getBookCode()); //1번째 ?에 들어갈 값(bookDto.getBookCode();)
		pstmt.setString(2, bookDto.getBookname());
		pstmt.setString(3, bookDto.getPublisher());
		pstmt.setString(4, bookDto.getIsbn());
		int result = pstmt.executeUpdate();	//실행
		return result;
	}

	public static int updateBook(BookDto bookDto) throws SQLException {
		
		pstmt = conn.prepareStatement("update tbl_book set bookName=?, publisher=?, isbn=? where bookCode= ?"); //INSERT 쿼리문 생성
		//sql를 dbms로 전달										//받아야 할 인자값 4개
		pstmt.setLong(4, bookDto.getBookCode()); 
		pstmt.setString(1, bookDto.getBookname());
		pstmt.setString(2, bookDto.getPublisher());
		pstmt.setString(3, bookDto.getIsbn());
		int result = pstmt.executeUpdate();	//실행
		return result;
		
	}

	public static int deleteBook(BookDto bookDto) throws SQLException {
		
		pstmt = conn.prepareStatement("delete from tbl_book where bookCode=?"); 										
		pstmt.setLong(1, bookDto.getBookCode()); 
		
		int result = pstmt.executeUpdate();	//실행
		return result;
	}

public static void main(String[] args) {
		try {
			// DBCONN
			conn();
			
			//TX START
			conn.setAutoCommit(false);
			
			// INSERT
//			insertBook(new BookDto(1L, "도서명1", "출판사명1", "isbn-1"));
//			insertBook(new BookDto(2L, "도서명1", "출판사명1", "isbn-1"));
//			insertBook(new BookDto(3L, "도서명1", "출판사명1", "isbn-1"));
//			insertBook(new BookDto(4L, "도서명1", "출판사명1", "isbn-1"));
			
//			// SELECTALL
			List<BookDto> allBook = selectAll();
			System.out.println("SelectAll : ");
			allBook.forEach(System.out::println);
			
//			// SELECT
			BookDto dto = select(1L);
			System.out.println("select : " + dto);
			
//			// UPDATE
//			dto.setBookName("수정도서명-2");
//			dto.setPublisher("수정출판사명-2");
//			int r1 = updateBook(dto);
//			if (r1 > 0)
//				System.out.println("수정완료 : " + r1);
//
//			// DELETE
			int r2 = deleteBook(dto);
			if (r2 > 0)
				System.out.println("삭제완료 : " + r2);
//
//			Tip** SELECT/UPDATE/DELETE 코드는 서로 쉐어하면 됨
			
			
			
//			//TX END
			conn.commit(); //트랜잭션 끝
						   //하나라도 작동하지 않으면 롤백!
		} catch (Exception e) {
			//TX ROLLBACKALL
			try {conn.rollback();}catch(Exception e2) {}
		}finally {
			//자원제거 - 만든 JDBC
			try{rs.close();} catch(Exception e3) {}
			try{pstmt.close();}catch(Exception e3) {}
			try{conn.close();} catch(Exception e3) {}
		}

	}

}
