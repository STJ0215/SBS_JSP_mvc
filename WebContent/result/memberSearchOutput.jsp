<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>조회 결과</title>
</head>
<body>
	<h3>검색 결과</h3>
	<%
		String result = (String)request.getAttribute("result");
		if (result != null) {
			out.print(result + "<p>");
		}
		else {
	%>
		<h3>
				${member.userid } / ${member.userpw} / ${member.name} / ${member.main}
		</h3>
	<%
		}
	%>
	<%@ include file="home.jsp" %>
</body>
</html>