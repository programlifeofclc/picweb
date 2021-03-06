<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>html5</title>
	<link rel="stylesheet" type="text/css" href="/back_js/themes/pepper-grinder/easyui.css">
	<link rel="stylesheet" type="text/css" href="/back_js/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="/back_css/uploadify.css">
	<link rel="stylesheet" type="text/css" href="/back_css/upload.css">
	<script type="text/javascript" src="/back_js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="/back_js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/back_js/easy_clc_v2.js"></script>
	<script type="text/javascript" src="/back_js/jquery.uploadify.min.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$("#menu_tree").tree({
				data:
					[{
					"id" : 1,
					"text" : "后台",
					"children" : [{
									"id" : 3,
									"text" : "图片管理",
									"attributes":{name:"图片管理",url:"/member/img_manager.jsp"}
								},{
									"id" : 4,
									"text" : "主题管理",
									"attributes":{name:"主题管理",url:"/member/theme_manager.jsp"}
								}]
					},{
					"id" : 1,
					"text" : "前台",
					"state" : "closed",
					"children" : [{
									"id" : 5,
									"text" : "页面控制",
									"attributes":{name:"页面控制",url:"/member/page_manager.jsp"}
								}]
					}],
					onClick:function(node){
						openTab(node.attributes);
					}

			});
			
			function openTab(node){
				if(!node || !node.name)return;
				var isexists = $("#main_tab").tabs("exists",node.name);
				if(isexists){
					$("#main_tab").tabs("select",node.name);
					//$("#main_tab").tabs("getSelected").panel("refresh");
				}else{
					if(node.target == "frame"){
						$("#main_tab").tabs("add",{
							title:node.name,
							closable:true,
							content:'<div style="width:100%;height:100%;overflow: hidden;"><iframe scrolling="auto" frameborder="0"  src="' + node.url + '" style="width:100%;height:100%"></iframe></div>',
							loadingMessage:'加载中......'
						});
					}else{
						$("#main_tab").tabs("add",{
							title:node.name,
							closable:true,
							href:node.url,
							loadingMessage:'加载中......'
						});
					}
				}
			}
		});
		
		
	</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north'" style="overflow:hidden;height:50px;background-image:url('/back_img/header_bg.png');background-position:0% 100%">
		<h2 style="color: white;margin-left: 30px;font-weight:bolder; font-family:'YouYuan' ">萌丫头后台管理系统</h2>
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
	<div data-options="region:'south'" style="height:30px;text-align: center;">
		<div style="width: 100%;height: 100%;line-height: 30px;text-align: center;overflow: hidden;">萌丫头系统管理</div>
	</div>
</body>
</html>