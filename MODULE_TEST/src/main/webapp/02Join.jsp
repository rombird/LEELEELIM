<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 문제 : 선언문(적절한 클래스 import 하기) -->
<!-- 자바파일에서 선언한 Dtos에 있는 MemberDto 사용, Utils의 DbUtils 사용
	java.uitl.regex : 비밀번호 유효성 검증을 위해 pattern, matcher 사용  -->
<%@ page import="Dtos.*,Utils.*, java.util.regex.*" %>

<%!

	/* 문제 : 유효성 검증함수 만들기 */
	public boolean isValid(MemberDto dto){
		// 1) 각 항목 not null (message : '-' 를 입력하세요 - System.out 으로 출력후 false)
		if(dto.getUserid() == null || dto.getUserid().isEmpty()){ // dto의 Userid 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Userid를 입력하세요.");
			return false; 
		}
		if(dto.getPassword().isEmpty()){ // dto의 Password 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Password를 입력하세요.");
			return false;
		}
		if(dto.getRePassword().isEmpty()){ // dto의 RePassword 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("RePassword를 입력하세요.");
			return false;
		}
		if(dto.getUsername().isEmpty()){ // dto의 Username 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Username을 입력하세요.");
			return false;
		}
		if(dto.getZipcode().isEmpty()){ // dto의 Zipcode 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Zipcode를 입력하세요.");
			return false;
		}
		if(dto.getAddr1().isEmpty()){ // dto의 Addr1 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Addr1을 입력하세요.");
			return false;
		}
		if(dto.getAddr2().isEmpty()){ // dto의 Addr2 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Addr2를 입력하세요.");
			return false;
		}
		if(dto.getPhone1().isEmpty()){ // dto의 Phone1 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Phone1을 입력하세요.");
			return false;
		}
		if(dto.getPhone2().isEmpty()){ // dto의 Phone2 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Phone2를 입력하세요.");
			return false;
		}
		if(dto.getPhone3().isEmpty()){ // dto의 Phone3 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Phone3를 입력하세요.");
			return false;
		}
		if(dto.getTel1().isEmpty()){ // dto의 Tel1 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Tel1을 입력하세요.");
			return false;
		}
		if(dto.getTel2().isEmpty()){ // dto의 Tel2 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Tel2를 입력하세요.");
			return false;
		}
		if(dto.getTel3().isEmpty()){ // dto의 Tel3 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Tel3을 입력하세요.");
			return false;
		}
		if(dto.getEmail().isEmpty()){ // dto의 Email 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Email을 입력하세요.");
			return false;
		}
		if(dto.getYear().isEmpty()){ // dto의 Year 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Year를 입력하세요.");
			return false;
		}
		if(dto.getMonth().isEmpty()){ // dto의 Month 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Month를 입력하세요.");
			return false;
		}
		if(dto.getDay().isEmpty()){ // dto의 Day 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Day를 입력하세요.");
			return false;
		}
		
		// 2) userid 길이 5자 이하(message : Userid는 5자 이상 입력하셔야 합니다.- System.out 으로 출력후 false)		
		if(dto.getUserid().length()<=5){ // 입력한 ID가 5글자 이하라면 콘솔에 메시지 출력, return false 값 반환
			System.out.println("Userid는 5자 이상 입력하세요.");
			return false;
		} 
		
		// 3) 패스워드 유효성 검증(regex : ^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{8,20}$ )
		//- System.out 으로 출력후 false
		// Pattern 생성(원하는 정규식을 넣어서) : 문자열을 정규표현식 패턴 객체로 변환해줌 
		/* Pattern pwd = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&*()-+=]).{8,20}$");
		// Matcher 생성(정규식을 가지고 찾아볼 원본문자열) : 정규식을 담고 있는 패턴 객체로 matcher 메서드를 통해 문자열을 검사하고 필터링된 결과를 matcher 객체로 반환
		Matcher pwdmatch = pwd.matcher(dto.getPassword());
		if(!pwdmatch.find()){
			System.out.println("Password는 8자 이상 20자 이하이며 소문자, 대문자, 숫자, 특수기호 하나 이상은 포함해야합니다.");
			return false;
		}
		 */
		String password = dto.getPassword();		// 현재 입력된 패스워드 가져오기
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{8,20}$";	
		Pattern pattern = Pattern.compile(regex);	// Pattern 클래스 -> 문자열을 정규표현식 패턴 객체로 변환해줌
													// Pattern 클래스는 일반 클래스처럼 공개된 생성자를 제공하지 않으므로
													// compile()메소드를 호출해서 Pattern 객체로 컴파일된 정규식 얻음
		Matcher matcher = pattern.matcher(password);	// 정규식을 담고있는 패턴 객체로 matcher 메서드를 통해 문자열을 검사하고 
														// 필터링된 결과를 매처 객체로 반환
		
		if(!matcher.matches()){		//	패턴이 전체 문자열과 일치하지 않는다면
			System.out.println("비밀번호는 8자 이상 20자 이하이며 소문자, 대문자, 숫자, 특수기호 하나 이상은 포함해야합니다."); // 콘솔창에 메시지 출력
			return false;
		}

		return true; // 값이 비어있지 않고, userid도 5자 이상이고 패스워드 유효성 검증까지 잘되었다면(유효하다면) true 값 반환
	}	
%>    

<%
	/* 문제 : 문자셋 설정 */
	request.setCharacterEncoding("UTF-8"); // 요청할 때 문자셋 설정
	response.setContentType("test/html; charset=UTF-8"); // 응답할 때 문자셋 설정
%>


<!--  
01 문제 : 파라미터 받기 (액션태그 jsp:useBean , jsp:setProperty 로 MemberDto 단위로 받기
-->

<jsp:useBean id="dto" class="Dtos.MemberDto" scope="request"/>
<jsp:setProperty name="dto" property="*" />

<%
	
	try{
		//-----------------------------
		//02 유효성 검증	
		//-----------------------------
		if(!isValid(dto)){
			// 유효하지 않는경우에 -> 01Join.html 로 Forwarding
			// request, response 객체를 01.Join.html로 이동
			request.getRequestDispatcher("./01Join.html").forward(request, response);
			return;
		}
		//-----------------------------
		//03 서비스 처리(회원가입->DB 저장)
		//-----------------------------
		//03-01 db연결
		DbUtils.conn();
		
		//03-02 Tx 시작
		DbUtils.TxStart();
		
		//03-03 동일 계정유무확인
		if(DbUtils.selectMember(dto.getUserid())!=null){ // DB에 저장된 userid가 null이 아니라면 = 이미 존재한다면
			System.out.println("기존 계정이 존재합니다"); // 콘솔창에 메시치 출력
			request.getRequestDispatcher("./01Join.html").forward(request, response); // 01.Join.html 로 이동
			return;
		}
		
		//03-04 계정정보 저장			
		int result = DbUtils.insertMember(dto); // 자바빈즈 객체 dto(01.Join.html에서 넘어온 값들)을 DB 에 넣음
		if(result<=0){ // result가 0이하라면(없거나 잘못되어있다면)
			System.out.println("회원가입에 실패했습니다."); // 콘솔창에 출력
			request.getRequestDispatcher("./01Join.html").forward(request, response); // 01.Join.html 로 이동
			return;
		}
		
		//03-05 Tx 종료
		DbUtils.TxEnd();
		
		//03-06 연결해제
		DbUtils.disConn();
		
		//-----------------------------
		//04 로그인 페이지로 이동
		//-----------------------------
		//04-01 "회원가입을 완료했습니다" 를 system.out 으로 출력
		System.out.println("회원가입을 완료했습니다."); 
		//04-02 Login.jsp 로 리다이렉트
		response.sendRedirect("./03Login.jsp"); // 회원가입 완료되면 login 페이지 띄우기
		
	}
	catch(Exception e){
		// "문제 발생 ROLLBACK" system.out 출력
		System.out.println("문제 발생 ROLLBACK");
		// TX ROLLBACK 처리
		DbUtils.RollBack();
		e.printStackTrace(); // 어떤 예외처리 발생했는지 확인 가능
	}
		
%>