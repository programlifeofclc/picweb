<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<%
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	%>
	<title>图片管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<script type="text/javascript">
		(function(){
				var dfOpts = {
						nowrap:false,
						url:"/manager/file/findThemes.htm",
						columns:[[{field:'id',title:'ID',width:30,align:'center'},
						          {field:'themeName',title:'主题名',width:250,align:'center'}
						         ]],
						queryParams:{}
					};
				var tab = $("#theme_manager_tt").datagrid_clc(dfOpts);
			
				$("#andTheme").bind("click",function(){
					$("#add_theme_form").form("submit",{
						url:"/manager/file/addTheme.htm",
						onSubmit: function(){  
							return $(this).form("validate");
					    },  
					    success:function(data){
					    	data = $.parseJSON(data);
					    	if(data && data.id)
					    		tab.datagrid("appendRow",data);
					    	else
					    		$.messager.alert('提示:','添加失败!重复');
					    }
					});

					
					
				});
					
				
		 })($);
	</script>
	<div class="easyui-layout" style="width: 100%;height: 100%;">
		<div data-options="region:'center'" class="easyui-layout" style="overflow: hidden;">
			<div data-options="region:'center'">
				<table id="theme_manager_tt">
				
				</table>
			</div>
		</div>
		<div data-options="region:'east'"  style="width:215px;overflow: hidden;" class="easyui-layout">
			<div data-options="region:'center'">
				<form id="add_theme_form" method="post">
					<br/> 
				    <div>  
				        <label for="name">&nbsp;主题名:</label>  
				    	<input name="imgTheme.themeName" data-options="required:true,missingMessage:'不可为空'"  class="easyui-validatebox" />
				    </div>
				    <br/>  
				    <div>  
						<a href="javascript:void(0);" id="andTheme" class="easyui-linkbutton" data-options="iconCls:'icon-add'" style="display:block; margin:0px auto; width:100px;">添加主题</a>
				    </div>  
				</form>
			</div>
		</div>
	</div>
</body>
</html>