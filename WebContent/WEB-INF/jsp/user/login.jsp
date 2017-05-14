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
<title>用户登录</title>
</head>
<body>
<div class="container-fluid" style="height: 450px;">
	<div class="row">
	<div class="col-xs-6 col-md-6 col-md-offset-2"><img src="<%=request.getContextPath()%>/resources/img/timg.jpg" width="300" height="300" class="img-rounded"></div>
	<div class="col-xs-2 col-md-2">
		<form action="login" method="post" >
			<div class="form-group">
				<label class="sr-only" for="username">用户名</label>
				<input placeholder="用户名" id="username" class="form-control" type="text" name="username">
			</div>
			<div class="form-group">
				<label class="sr-only" for="password">密码</label>
				<input placeholder="密码" id="password" class="form-control" type="password" name="password">
			</div>
		<button type="submit" class="btn btn-primary"><strong>登&nbsp;&nbsp;录</strong></button>
		&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn btn-primary" role="button" href="<%=request.getContextPath()%>/user/add">注  册</a>
		</form>
	</div>
	</div>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/jquey/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"> </script>
</body>
</html>