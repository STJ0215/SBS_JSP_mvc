<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.sbs.edu.mvc.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보</title>
</head>
<body>
		<%
		ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list");
		
	    if (!list.isEmpty()) {  %>
		   <table border="1">
		   		<tr><th>ID</th><th>비밀번호</th><th>이름</th><th>이메일</th></tr>
				
				<%   for (int i=0; i<list.size(); i++){   
				       MemberVO member = list.get(i);   %>
				       
				        <tr>
				        	<td><%=member.getUserid()%></td>
				            <td><%=member.getUserpw() %></td>
				            <td><%=member.getName() %></td>
				            <td><%=member.getMain() %></td>
				       </tr>
				       
				<%   }
	       }
	    else {
	    	   out.print("<h3>등록된 회원 정보가 없습니다.</h3>");
	       }
		%>
		  </table>
	
	<img src="/getFormImage" alt="no" />
	
	<%@ include file="home.jsp" %> 
</body>
</html>