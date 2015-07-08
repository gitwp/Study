<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@page import="crsf.normal.web.bean.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆</title>
</head>
<body>
	<a href="/csrf-defend/userAdd">添加用户</a>
	<table>
	<tr>
		<th>用户名</th>
		<th>密码</th>
		</tr>
		<%
			List<User> userlist = new ArrayList<User>();
			userlist = (List<User>) session.getAttribute("userlist");
			if(userlist==null){
				System.out.println("userlist==null");
			}else{
				System.out.println("userlist.size="+userlist.size());
			}
			for (User user : userlist) {
		%>
		<tr>
		<td><%=user.getUserNo()%></td>
		<td><%=user.getPassword()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>