<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
<br/>
<table width="80%" align="center" cellpadding="0" cellspacing="1" >
	<tr>
		<td colspan="4" >我收藏的文章</td> 
	</tr>
	<tr  height="30">
		<th>文章标题</th>
		<th>文章种类</th>
		<th>文章内容</th>
		<th>发布时间</th>
		<th>发布者</th>	
		<th>感谢</th>	
		<th>收藏</th>
		<th>图片地址</th>
	</tr>
	<c:forEach items="${posts}" var="i" varStatus="vs">
		<tr height="24" class="${vs.index%2==0?'odd':'even' }">
			<td nowrap="nowrap">${i.postTitle}</td>
			<td nowrap="nowrap" name="kind">${i.kind}</td>
			<td nowrap="nowrap">${i.postText}</td>
			<td nowrap="nowrap" name="postDate">${i.postDate}</td>
			<td nowrap="nowrap" name="owner">${i.owner}</td>
			<td nowrap="nowrap" name="thx"><a href="${pageContext.request.contextPath}/servlet/IncrPostThxServlet?postId=${i.postId}">${i.thxCnt}</a></td>
			<td nowrap="nowrap" name="favorite"><a href="${pageContext.request.contextPath}/servlet/AddFavoritesServlet?mode=web&op=post&postId=${i.postId}">收藏</a></td>
			<td nowrap="nowrap" name="imgUrl">${i.imgUrl}</td>
		</tr>
	</c:forEach>
</table>
  </body>
</html>
