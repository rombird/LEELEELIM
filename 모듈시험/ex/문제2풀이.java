package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class 문제2풀이 {
	// DB CONN DATA - DB연결 시작
	private static String id = "root"; // DB 접속에 사용할 사용자 이름
	private static String pw = "1234"; // 위의 id 계정에 대한 pw
	private static String url = "jdbc:mysql://localhost:3306/opendatadb"; // db연결을 위한 경로 정의

	// JDBC참조변수 - JDBC 사용을 위한 객체 선언
	private static Connection conn = null; // DBMS의 특정 DB와 연결되는 객체
	private static PreparedStatement pstmt = null; // SQL Query 전송용 객체
	private static ResultSet rs = null; // Select 결과물 담을 객체

	public static void conn() throws Exception { // 예외가 발생했을 때 실행했던 위치(main내의 conn();)로 던짐
													// 업캐스팅 형태로 모든 예외 처리
													// static 설정으로 객체 생성과 무관하게 접근이 가능하도록 함
		Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC 드라이버 로딩
		System.out.println("Driver Loading Success...");
		conn = DriverManager.getConnection(url, id, pw); // 연결정보가 담긴 conn 객체(자료형:Connection) 생성
		System.out.println("DB CONNECTED...");
	}

	public static List<BookDto> selectAll() throws SQLException { // BookDto 객체를 담은 리스트 형태로 조회한 것을 반환
		// 예외 발생 시 메서드 호출한 곳에서 SQLException 예외처리 지시
		pstmt = conn.prepareStatement("SELECT * FROM tbl_book"); // conn과 연결된 DB에 Query문을 실행할 준비

		rs = pstmt.executeQuery(); // 준비된 Query문 실행

		List<BookDto> list = new ArrayList(); // 각 행이 List형태로 담김
		BookDto dto = null; // 임시로 데이터를 계속 연결할 용도
							// 반복문 내에서 임시로 쓸 BookDto 객체 참조변수 선언
		if (rs != null) { // rs가 null이 아니라면
			// 반복문
			while (rs.next()) { // rs.next() : rs가 가리키고 있는 커서의 위치를 다음으로 내림(행이 있으면 True, 없으면 False)
								// rs.next() : 한 행씩 건너뛰면서 컬럼값을 가져옴
				dto = new BookDto(); // BookDto 객체 생성 - 결과값이 존재할 때만

				// BookDto 객체 단위에 담기
				dto.setBookCode(rs.getLong("bookCode")); // DB내의 "bookCode" 값을 가져와서(get)
															// 그 값을 dto 객체의 bookCode에 저장(set)
				dto.setBookname(rs.getString("bookName")); // "bookName" 값을 가져와서(get) dto 객체의 bookName에 저장(set)
				dto.setPublisher(rs.getString("publisher")); // "publisher" 값을 가져와서(get) dto 객체의 publisher에 저장(set)
				dto.setIsbn(rs.getString("isbn")); // "isbn" 값을 가져와서(get) dto 객체의 setIsbn에 저장(set)

				list.add(dto);// dto 객체를 List<BookDto> 리스트에 add

			}
		}
		return list; // dto 객체가 추가된 List<BookDto> 반환
	}

	
	public static BookDto select(Long bookCode) throws SQLException { // Long자료형인 bookCode를 조회하고 예외발생 시
																		// 메서드를 호출한 곳에서 SQLException을 처리할 것
		pstmt = conn.prepareStatement("SELECT * FROM tbl_book where bookCode=?");
		// bookCode가 ?인 곳 행을 조회하는 Query문을 준비해서 pstmt 변수에 저장 => bookCode는 유일한 값이기에 단일 행만 검색됨!

		pstmt.setLong(1, bookCode); // 첫번째 ?에 long타입을 지닌 bookCode 값
		rs = pstmt.executeQuery(); // 준비된 Query문 실행
		// result set(rs)은 표 형태의 오브젝트를 그대로 가져옴
		// rs는 0번째 column 가리킴

		BookDto dto = null; // 임시로 데이터를 계속 연결할 용도

		if (rs != null) {
			rs.next(); // while문 벗겨냄, 1번만 이동하면 됨
			dto = new BookDto(); // BookDto 객체 생성 - 결과값이 존재할 때만

			// BookDto 객체 단위에 담기
			dto.setBookCode(rs.getLong("bookCode")); // DB내의 "bookCode" 값을 가져와서(get)그 값을 dto 객체의 bookCode에 저장(set)
			dto.setBookname(rs.getString("bookName")); // "bookName" 값을 가져와서(get) dto 객체의 bookName에 저장(set)
			dto.setPublisher(rs.getString("publisher")); // "publisher" 값을 가져와서(get) dto 객체의 publisher에 저장(set)
			dto.setIsbn(rs.getString("isbn")); // "isbn" 값을 가져와서(get) dto 객체의 setIsbn에 저장(set)
			

		}

		return dto; //dto(BookDto 객체) 반환
	}

	public static int insertBook(BookDto bookDto) throws SQLException {//외부에서 받은 BookDto 객체 값을 db에 삽입한 후
																	   //예외발생 시 메서드를 호출한 곳에서 SQLException 처리할 것
								
		pstmt = conn.prepareStatement("insert into tbl_book values(?, ?, ?, ?) "); // INSERT 쿼리문 생성
		// sql를 dbms로 전달 										  //4개의 ?파라미터 받음
		
		// 외부로부터 인자값을 받아서 db로 삽입
		pstmt.setLong(1, bookDto.getBookCode()); // BookCode 값을 가져와서(get) 1번째 ? 자리에 Long타입으로 저장(set)
		pstmt.setString(2, bookDto.getBookname()); // Bookname 값을 가져와서(get) 2번째 ? 자리에 String타입으로 저장(set)
		pstmt.setString(3, bookDto.getPublisher()); // getPublisher 값을 가져와서(get) 3번째 ? 자리에 String타입으로 저장(set)
		pstmt.setString(4, bookDto.getIsbn()); // Isbn 값을 가져와서(get) 4번째 ? 자리에 String타입으로 저장(set)
		
		int result = pstmt.executeUpdate(); // 실행 
		return result; // 증가된 행(row)의 개수 값 리턴
	}

	public static int updateBook(BookDto bookDto) throws SQLException {//외부에서 받은 BookDto 객체로 db 값 수정 후
		   															   //예외발생 시 메서드를 호출한 곳에서 SQLException 처리할 것

		pstmt = conn.prepareStatement("update tbl_book set bookName=?, publisher=?, isbn=? where bookCode= ?");
		// sql를 dbms로 전달 			   // bookCode를 통해서 수정할 행을 지정하고 bookName, publisher, isbn 컬럼값을 수정해라
		
		// 외부로부터 인자값을 받아서 db로 삽입
		pstmt.setLong(1, bookDto.getBookCode()); // BookCode 값을 가져와서(get) 1번째 ? 자리에 Long타입으로 저장(set)
		pstmt.setString(2, bookDto.getBookname()); // Bookname 값을 가져와서(get) 2번째 ? 자리에 String타입으로 저장(set)
		pstmt.setString(3, bookDto.getPublisher()); // getPublisher 값을 가져와서(get) 3번째 ? 자리에 String타입으로 저장(set)
		pstmt.setString(4, bookDto.getIsbn()); // Isbn 값을 가져와서(get) 4번째 ? 자리에 String타입으로 저장(set)
		
		int result = pstmt.executeUpdate(); // 실행 
		return result; // 수정된 행(row)의 개수 값 리턴
	}

	public static int deleteBook(BookDto bookDto) throws SQLException {

		pstmt = conn.prepareStatement("delete from tbl_book where bookCode=?"); //bookCode값 기준 해당 행 전체 삭제하는 
																				//query문을 pstmt변수에 담음
		pstmt.setLong(1, bookDto.getBookCode()); //첫번째 ?에 BookCode값 가져와서(get) Long타입으로 저장(set)

		int result = pstmt.executeUpdate(); // 실행
		return result; // 삭제된 행(row)의 개수 값 리턴
	}

	public static void main(String[] args) {
		try { //예외발생 가능성 존재
			// DBCONN
			conn();

			// TX START
			conn.setAutoCommit(false);	//자동 커밋(저장)되는 것을 막음 ->트랜잭션 시작 부위

			// INSERT
//			insertBook(new BookDto(1L, "도서명1", "출판사명1", "isbn-1"));
//			insertBook(new BookDto(2L, "도서명1", "출판사명1", "isbn-1"));
//			insertBook(new BookDto(3L, "도서명1", "출판사명1", "isbn-1"));
//			insertBook(new BookDto(4L, "도서명1", "출판사명1", "isbn-1"));

//			// SELECTALL
			List<BookDto> allBook = selectAll(); // bookDto가 리스트형으로 반환됨
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
			conn.commit(); // 트랜잭션 끝
						   // 하나라도 작동하지 않으면 롤백!
			
			
		} catch (Exception e) {
			//예외 발생 시 트랜잭션 롤백
			
			// TX ROLLBACKALL
			try {
				conn.rollback(); //Connection 객체 트랜잭션을 rollback
			} catch (Exception e2) {
				
			}
		} finally { //예외발생 상관없이 무조건적으로 실행되는 부분
			
			// 자원제거 - 만든 JDBC
			// 만든 역순으로 제거
			try {
				rs.close();
			} catch (Exception e3) {
				
			}
			try {
				pstmt.close();
			} catch (Exception e3) {
				
			}
			try {
				conn.close();
			} catch (Exception e3) {
			}
		}

	}

}
