<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
<br/>
	昵称：${user.userName}<br>
	简介：${user.userDesc}<br>
	<br>
	<a href="${pageContext.request.contextPath}/manage/viewVisitorPublish.jsp?owner=${user.userName}">他的发布</a><br/><br/>
  </body>
</html>