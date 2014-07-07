<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>html5</title>
	<link  rel="stylesheet" type="text/css" href="./css/book.css"/>

	<script src="./js/jquery-1.11.1.js" type="text/javascript"></script>
	<script src="./js/jquery.mousewheel.js" type="text/javascript"></script>
	<script src="./js/jquery-ext.js" type="text/javascript"></script>
	<script type="text/javascript">
		 
	
	</script>
	
</head>
<body style="background:#EEE">
	<div class="top"></div>
	
	<div>
		<div class="top_ner"></div>
		<div class="logo">
		<img id="logoimg" alt="华夏书峰网" src="./img/logo.png" >
		<span>华夏书峰网</span>
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
		<div class="daohang_small" id="daohang_small" >
			<a href="">首页</a>|<a href="">设计欣赏</a>|<a href="">文作</a>|<a href="">搜索</a>
		</div>
		<div class="sousuo_small" >
			<form action="" style="float: left;width: 390px;height:30px">
				<select class="sousuo_type">
					<option>作者</option>
					<option>书名</option>
				</select><input type="text" class="sousuo_text" /><input type="button" value=" 搜  书 " class="sousuo_button"  />
			</form>
			<div style="float: left;width: 800px;height:30px;line-height: 30px;font-size: 12px;">
				热门书籍:<a href="">诛仙</a>
			</div>
		</div>
		<div class="context_one" style="height:40px;background: #999">
		
		</div>
		
		<div class="context_one">
			 <div class="context_one_1">
			 	<div>
			 		<input type="button" class="context_one_tuijian" value="本周强推" >
			 		<input type="button" class="context_one_tuijian backgrd" value="上周强推" onclick="$($('.context_one_tuijian_con')[1]).show();$($('.context_one_tuijian_con')[0]).hide()">
			 	</div>
			 	<div>
			 		<ul class="context_one_tuijian_con">
			 			<li>[玄幻]诛仙</li>
			 			<li>[武侠]搜神记</li>
			 			<li>[玄幻]诛仙</li>
			 			<li>[武侠]搜神记</li>
			 			<li>[玄幻]诛仙</li>
			 			<li>[玄幻]诛仙</li>
			 			<li>[武侠]搜神记</li>
			 		</ul>
			 		<ul class="context_one_tuijian_con" style="display: none">
			 			<li>[武侠]搜神记</li>
			 			<li>[武侠]搜神记</li>
			 			<li>[武侠]诛仙</li>
			 			<li>[武侠]搜神记</li>
			 			<li>[武侠]诛仙</li>
			 			<li>[武侠]搜神记</li>
			 			<li>[武侠]诛仙</li>
			 		</ul>
			 	</div>
			 </div>
		</div>
	</div>

</body>
</html>