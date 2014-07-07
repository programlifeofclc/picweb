<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>html5</title>
	<link  rel="stylesheet" type="text/css" href="./css/index.css"/>
	<link  rel="stylesheet" type="text/css" href="./css/jquery-ext.css"/>
	
	<script src="./js/jquery-1.11.1.js" type="text/javascript"></script>
	<script src="./js/jquery.mousewheel.js" type="text/javascript"></script>
	<script src="./js/jquery-ext.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(function(){
			var c = $(".context_left_1").cBox({leftDiv2:true,data:[{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/1.jpg",bigsrc:"/tuweb/dataImg/big/1.jpg"},
			     									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/2.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/3.jpg",bigsrc:"/tuweb/dataImg/big/3.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/4.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/3.jpg",bigsrc:"/tuweb/dataImg/big/3.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/1.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/3.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/1.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/4.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/4.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/3.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/1.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/3.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/4.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/2.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/3.jpg",bigsrc:"/tuweb/dataImg/big/1.jpg"},{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/1.jpg",bigsrc:"/tuweb/dataImg/big/1.jpg"},
			     									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/2.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/3.jpg",bigsrc:"/tuweb/dataImg/big/3.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/4.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/3.jpg",bigsrc:"/tuweb/dataImg/big/3.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/1.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/3.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/1.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/4.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/4.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/3.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/1.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/4.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/4.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/3.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/1.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/4.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/4.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/3.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/1.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/4.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/4.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/3.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"},
			    									{title:"标题",text:"我的主题",src:"/tuweb/dataImg/small/2.jpg",bigsrc:"/tuweb/dataImg/big/4.jpg"}]
			});
			
		 
		})
	
	</script>
	
</head>
<body style="background:#DDD">
	<div class="logo">
		萌丫图
	
	</div>
	
	<div class="daohang_outer">
		<div class="daohang_inner">
			<ul class="daohang_ul">
				<li> 首页 </li>
				<li> 设计欣赏 </li>
				<li> 文作 </li>
				<li> 搜索 </li>
			</ul>
		</div>
	</div>
	<div class="context">
		<div class="context_text" id="context_text" >
		
		</div>
		<div class="context_up" id="context_up" >
			<input type="text" name="search" class="search"><input type="text"  name="search" class="search_button" onclick="this.blur();alert(1);" >
		</div>
		
		<div class="context_left_1" id="context_left_1" style="float: left;"></div>
		<div class="context_right_1" id="context_right_1"  >
		
		</div>
		<div class="clear_div"></div>
		<div class="context_text" style="margin-top: 3px;" >
		
		</div>
		
	</div>
	

 
	</div>

</body>
</html>