<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
<br/>
    <form action="${pageContext.request.contextPath}/servlet/AddKindServlet?mode=web" method="post" >
    	<table border="1" width="438" align="center">
    		<tr>
    			<td>种类名称</td>
    			<td>
    				<input type="text" name="kindName"/>
    			</td>
    		</tr>
    		<tr>
    			<td>种类描述</td>
    			<td>
    				<textarea rows="5" cols="45" name="kindDesc"></textarea>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<input type="submit" value="保存"/>
    			</td>
    		</tr>
    	</table>
  </body>
</html>
