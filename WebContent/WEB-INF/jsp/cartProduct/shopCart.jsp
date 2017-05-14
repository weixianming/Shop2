<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
</head>
<body>
<div class="container-fluid">
	<div class="col-xs-12 col-md-8 col-md-offset-2 ">
		<table class="table table-hover table-bordered ">
		<tr><td>商品名称</td><td>数量</td><td>价格</td><td colspan="2">操作</td></tr>
		<c:if test="${! empty message}">
			<tr><td colspan="4">${message }</td></tr>
		</c:if>
			<c:forEach items="${shopCart}" var="cartProduct">
				<tr>
					<td>${cartProduct.product.name }</td>
					<td>${cartProduct.number }</td>
					<td>${cartProduct.price }</td>
					<td><a href="${cartProduct.product.id}/delete">删除</a>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="col-xs-2 col-md-2 col-md-offset-9">
	<c:if test="${! empty shopCart}">
		<h3><a class="btn btn-info btn-lg " role="button" href="<%=request.getContextPath()%>/orders/add">下单</a></h3>
	</c:if>
	</div>
	
</div>
</body>
</html>