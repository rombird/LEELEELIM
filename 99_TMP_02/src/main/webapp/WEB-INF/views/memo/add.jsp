<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>MEMO ADD(/memo/add)</h1>

	<form action="/memo/add" method="post">
		<div>
			<label>text : </label>  <span>${text}</span><br>
			<textarea name="text" /></textarea>
		</div>
		<div>
			<label>writer : </label>  <span>${writer}</span><br>
			<input name="writer" />
		</div>
		<div>
			<input type="submit" value="메모쓰기" />
		</div>
	</form>

</body>
</html>