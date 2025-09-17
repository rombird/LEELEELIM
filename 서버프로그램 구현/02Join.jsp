<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 문제 : 선언문(적절한 클래스 import 하기) -->
<!-- 자바파일에서 선언한 Dtos에 있는 MemberDto 사용, Utils의 DbUtils 사용
	java.uitl.regex : 비밀번호 유효성 검증을 위해 pattern, matcher 사용  -->
<%@ page import="Dtos.*, Utils.*, java.util.regex.*" %>		

<%
	/* 문제 : 문자셋 설정 */
	request.setCharacterEncoding("UTF-8");		// 요청할 때 문자셋 설정
	response.setContentType("text/html; charset=UTF-8");	// 응답받을 때 문자셋 설정
%>

<%!
	/* 문제 : 유효성 검증함수 만들기 */
	
	public boolean isValid(MemberDto dto){
		//1) 각 항목 not null (message : '-' 를 입력하세요 - System.out 으로 출력후 false)
		if(dto.getUserid().isEmpty()){		// Userid 비어있으면 콘솔에 출력, return false 값 반환 dto.getUserid() == null || 
			System.out.println("Userid 를 입력하세요.");
			return false;
		}
		if(dto.getPassword().isEmpty()){ // Password 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Password를 입력하세요.");
			return false;
		}
		if(dto.getRePassword() == null || dto.getRePassword().isEmpty()){ // RePassword 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("RePassword를 입력하세요.");
		}
		if(dto.getUsername() == null || dto.getUsername().isEmpty()){ // Username 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Username를 입력하세요.");
			return false;
		}
		if(dto.getZipcode() == null || dto.getZipcode().isEmpty()){ // Zipcode 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Zipcode를 입력하세요.");
			return false;
		}
		if(dto.getAddr1().isEmpty()){ // Addr1 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Addr1를 입력하세요.");
			return false;
		}
		if(dto.getAddr2().isEmpty()){ // Addr2 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Addr2를 입력하세요.");
			return false;
		}
		if(dto.getPhone1().isEmpty()){ // Phone1 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Phoen1를 입력하세요.");
			return false;
		}
		if(dto.getPhone2().isEmpty()){ // Phone2 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Phone2를 입력하세요.");
			return false;
		}
		if(dto.getPhone3().isEmpty()){ // Phone3 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Phone3를 입력하세요.");
		}
		if(dto.getTel1().isEmpty()){ // Tel1 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Tel1를 입력하세요.");
			return false;
		}
		if(dto.getTel2().isEmpty()){ // Tel2 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Tel2를 입력하세요.");
			return false;
		}
		if(dto.getTel3().isEmpty()){ // Tel3 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Tel3를 입력하세요.");
			return false;
		}
		if(dto.getEmail().isEmpty()){ // Email 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Email를 입력하세요.");
			return false;
		}
		if(dto.getYear().isEmpty()){ // Year 비어있으면 콘솔에 출력, return false 값 반환
			System.out.println("Year를 입력하세요.");
			return false;
		}
		if(dto.getMonth().isEmpty()){
			System.out.println("Month를 입력하세요.");
			return false;
		}
		if(dto.getDay().isEmpty()){
			System.out.println("Day를 입력하세요.");
			return false;
		}
		
		//2) userid 길이 5자 이하(message : Userid는 5자 이상 입력하셔야 합니다.- System.out 으로 출력후 false)
		
		if(dto.getUserid().length()<=5){			// 입력한 ID가 5글자 이하라면
			System.out.println("Userid는 5자 이상 입력하세요");
			return false;
		}
		
		//3) 패스워드 유효성 검증(regex : ^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{8,20}$ )
		//- System.out 으로 출력후 false
		
		String password = dto.getPassword();		// 현재 입력된 패스워드 가져오기
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{8,20}$";		//
		Pattern pattern = Pattern.compile(regex);	// Pattern 클래스 -> 문자열을 정규표현식 패턴 객체로 변환해줌
													// Pattern 클래스는 일반 클래스처럼 공개된 생성자를 제공하지 않으므로
													// compile()메소드를 호출해서 Pattern 객체로 컴파일된 정규식 얻음
		Matcher matcher = pattern.matcher(password);	// 정규식을 담고있는 패턴 객체로 matcher 메서드를 통해 문자열을 검사하고 
														// 필터링된 결과를 매처 객체로 반환
		
		if(!matcher.matches()){		//	패턴이 전체 문자열과 일치하지 않는다면
			System.out.println("비밀번호는 8자 이상 20자 이하이며 소문자, 대문자, 숫자, 특수기호 하나 이상은 포함해야합니다.");
			return false;
		}
		
		return true;
	}	
%>    

<!-- 01 문제 : 파라미터 받기 (액션태그 jsp:useBean , jsp:setProperty 로 MemberDto 단위로 받기 -->

<jsp:useBean id="dto" class="Dtos.MemberDto" scope="request" />
<jsp:setProperty name="dto" property="*"/>

<!-- Dtos패키지 안의 MemberDto클래스의 객체를 생성 후, 그 객체를 request범위(하나의 요청이 유지되는 동안) 안에 dto라는 이름으로 저장 -->
<!-- 폼에서 넘어온 요청 파라미터 값을 자바빈즈의 setter를 통해 자동으로 주입 -->
<%
	
	try{
		//-----------------------------
		//02 유효성 검증	
		//-----------------------------
		if(!isValid(dto)){		// 자바빈즈 객체 dto(폼에서 넘어온 값들)
			//유효하지 않는경우에 -> 01Join.html 로 Forwarding(요청과 응답값 모두 들고)
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
		if(DbUtils.selectMember(dto.getUserid()) != null){	// 입력한 id가 빈 값이 아니라면(이미 있는 값이라면)
			System.out.println("기존 계정이 존재합니다");
			request.getRequestDispatcher("./01Join.html").forward(request, response);
			return;
		}
		//03-04 계정정보 저장
		int result = DbUtils.insertMember(dto);		// 자바빈즈 객체 dto(폼에서 넘어온 값들)을 DB에 넣음
		if(result<=0){		// 근데 그 값이 0 이하라면(없거나 잘못되어있다면)
			System.out.println("회원가입에 실패했습니다");
			request.getRequestDispatcher("./01Join.html").forward(request, response);
			return ;
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
		response.sendRedirect("./03Login.jsp"); // 회원가입 완료되면 login.jsp
	}
	catch(Exception e){
		//"문제 발생 ROLLBACK" system.out 출력
		System.out.println("문제 발생 RollBack");
		e.printStackTrace(); // 어떤 예외처리 발생했는지 확인 가능
		//TX ROLLBACK 처리
		DbUtils.RollBack();
	}
		
%>