<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加用户--可被攻击</title>
</head>
<body>
<form action="/csrf/userAdd" method="post">
	用户名：<input type="text" name="userNo">
	密    码：<input type="text" name="password">
	<input type="submit">
</form>
</body>
</html>