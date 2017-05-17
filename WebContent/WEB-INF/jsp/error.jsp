<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>异常信息</title>
</head>
<body>
<div class="container" style="height: 450px;">
	<h2 class="text-center">${exception.message }</h2>

	<h2 class="text-center"><span id="times">3</span>秒后自动跳转.....</h2>
	
</div>
<script type="text/javascript">
	var i = 3;				
	var interval;
	interval = self.setInterval("fun()", 1000);
	
	function fun(){
		if(i==0){
			clearInterval(interval);		
		}
		document.getElementById("times").innerHTML = i;
		i--;
	}
	
</script>
</body>
</html>