<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
	<div align="center">
		<h2>欢迎您，请注册账号</h2>
		<form action="${pageContext.request.contextPath}/servlet/RegisterServlet?mode=web" method="post">
			账号:<input type="text" name="userName" /><br/> 
			密码:<input type="password" name="userPassword" /><br/> 
			邮箱:<input type="text" name="e-mail" /><br/> 
			入学年份:<input type="text" name="schoolYear" /><br/> 
			签名档:<input type="text" name="userDesc" /><br/> 
			0：师兄师姐，1：师弟师妹<input type="text" name="role" /><br/>
			关心的种类<input type="text" name="concernId" /><br/> 
			<input type="submit" value="注册" />
		</form>
	</div>
</body>
</html>