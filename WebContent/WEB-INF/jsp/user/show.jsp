<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
</head>
<body>
<div class="container-fluid">
<div class="row">
	<div class="col-xs-12 col-md-6 col-md-offset-3">
	<p><strong>用户名  :</strong> ${user.username }</p>
	<p><strong>用户昵称：</strong>${user.nickname }</p>
	<p><strong>用户类型：</strong><c:if test="${user.type eq 0}">普通用户</c:if>
		   					   <c:if test="${user.type eq 1 }">管理员</c:if></p>
	<c:if test="${!empty addresses}">
	<table class="table table-hover table-bordered ">
	<thead>
		<tr><th>送货地址</th><th>联系电话</th><th>邮政编码</th></tr>
	</thead>
	<tbody>
		<c:forEach items="${addresses}" var="address">
			<tr>
				<td><address>${address.name}</address></td>
				<td>${address.phone}</td>
				<td>${address.postcode}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	</c:if>
	</div>
</div>
</div>
</body>
</html>