package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class 문제2ByMyself {
	// DB CONN DATA
	private static String id = "root";
	private static String pw = "1234";
	private static String url = "jdbc:mysql://localhost:3306/opendatadb";

	// JDBC참조변수
	private static Connection conn = null; // DBMS 의 특정 DB와 연결되는 객체 	
	private static PreparedStatement pstmt = null; // SQL Query 전송용 객체
	private static ResultSet rs = null; // Select 결과물 담을 객체

	public static void conn() throws Exception {		// conn() throws Exception -> conn 객체가 만들어질때 예외처리하겠다
														
		Class.forName("com.mysql.cj.jdbc.Driver");		// DriverManager가 mysql을 알게 해줌
		System.out.println("Driver Loading success");
		conn = DriverManager.getConnection(url,id,pw);		// DriverManager가 DB에 연결해주고 MySQL이랑 연결된 conn 객체 만듬 
		System.out.println("DB Connected...");
	}

	public static List<BookDto> selectAll() throws SQLException {
		
		pstmt = conn.prepareStatement("SELECT * FROM tbl_book");	// 전송용 객체 pstmt에 SQL명령문 담기
		
		rs = pstmt.executeQuery(); 	// executeQuery() select같은 조회용 SQL문 실행. DB 조회한 값(주소값) rs에 담김
		
		List<BookDto> list = new ArrayList();		// list는 계속 생겨날 dto들을 담을 List 변수
		BookDto dto = null;							// dto는 BookDto의 행(가로, 객체)를 담을 변수
		
	if(rs != null) {					// DB에서 읽어낸 값이 0이 아니라면 == DB에서 값을 읽어왔다면
			while(rs.next()) {			// DB의 행을 하나하나씩 읽어나가자
				dto = new BookDto();	// BookDto dto = new BookDto(); -> BookDto 객체 dto 생성
				dto.setBookCode(rs.getLong("bookCode"));			// class BookDto에서 미리 재정의한 setter메서드, bookCode의 값 가져옴
				dto.setBookName(rs.getString("bookName"));			// class BookDto에서 미리 재정의한 setter메서드, bookName의 값 가져옴
				dto.setPublisher(rs.getString("publisher"));		// class BookDto에서 미리 재정의한 setter메서드, publisher의 값 가져옴
				dto.setIsbn(rs.getString("isbn"));					// class BookDto에서 미리 재정의한 setter메서드, isbn의 값 가져옴
				list.add(dto);						// 계속해서 생겨나는 BookDto의 객체 dto들을 list에 담음
						
			}
		}
		return list;		// DB가 들고있는 데이터를 조회할 수 있는 값 반환
	}

	public static BookDto select(Long bookCode) throws SQLException {	// bookCode를 인자로 받아서 실행되는 select함수 정의
		
		pstmt = conn.prepareStatement("SELECT * FROM tbl_book where bookCode = ?");		// SQL명령문 전달할 pstmt
																						// tbl_book에서 특정 bookCode의 데이터를 전부 보여줘
		pstmt.setLong(1, bookCode);		// 첫 번째 물음표 자리에 select(Long bookCode)의 인자로 받을 bookCode 삽입 
		rs = pstmt.executeQuery();	// select 실행할 메서드. DB 조회한 값 rs에 담김
		BookDto dto = null;			// bookCode 입력해서 나온 행(가로 == 객체)의 데이터 저장하는 변수
		
		if(rs != null) {
			if(rs.next()) {				// 처음 커서는 첫 행의 전에 있으므로 이동시켜야 함
			dto = new BookDto();		// BookDto 객체 dto 생성
			dto.setBookCode(rs.getLong("bookCode"));		// class BookDto에서 미리 재정의한 setter메서드, bookCode의 값 가져옴
			dto.setBookName(rs.getString("bookName"));		// class BookDto에서 미리 재정의한 setter메서드, bookName의 값 가져옴
			dto.setPublisher(rs.getString("publisher"));	// class BookDto에서 미리 재정의한 setter메서드, publisher의 값 가져옴
			dto.setIsbn(rs.getString("isbn"));				// class BookDto에서 미리 재정의한 setter메서드, isbn의 값 가져옴
			}
		}
		return dto;
	}

	public static int insertBook(BookDto bookDto) throws SQLException {		// insertBook 객체-> BookDto의 속성값 입력하는 객체 
		
		pstmt = conn.prepareStatement("insert into tbl_book values(?, ?, ?, ?)");
		pstmt.setLong(1, bookDto.getBookCode());		//  SQL1번째 열에 BookCode 입력
		pstmt.setString(2, bookDto.getBookName());		//  SQL2번째 열에 BookName 입력
		pstmt.setString(3, bookDto.getPublisher());		//  SQL3번째 열에 publisher 입력
		pstmt.setString(4, bookDto.getIsbn());		//  SQL4번째 열에 isbn 입력
		
		int result = pstmt.executeUpdate();		// executeUpdate() -> Insert/ Update/ Delete 문 실행 시 사용
												// 실행된 행(row == 가로 == 객체)의 개수를 반환
		
		return result;
	}

	public static int updateBook(BookDto bookDto) throws SQLException {
	
		pstmt = conn.prepareStatement("update tbl_book set bookName = ?, publisher = ?, isbn = ? where bookCode = ?");
		pstmt.setString(1, bookDto.getBookName());		// 첫번째 물음표에 받은 인자 bookDto의 bookName 입력	-> 메인문에서 bookName 수정함
		pstmt.setString(2, bookDto.getPublisher());		// 첫번째 물음표에 받은 인자 bookDto의 publisher 입력 -> 메인문에서 publisher 수정함
		pstmt.setString(3, bookDto.getIsbn());			// 첫번째 물음표에 받은 인자 bookDto의 isbn 입력
		pstmt.setLong(4, bookDto.getBookCode());		// // 첫번째 물음표에 받은 인자 bookDto의 bookCode 입력
		
		int result = pstmt.executeUpdate();		// executeUpdate() -> Insert/ Update/ Delete 문 실행 시 사용
												// 실행된 행의 개수를 반환
		return result;
	}

	public static int deleteBook(BookDto bookDto) throws SQLException {

		
		pstmt = conn.prepareStatement("delete from tbl_book where bookCode = ?");	// sql명령문 전달할 pstmt에 명령문 저장
		pstmt.setLong(1, bookDto.getBookCode());	//	인자로 받은 bookDto의 bookCode값을 첫번째 물음표에 전달
		
		int result = pstmt.executeUpdate();			// 	삭제한 행의 개수를 result에 담아서 반환
		
		return result;
	}

	public static void main(String[] args) {
		try {							// DB 만지는동안 발생하는 예외처리
			// DBCONN
			conn();						// conn 실행 -> Mysql DB에 연결
			
			//TX START
			
			conn.setAutoCommit(false);	// 트랜잭션 설정 시작지점, 자동커밋 기능 끄고 모든 DML(Insert/ Delete/ Update)작업은
										// 커밋할 때 같이 DB에 반영할거다
			// INSERT
			insertBook(new BookDto(1L, "도서명1", "출판사명1", "isbn-1"));
			insertBook(new BookDto(2L, "도서명2", "출판사명2", "isbn-2"));
			insertBook(new BookDto(3L, "도서명3", "출판사명3", "isbn-3"));
			insertBook(new BookDto(4L, "도서명4", "출판사명4", "isbn-4"));
			
			// SELECTALL							// select은 커밋하든 말든 상관없음
			List<BookDto> allBook = selectAll();	// selectAll()이 반환하는 list(DB를 조회할 수 있는 값)를 받는 allBook 생성 
			System.out.println("SelectAll : ");
			allBook.forEach(System.out::println);	// allBook의 순회하며 행 하나하나의 값을 출력
													// BookDto에서 재정의한 toString덕분에 DB의 값을 한 행씩 볼 수 있음
			// SELECT
			BookDto dto = select(1L);				// select(Long bookCode)함수 인자로 1을 주고 bookCode가 1인 데이터를 반환받음
			System.out.println("select : " + dto);	// bookCode가 1인 데이터 출력
			
			// UPDATE
			dto.setBookName("수정도서명-2");			// 위의 select에서 bookCode 1인 데이터를 담고 있는 dto의 bookName 새로 담음
			dto.setPublisher("수정출판사명-2");			// bookCode 1인 데이터를 담고 있는 dto의 publisher 새로 담음
			int r1 = updateBook(dto);				// 수정한 dto를 인자로 넘기고 받은 반환값(몇 개의 행이 바뀌었는지)을 r1에 저장
			if (r1 > 0)								// 수정된 행이 0보다 많다면, 성공적으로 수정이 되었다면
				System.out.println("수정완료 : " + r1);	// 수정완료된 행은 r1개입니다

			// DELETE
			int r2 = deleteBook(dto);				// r2에 deletBook(dto)이 실행되고 리턴된 값(삭제된 행의 개수)를 담는다 
			if (r2 > 0)								// 삭제된 행의 개수가 0보다 많다면
				System.out.println("삭제완료 : " + r2);	// 삭제완료: r2

			//TX END
			conn.commit();		// 트랜잭션 범위 안에 있었던 Insert/ Delete/ Update 전부 DB에 최종 반영
		} catch (Exception e) {		// 위의 try문 안의 작업에서 오류가 있었다면
			//TX ROLLBACKALL
			try {conn.rollback();}catch(Exception e2) {};	// DB에 관련된 모든 작업들은 원래의 상태대로 되돌려라 -> 원자성
		}finally {											// 예외가 발생하든 말든 finally문안의 코드는 실행시켜라(데이터 누수 안되게 다 다 닫아줘)
			 try {conn.close();}catch(Exception e3){};		// DATABASE연결되있는 conn 닫아줘
			 try {pstmt.close();}catch(Exception e3){};		// SQL문 전달하는 pstmt 닫아줘
			 try {rs.close();}catch(Exception e3){};		// DB에서 가져온 결과 보여주는 rs 닫아줘
		}

	}

}