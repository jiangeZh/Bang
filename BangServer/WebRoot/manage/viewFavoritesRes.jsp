<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
<br/>
<table width="80%" align="center" cellpadding="0" cellspacing="1" >
	<tr>
		<td colspan="4" >我收藏的资源</td> 
	</tr>
	<tr  height="30">
		<th>资源名</th>
		<th>资源种类</th>
		<th>资源url</th>
		<th>资源大小</th>
		<th>上传时间</th>
		<th>上传者</th>	
		<th>操作</th>	
	</tr>
	<c:forEach items="${resources}" var="i" varStatus="vs">
		<tr height="24" class="${vs.index%2==0?'odd':'even' }">
			<td nowrap="nowrap">${i.name}</td>
			<td nowrap="nowrap" name="kind">${i.kind}</td>
			<td nowrap="nowrap">${i.url}</td>
			<td nowrap="nowrap" name="size">${i.size}</td>
			<td nowrap="nowrap" name="uploadDate">${i.uploadDate}</td>
			<td nowrap="nowrap" name="owner">${i.owner}</td>
			<td nowrap="nowrap"><a href="${pageContext.request.contextPath}/servlet/DownloadFileServlet?filename=${i.name}&url=${i.url}">下载</a></td>
		</tr>
	</c:forEach>
</table>
  </body>
</html>
