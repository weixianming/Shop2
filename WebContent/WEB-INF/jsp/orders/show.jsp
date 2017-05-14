<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
 <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<title>订单详细</title>
</head>
<body>
<div class="container-fluid">
	<div class="col-xs-12 col-md-8 col-md-offset-2">
		<table class="table table-hover table-bordered ">
			<tr><td>商品名称</td><td>数量</td><td>价格</td></tr>
			<c:forEach items="${cartProducts}" var="cartProduct">
				<tr>
					<td>${cartProduct.product.name}</td>
					<td>${cartProduct.number }</td>
					<td>${cartProduct.price }</td>
				</tr>		
			</c:forEach>
		</table>
	</div>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/jquey/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"> </script>
</body>
</html>