<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<title>商品添加</title>
</head>
<body >
<div class="container" style="height: 450px;">
	<div class="col-xs-6 col-sm-6 col-md-6 col-md-offset-3">
		<sf:form class="form-horizontal" method="post" modelAttribute="product" enctype="multipart/form-data">
		<div class="form-group">
			<label for="name" class="col-sm-4 control-label">商品名称：</label>
			<div class="col-sm-8">
			<sf:input path="name" class="form-control" id="name" placeholder="名称"/>
			</div>
		</div>
		<div class="form-group">
			<label for="price" class="col-sm-4 control-label">商品价格：</label>
			<div class="col-sm-8">
				<div class="input-group">
				<div class="input-group-addon">￥</div>
				<sf:input path="price" class="form-control" id="price" placeholder="价格"/>
				</div>
			</div>
		</div>
		<div class="form-group" >
			<label for="intro" class="col-sm-4 control-label">商品介绍：</label>
			<div class="col-sm-8">
			<sf:input path="intro" class="form-control" id="intro" placeholder="介绍"/>
			</div>
		</div>
		<div class="form-group">
			<label for="stock" class="col-sm-4 control-label">商品库存：</label>
			<div class="col-sm-8">
			<sf:input path="stock" class="form-control" id="stock" placeholder="库存"/>
			</div>
		</div>
		<div class="form-group">
			<label for="status" class="col-sm-4 control-label">商品状态：</label>
			<div class="col-sm-8">
				<sf:select path="status" class="form-control" id="status">
					<sf:option value="1">可购买商品</sf:option>
					<sf:option value="-1">下架商品</sf:option>
				</sf:select>
			</div>
		</div>
		<div class="form-group" >
			<label for="category_id" class="col-sm-4 control-label">商品类型：</label>
			<div class="col-sm-8">
			<sf:select path="category.id" id="category_id" items="${categorys}" itemLabel="name" itemValue="id"/>
			</div>
		</div>
		<div class="form-group">
			<label for="file" class="col-sm-4 control-label">图片：</label>
			<div class="col-sm-8">
			<input type="file" name="image" id="file">
			</div>
		</div>
		<div class="col-sm-offset-4 col-sm-8">
		<button type="submit" class="btn btn-primary">添 加 商 品</button>
		</div>
		</sf:form>
	</div>
</div>
</body>
</html>