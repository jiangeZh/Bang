<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
<br/>
	昵称：${user.userName}<br>
	简介：${user.userDesc}<br>
	<br>
	<a href="${pageContext.request.contextPath}/manage/viewOwnerPublish.jsp">我的发布</a><br/><br/>
	<a href="${pageContext.request.contextPath}/manage/MgrOwnerFavorites.jsp">我的收藏</a><br/><br/>
  </body>
</html>