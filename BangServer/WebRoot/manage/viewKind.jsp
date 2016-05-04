<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/manage/header.jsp"%>
<br/>
<table width="80%" align="center" cellpadding="0" cellspacing="1" >
	<tr>
		<td colspan="4" >所有流拍的物品</td> 
	</tr>
	<tr  height="30">
		<th>种类名</th>
		<th>种类描述</th>
	</tr>
	<c:forEach items="${kinds}" var="k" varStatus="vs">
		<tr height="24" class="${vs.index%2==0?'odd':'even' }">
			<td nowrap="nowrap">${k.kindName}</td>
			<td nowrap="nowrap">${k.kindDesc}</td>
		</tr>
	</c:forEach>
</table>
  </body>
</html>
