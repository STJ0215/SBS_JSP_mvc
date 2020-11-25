<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>검색</title>
</head>
<body>
	<h3>회원정보 검색</h3>
	${error}
	<form action="memberSearch.do">
		ID : <input type="text" name="id" />
		<input type="hidden" name="job" value="search" />
		<input type="submit" value="검색" />
	</form>
</body>
</html>