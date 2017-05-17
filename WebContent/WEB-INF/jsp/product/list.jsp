<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html><html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
</head>
<body>
<div class="container" style="600px">
<div class="row">
	<div class="col-xs-2 col-md-2">
		<div >
			<ul class="nav nav-pills nav-stacked">
				<li><span>商品类型</span></li>
				<li>
					<a href="<%=request.getContextPath()%>/product/list">ALL</a>
				</li>
				<c:forEach items="${categorys}" var="category">
					<li class="liContent">
						<a href="<%=request.getContextPath()%>/product/${category.id}/list">${category.name }</a>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="col-xs-8 col-md-8 col-md-offset-1">
		<div class="row" style="height: 550px;">
			<c:forEach items="${pages.datas}" var="product">
				<div class="col-xs-6 col-md-3">
				<a class="thumbuail" href="<%=request.getContextPath()%>/product/${product.id}/show">
				<img width="170px" height="150px" alt="图像无法显示" src="<%=request.getContextPath() %>/resources/image/${product.img}">
				</a>
				<a href="<%=request.getContextPath()%>/product/${product.id}/show">${product.name}</a><br/>
				<span>${product.price }</span>
				</div>
			</c:forEach>
		</div>
		<jsp:include page="/inc/pager.jsp">
			<jsp:param value="list" name="url" />
			<jsp:param value="${pages.totalRecord}" name="items" />
		</jsp:include>
	</div>
	</div>
</div>
</body>
</html>