<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>html5</title>
	<link rel="stylesheet" type="text/css" href="/member/js/themes/dark-hive/easyui.css">
	<link rel="stylesheet" type="text/css" href="/member/js/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="/member/css/uploadify.css">
	<link rel="stylesheet" type="text/css" href="/member/css/upload.css">

	
	<script type="text/javascript" src="/member/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="/member/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/member/js/jquery.uploadify.min.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$("#menu_tree").tree({
				data:
					[{
					"id" : 1,
					"text" : "后台",
					"children" : [{
									"id" : 2,
									"text" : "上传图片",
									"attributes":{name:"上传图片",url:"/member/upload_img.jsp"}
								},{
									"id" : 3,
									"text" : "功能2"
								}]
					},{
					"id" : 1,
					"text" : "前台",
					"state" : "closed",
					"children" : [{
									"id" : "j1",
									"text" : "Java"
								},{
									"id" : "j2",
									"text" : "C#"
								}]
					}],
					onClick:function(node){
						openTab(node.attributes);
					}

			});
			
			function openTab(node){
				var isexists = $("#main_tab").tabs("exists",node.name);
				if(isexists){
					$("#main_tab").tabs("select",node.name);
				}else{
					$("#main_tab").tabs("add",{
						title:node.name,
						closable:true,
						href:node.url
					});
				}
			}
		});
		
		
	</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north'" style="overflow:hidden;height:50px;background-image:url('/member/img/header_bg.png');background-position:0% 100%">
		<h2 style="color: white;margin-left: 30px;font-weight:bolder; font-family:'YouYuan' ">萌丫头后台管理系统</h2>
	</div>
	<div data-options="region:'south'" style="height:30px;background:#102A48;text-align: center;line-height: 30px;color:white;">
		黑色经典
	</div>
	
	<div data-options="region:'west'" title="菜单管理" style="width:240px;padding1:1px;overflow:hidden;">
		<ul id="menu_tree">
		</ul>
	</div>
	<div data-options="region:'center'"   style="overflow:hidden;">
		<div id="main_tab" class="easyui-tabs" data-options="fit:true,border:false">
			<div title="欢迎页" style="padding:20px;overflow:hidden;"> 
				 欢迎
			</div>
		</div>
	</div>
	</div>
</body>
</html>