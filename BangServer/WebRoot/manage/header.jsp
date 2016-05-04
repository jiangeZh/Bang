<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>资源库后台管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
  </head>
  
  <body>
    	<br/><br/>
    	<h1>资源库后台管理</h1>
    	<br/><br/>
    	<a href="${pageContext.request.contextPath}/servlet/ViewPostServlet?mode=web">校友圈</a>
    	<a href="${pageContext.request.contextPath}/servlet/ViewResourceServlet?mode=web">资源库</a>
		<a href="${pageContext.request.contextPath}/manage/publish.jsp">发布</a>
    	<a href="${pageContext.request.contextPath}/servlet/ViewUserServlet?mode=web&op=owner">我</a>
    	<br/>