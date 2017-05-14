<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
<div class="container-fluid" style="height: 450px;">
	<div class="row">
		<div class="col-xs-12 col-md-8 col-md-offset-2 ">
		<table class="table table-bordered table-hover">
			<thead>
			<tr><th>用户名</th><th>用户昵称</th><th>用户类型</th><th colspan="2">操作</th></tr>
			</thead>
			<tbody>
			<c:forEach items="${users}" var="user">
			<tr>
				<td><a href="${user.id}/show">${user.username }</a></td>
				<td>${user.nickname }</td>
				<td>
				<c:choose>
					<c:when test="${user.type eq 0 }">普通用户</c:when>
					<c:when test="${user.type eq 1 }">管理员</c:when>
				</c:choose>
				</td>
				<td><a href="${user.id}/delete">删除</a></td>
				<td><a href="${user.id}/update">更新</a></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
</div>
</body>
</html>