<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品类型</title>
</head>
<body>
<div class="container">
	<div class="col-xs-12 col-md-6 col-md-offset-3 ">
		<table class="table table-hover table-bordered ">
			<tr><td>商品类型</td><td colspan="2">操作</td></tr>
			<c:forEach items="${categorys}" var="category">
			<tr>
				<td>${category.name }</td>
				<td><a href="${category.id}/delete">删除</a></td>
			</tr>
			</c:forEach>
			<c:if test="${loginUser.type eq 1}">
			<tr style="text-align: center;">
				<td colspan="2">
					<a style="text-decoration: none;" href="add">添加商品类型</a>
				</td>
			</tr>
			</c:if>
		</table>
	</div>
</div>
</body>
</html>