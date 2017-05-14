<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加地址</title>
</head>
<body>

<div class="container-fluid">
	<div class="row" >
		<div class="col-xs-12 col-sm-4 col-md-4 col-md-offset-4 col-sm-offset-4">
			<sf:form method="POST" modelAttribute="address">
			<div class="form-group">
				<label for="name">送货地址：</label>
				<sf:input path="name" class="form-control" id="name" placeholder="地址"/>
			</div>
			<div class="form-group">
				<label for="phone">联系电话：</label>
				<sf:input path="phone" class="form-control" id="phone" placeholder="电话"/>
			</div>
			<div class="form-group">
				<label for="postcode">邮政编码：</label>
				<sf:input path="postcode" class="form-control" id="postcode" placeholder="邮编"/>
			</div>
			<button type="submit" class="btn btn-default">添加地址</button>
			</sf:form>
		</div>
	</div>
</div>
</body>
</html>