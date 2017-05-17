<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<title><decorator:title default="欢迎使用网上商城系统"/></title>
<decorator:head/>
</head>
<body >
	<nav class="navbar navbar-default">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">
			<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
		  </a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-navbar-collapse-1">
	      <ul class="nav navbar-nav">
		   <li class="dropdown">
	          <a href="<%=request.getContextPath()%>/product/list" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">商品<span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="<%=request.getContextPath()%>/product/list">商品列表</a></li>
	            <c:if test="${loginUser.type eq 1 }">
	          	 	 <li><a href="<%=request.getContextPath()%>/product/add">商品添加</a></li>
	           		 <li><a href="#">商品管理</a></li>
	            </c:if>
	            <li role="separator" class="divider"></li>
	            <li><a href="<%=request.getContextPath()%>/category/list">商品类型</a></li>
	            <c:if test="${loginUser.type eq 1 }">
					<li><a href="<%=request.getContextPath()%>/category/add">类型添加</a></li>
				</c:if>
	          </ul>
	        </li>
			<li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">用户<span class="caret"></span></a>
	          <ul class="dropdown-menu">
		        <c:if test="${loginUser.type eq 1 }">
		            <li><a href="<%=request.getContextPath()%>/user/list">用户列表</a></li>
		        </c:if>
		        <c:if test="${!empty loginUser}">
		       		<li><a href="<%=request.getContextPath()%>/orders/list">我的订单</a></li>
		        </c:if>
	            <li><a href="<%=request.getContextPath()%>/user/show">个人信息</a></li>
	            <li><a href="<%=request.getContextPath()%>/address/add">添加地址</a></li>
	          </ul>
	        </li>
	  
	      </ul>
	      <form class="navbar-form navbar-left">
	        <div class="form-group">
	          <input type="text" class="form-control" placeholder="商品名或类型">
	        </div>
	        <button type="submit" class="btn btn-default">搜索商品</button>
	      </form>
	      <ul class="nav navbar-nav navbar-right">
	      	<c:choose>
	      		<c:when test="${empty loginUser}">
	        		<li><a href="<%=request.getContextPath()%>/user/login">登录</a></li>
	      		</c:when>
	      		<c:otherwise>
	      			<li><p class="navbar-text">欢迎您${loginUser.nickname}<a href="<%=request.getContextPath()%>/user/loginOut">注销</a></p></li>
	      		</c:otherwise>
	      	</c:choose>
			<li><a href="<%=request.getContextPath()%>/cartProduct/shopCart">购物车</a></li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	</nav>
	<h3 align="center"><decorator:title default="用户管理"/></h3><br>
	<decorator:body/>
<div class="footer">
	<p class="text-center">Copyright @2016-2017</p>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/jquery/jquery-3.2.0.min.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"> </script>
</body>
</html>