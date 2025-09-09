<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Congratulation! Success!!</h1>
    <div>
        <a href="/memo/add">메모쓰기</a>
    </div>
    	<div>
    	    ${result}
    	</div>




    <!-- WEB-INF안에 있는 JSP는 브라우저에서 직접 접근할 수 없다
        브라우저가 HTML을 보고 img경로를 요청하면, 서버가 웹에서 접근 가능한 경로를
        기준으로 이미지를 찾음
        imageFile은 webapp 바로 아래 있으므로 웹에서 접근 가능한 정적 리소스
    -->
    <div>
    <img src="/imageFile/images/success.png" alt="Success">
    </div>

</body>
</html>