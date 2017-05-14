$(function(){
	var $anvlfteb=$('#anvlfteb'),
		$posbox=$anvlfteb.find('div.posbox'),
		$seledbox=$("#seledbox"),
		anvjson={
			bbs:'<a href="#">用户列表</a>'+
				'<a href="#">用户列表</a>'+
				'<a href="#">用户列表</a>',
        	news:'<a href="#">用户列表</a>'+
				'<a href="#">用户列表</a>'+
				'<a href="#">用户列表</a>'+
				'<a href="#">用户列表</a>'+
				'<a href="#">用户列表</a>',
        	post:'<a href="#">用户列表</a>'+
				'<a href="#">用户列表</a>'+
				'<a href="#">用户列表</a>'+
				'<a href="#">用户列表</a>',
        	youhui:'<a href="/Shop2/product/list">商品列表</a>'+
				'<a href="/Shop2/product/add">商品添加</a>',
        	other:'<a href="/Shop2/category/list">类型列表</a>'+
				'<a href="/Shop2/category/add">类型添加</a>',
			store:'<a href="/Shop2/user/list">用户列表</a>'+
				'<a href="/Shop2/user/add">用户添加</a>'+
				'<a href="/Shop2/user/show">个人信息</a>'
		};
		 

		$posbox.mouseover(function(){
			var i=$(this).index();
			$(this).addClass("anvh").siblings().removeClass("anvh");
			var selec=$(this).attr("selec");
			if($seledbox.is(":hidden")){
				$seledbox.show().css("left",64*i+1).html("<div>"+anvjson[selec]+"</div>")
			}else{
				$seledbox.stop().animate({left:64*i+1},200,function(){
					$("#seledbox").html("<div>"+anvjson[selec]+"</div>")
				})
			}
		});
		$anvlfteb.mouseleave(function(){
			$seledbox.hide();
			$posbox.removeClass("anvh");
		})
})
