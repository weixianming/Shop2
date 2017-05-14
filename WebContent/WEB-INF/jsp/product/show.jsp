<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${product.name}</title>
</head>
<body>
<div class="container" style="height: 450px;">
	<div class="row">
		<div class="col-xs-4 col-md-4">
			<img alt="图片无法显示"  class="img-responsive img-thumbnail" src="<%=request.getContextPath() %>/resources/image/${product.img}">
		</div>
		<div class="col-xs-7 col-md-7">
			<p><strong>商品介绍：</strong>${product.intro}</p>
			<p><strong>商品名称：</strong>${product.name }</p>
			<p><strong>商品价格：</strong>${product.price}</p>
			<p><strong>库存数量：</strong><span id="stock" >${product.stock}</span></p><br/>
			<form id="buyform" action="<%=request.getContextPath() %>/cartProduct/add" method="post">
				<div class="form-group">
					<label for="number">购买数量：</label>
					<input type="text" name="number" id="number">
				</div>
				<input type="hidden" name="pid" value="${product.id}">
				<button class="btn btn-primary" type="submit">添加到购物车</button>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
(function(){
	window.onload = init;
	function init(){
		var buyform = document.getElementById("buyform");
		buyform.onsubmit =validate_number;
	}
	
	function validate_number(){
		var stock = document.getElementById("stock");
		var snumber = parseInt(stock.innerHTML);
		if(this.number.value==null||this.number.value==""){
			alert("请输入数量");
			return false;
		}else{
			if(this.number.value>snumber){
				alert("库存不足");
				return false;
			}else{
				return true;
			}
		}
	}
})();
</script>
</body>
</html>