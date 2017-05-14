<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>类型添加</title>
</head>
<body >
<div class="container">
	<div class="col-xs-4 col-sm-4 col-md-4 col-md-offset-4">
		<sf:form method="post" modelAttribute="category">
		<div class="form-group">
			<label for="name">商品类型：</label>
			<sf:input path="name" class="form-control" id="name" placeholder="类型"/>
		</div>
		<button type="submit" class="btn btn-default">添加商品类型</button>
		</sf:form>
	</div>
</div>
</body>
</html>