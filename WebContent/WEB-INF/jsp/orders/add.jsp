<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>下单</title>
</head>
<body>
<div class="container">
	<div class="col-xs-12 col-md-6 col-md-offset-3 ">
	<table class="table table-hover table-bordered ">
		<thead>
			<tr><th>商品名称</th><th>数量</th><th>价格</th></tr>
		</thead>
		<tbody>
			<c:forEach items="${cartProducts}" var="cartProduct">
				<tr>
					<td>${cartProduct.product.name }</td>
					<td>${cartProduct.number }</td>
					<td>${cartProduct.price }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<label>一共：${totalPrice}元</label>
	</div>
	<div class="col-xs-12 col-md-6 col-md-offset-3">
		<sf:form method="POST" modelAttribute="Orders" class="form-inline">
			
			<input type="hidden" name="price" value="${totalPrice}">
			<input type="hidden" name="status" value="1">
			<div class="form-group">
				<label for="a_id">送货地址</label>
				<select id="a_id" name="a_id" class="form-control">
				<c:forEach items="${addresses}" var="address">
					<option value="${address.id }">${address.name}</option>
				</c:forEach>
				</select>
			</div>
			<button class="btn btn-primary" type="submit">购买</button>
		</sf:form>
	</div>
</div>
</body>
</html>