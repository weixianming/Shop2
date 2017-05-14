<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<style type="text/css">
table {
	border-collapse:collapse;
}
table tr td {
	
	border: 1px solid black;
}
</style>
</head>
<body>
	用户名  : ${user.username }<br/>
	用户昵称：${user.nickname }<br/>
	用户类型：<c:if test="${user.type eq 0}">普通用户</c:if>
		   <c:if test="${user.type eq 1 }">管理员</c:if><br/>
	<c:if test="${!empty addresses}">
	<table>
		<tr><td>送货地址</td><td>联系电话</td><td>邮政编码</td><td>操作</td></tr>
		<c:forEach items="${addresses}" var="address">
			<tr>
				<td>${address.name}</td>
				<td>${address.phone}</td>
				<td>${address.postcode}</td>
				<td><a href="<%=request.getContextPath()%>/address/${address.id}/delete">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
</body>
</html>