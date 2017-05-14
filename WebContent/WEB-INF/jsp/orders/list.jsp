<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>你的订单</title>
</head>
<body>
<div class="container">
	<div class="col-xs-12 col-md-8 col-md-offset-2">
		<table class="table table-hover table-bordered ">
			<thead>
				<tr><th>购买时间</th><th>收件人</th><th>地址</th><th>联系电话</th><th>操作</th></tr>
			</thead>
			<tbody>
				<c:forEach items="${orederes}" var="order">
					<tr>
						<td><fmt:formatDate value="${order.buyDate}" pattern="yyyy年MM月dd日 HH:mm:ss"/></td>
						<td>${order.user.nickname }</td>
						<td>${order.address.name }</td>
						<td>${order.address.phone }</td>
						<td><a href="${order.id}/show">订单详细</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>	
</body>
</html>