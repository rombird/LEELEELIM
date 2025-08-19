//package ex;
//
//
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class 문제2 {
//	// DB CONN DATA
//	private static String id = "root";
//	private static String pw = "1234";
//	private static String url = "jdbc:mysql://localhost:3306/opendatadb";
//
//	// JDBC참조변수
//	private static Connection conn = null; // DBMS 의 특정 DB와 연결되는 객체
//	private static PreparedStatement pstmt = null; // SQL Query 전송용 객체
//	private static ResultSet rs = null; // Select 결과물 담을 객체
////
//	public static void conn() throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");				// Class.forName() 메서드
//		System.out.println("Driver Loadeing Success...");
//		conn = DriverManager.getConnection(url,id,pw);
//		System.out.println("DB CONNECTED...");
//	}
//
//	public static List<BookDto> selectAll() throws SQLException {
//		pstmt = conn.prepareStatement("SELECT * FROM tbl_book");	// prepareStatement()DB에 보낼 SQL문 준비
//		
//		rs = pstmt.executeQuery();		// 실제 SQL이 DB에 전달되었는 결과가 rs에 담김
//		
//		 List<BookDto> list = new ArrayList();
//		 BookDto dto = null;			// 
//		
//		if(rs != null) {
//			while(rs.next()) {			// rs의 데이터(행)가 있으면 계속 밑의 코드 반복
//				dto = new BookDto();
//				dto.setBookCode(rs.getLong("bookCode"));
//				dto.setBookName(rs.getString("bookName"));
//				dto.setPublisher(rs.getString("publisher"));
//				dto.setIsbn(rs.getString("isbn"));
//				list.add(dto);
//				
//				System.out.print(rs.getInt("bookCode")+ ".");
//				System.out.print(rs.getString("bookName")+ ".");
//				System.out.print(rs.getString("publisher")+ ".");
//				System.out.println(rs.getString("isbn"));
//			}
//		}
//		
//		return list;
//	}
// //
//	public static BookDto select(Long bookCode) throws SQLException {
//		pstmt = conn.prepareStatement("SELECT * FROM tbl_book wher bookCode = ?");	// prepareStatement()DB에 보낼 SQL문 준비, bookCode가 ?인 데이터를 볼거다
//		pstmt.setLong(1, bookCode);
//		rs = pstmt.executeQuery();		// 실제 SQL이 DB에 전달되었는 결과가 rs에 담김
//		
//		 
//		 BookDto dto = null;			// 
//		
//		if(rs != null) {
//				rs.next();			
//				dto = new BookDto();
//				dto.setBookCode(rs.getLong("bookCode"));
//				dto.setBookName(rs.getString("bookName"));
//				dto.setPublisher(rs.getString("publisher"));
//				dto.setIsbn(rs.getString("isbn"));
//		}
//		
//		return dto;
//	}
//
//	public static int insertBook(BookDto bookDto) throws SQLException {
//		pstmt = conn.prepareStatement("insert into tbl_book values(?, ?, ?, ?)");
//		pstmt.setLong(1, bookDto.getBookCode());
//		pstmt.setString(2, bookDto.getBookName());
//		pstmt.setString(3, bookDto.getPublisher());
//		pstmt.setString(4, bookDto.getIsbn());
//		
//		//
//		int result = pstmt.executeUpdate();
//		
//		
//		return result;
//	}
//
//	public static int updateBook(BookDto bookDto) throws SQLException {
//		pstmt = conn.prepareStatement("insert into tbl_book set bookName = ?, publisher = ?, isbn = ?, where bookCode = ?");
//		pstmt.setString(1, bookDto.getBookName());
//		pstmt.setString(2, bookDto.getPublisher());
//		pstmt.setString(3, bookDto.getIsbn());
//		pstmt.setLong(4, bookDto.getBookCode());
//		
//		return -1;
//	}
// //
//	public static int deleteBook(BookDto bookDto) throws SQLException {
//		pstmt = conn.prepareStatement("delete from tbl_book wher bookCode = ?");
//		pstmt.setLong(1, bookDto.getBookCode());
//		
//		//
//		int result = pstmt.executeUpdate();
//		
//		return result;
//	}
//
//	public static void main(String[] args) {
//		try {
//			// DBCONN
//			conn();				
//			
//			//TX START
//			conn.setAutoCommit(false);
//			
//			// INSERT
// //			insertBook(new BookDto(1L, "도서명1", "출판사명1", "isbn-1"));
// //			insertBook(new BookDto(2L, "도서명1", "출판사명1", "isbn-1"));
// //			insertBook(new BookDto(3L, "도서명1", "출판사명1", "isbn-1"));
// //			insertBook(new BookDto(4L, "도서명1", "출판사명1", "isbn-1"));
//			// SELECTALL
// //			List<BookDto> allBook = selectAll();
// //			System.out.println("SelectAll : ");
// //			allBook.forEach(System.out::println);
//			// SELECT
//			BookDto dto = select(1L);
//			System.out.println("select : " + dto);
//			// UPDATE
// //			dto.setBookName("수정도서명-2");
// //			dto.setPublisher("수정출판사명-2");
// //			int r1 = updateBook(dto);
// //			if (r1 > 0)
// //				System.out.println("수정완료 : " + r1);
//
//			// DELETE
//			int r2 = deleteBook(dto);
//			if (r2 > 0)
//				System.out.println("삭제완료 : " + r2);
//
//			//TX END
//			conn.commit();
//		} catch (Exception e) {
//			//TX ROLLBACKALL
//			try {conn.rollback();}catch(Exception e2) {}
//		}finally {
//			// 자원제거
//			try {rs.close();}catch(Exception e3) {}
//			try {pstmt.close();}catch(Exception e3) {}
//			try {conn.close();}catch(Exception e3) {}
//		}
//
//	}
//
//}
