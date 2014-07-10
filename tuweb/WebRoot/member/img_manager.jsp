<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>图片管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<script type="text/javascript">
		$("#tt").datagrid_clc({
			data:{"total":239,"rows":[{"code":"001","name":"Name 1","addr":"Address 11","col4":"col4 data"},{"code":"002","name":"Name 2","addr":"Address 13","col4":"col4 data"},{"code":"003","name":"Name 3","addr":"Address 87","col4":"col4 data"}]},
			columns:[[{field:'code',title:'Code',width:100},
			          {field:'name',title:'Name',width:100},
			          {field:'price',title:'Price',width:100,align:'right'}
			         ]] 
		}).addPagination({});
		
	</script>
	<div class="easyui-layout" style="width: 100%;height: 100%;">
		<div data-options="region:'center'" class="easyui-layout" style="overflow: hidden;">
			<div data-options="region:'center'">
				<table id="tt" style="width: 100%;height: 100%">
				
				</table>
			</div>
		</div>
		<div data-options="region:'east'"  style="width:280px;overflow: hidden;" class="easyui-layout">
			<div data-options="region:'center'">
			</div>
		</div>
	</div>
</body>
</html>