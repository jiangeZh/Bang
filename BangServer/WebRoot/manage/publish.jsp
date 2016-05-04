<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
<br/>
	<a href="${pageContext.request.contextPath}/servlet/AddPostServlet?mode=web&op=showAddPostUI">发布新的文章</a>
	<a href="${pageContext.request.contextPath}/servlet/AddResourceServlet?mode=web&op=showAddResourceUI">发布新的资源</a>
  </body>
</html>