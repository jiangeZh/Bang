<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
<br/>
    <form enctype="multipart/form-data" action="${pageContext.request.contextPath}/servlet/AddResourceServlet?mode=web&op=addResource" method="post" >
    <h2 align="center">发布新资源</h2>
    	<table border="1" width="438" align="center">
    		<tr>
    			<td>资源名称</td>
    			<td>
    				<input type="text" name="resName"/>
    			</td>
    		</tr>
    		<tr>
    			<td>资源描述</td>
    			<td>
    				<textarea rows="5" cols="45" name="resDesc"></textarea>
    			</td>
    		</tr>
    		<tr>
    			<td>资源上传</td>
    			<td>
    				<input type="file" id="uploadfile" name="uploadfile" />
    			</td>
    		</tr>
    		<tr>
    			<td>资源分类</td>
    			<td>
    				<select name="kindId">
    					<c:forEach items="${kinds}" var="k">
    						<option value="${k.id }">${k.kindName}</option>
    					</c:forEach>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td>加密</td>
    			<td>
    				<input name="isEncrypt" type="checkbox"/>
					<input type="text" name="password"/>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<input type="submit" value="添加"/>
    			</td>
    		</tr>
    	</table>
  </body>
</html>
