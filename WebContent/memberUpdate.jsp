<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.sbs.edu.mvc.vo.MemberVO"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>수정</title>
	</head>
	<body>
		<h3>수정 정보 검색</h3>
		${error}
		<form action="memberSearch.do" method="POST">
			ID : <input type="text" name="id" />
			<input type="hidden" name="job" value="update" />
			<input type="submit" value="검색" />	
		</form>
		<% 
			MemberVO member = (MemberVO)request.getAttribute("member"); 
			if (member != null) {
				%>
				<h3>회원정보 수정</h3>
				<form action="memberUpdate.do" method="POST">
					ID : <input type="text" name="id" readonly value="${member.userid}" /> <br />
					PW : <input type="password" name="pw" value="${member.userpw}" /> <br />
					이름 : <input type="text" name="name" value="${member.name }" /> <br />
					E-MAIL : <input type="text" name="mail" value="${member.main}" /><br />
					<input type="submit" value="수정" />	
				</form>	 
			<%
			}
			else {	%>
				${result} <br />
			<%
			}
			%>
	</body>
</html>