<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>图片管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<script type="text/javascript">
		$("ttt").datagrid_clc();
	</script>
	<div class="easyui-layout" style="width: 100%;height: 100%;">
		<div data-options="region:'center'" class="easyui-layout" style="overflow: hidden;">
			<div data-options="region:'center'">
				<table id="ttt" ss="asdf">
					<tr>
						<td>
						</td>
						<td>
						</td>
					</tr>
				</table>
				
			</div>
		</div>
		<div data-options="region:'east'"  style="width:380px;overflow: hidden;" class="easyui-layout">
			<div data-options="region:'center'">
				<div id="file_upload-queue" 
					class="uploadify-queue" 
					style="width: 100%;overflow:auto;color:#000">
				</div>
			</div>
		</div>
	</div>
</body>
</html>