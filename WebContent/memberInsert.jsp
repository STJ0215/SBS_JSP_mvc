<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>생성</title>
	</head>
	<body>
		${error} <!-- request.getAttribute('error'); -->
		<h3>회원가입</h3>
		<form action="memberInsert.do" method="POST">
			ID : <input type="text" name="id" /><br />
			PW : <input type="password" name="pw" /><br />
			이름 : <input type="text" name="name" /><br />
			E-MAIL : <input type="text" name="mail" /><br />
			<input type="submit" value="가입" />
		</form>
	</body>
</html>