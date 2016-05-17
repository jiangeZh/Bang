<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<div align="center">
		<h2>欢迎您，使用资源库</h2>
		<form action="${pageContext.request.contextPath}/servlet/LoginServlet?mode=web" method="post">
			用户账号:<input type="text" name="username" /><br/> 
			用户密码:<input type="password" name="password" /><br/> 
			<input type="submit" value="登录" />
		</form>
		<a href="${pageContext.request.contextPath}/manage/register.jsp">注册</a>
	</div>
</body>
</html>