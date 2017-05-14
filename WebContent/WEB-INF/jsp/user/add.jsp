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
<title>用户注册</title>
</head>
<body >
<div class="container-fluid" style="height: 450px;">
	<div class="row">
		<div class="col-xs-6 col-md-6 col-md-offset-2">
			<img src="<%=request.getContextPath()%>/resources/img/timg.jpg" width="300" height="300" class="img-rounded">
		</div>
		<div class="col-xs-2 col-md-2">
			<sf:form method="post" modelAttribute="user">
			<input type="hidden" name="type" value="0"><br/>
				<div class="form-group">
					<label class="sr-only" for="username">用户名</label>
					<input placeholder="用户名" id="username" class="form-control" type="text" name="username">
					<sf:errors path="username"></sf:errors>
				</div>
				<div class="form-group">
					<label class="sr-only" for="password">密码</label>
					<input placeholder="密码" id="password" class="form-control" type="password" name="password">
					<sf:errors path="password"></sf:errors>
				</div>
				<div class="form-group">
					<label class="sr-only" for="nickname">用户昵称</label>
					<input placeholder="昵称" id="nickname" class="form-control" type="text" name="nickname">
					<sf:errors path="nickname"></sf:errors>
				</div>
				<button class="btn btn-primary" type="submit">注  册</button>
			</sf:form>
		</div>
	</div>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/jquey/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"> </script>
</body>
</html>