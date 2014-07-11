<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>图片管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<script type="text/javascript">
		(function($){
			function slt(value,rowData,rowIndex){
				var img = "<img style='margin-top:6px;' src='/"+rowData.imgUrl+"/img_32_32.jpg'/>"
				return img;
			}
			
			
			var dfOpts = {
					nowrap:false,
					url:"/file/findImgs.htm",
					columns:[[{field:'imgName',title:'图片名',width:60},
					          {field:'slt',title:'缩略图',width:32,align:'center',formatter:slt},
					          {field:'createTime',title:'时间',width:100,align:'center',formatter:function(v){return v.replace('T',' ');}},
					          {field:'imgUrl',title:'路径',width:100,align:'center'},
					          {field:'imgContext',title:'内容',width:100,align:'center'},
					          {field:'imgUploader',title:'操作人',width:100,align:'center'}
					         ]],
					queryParams:{pp:33}
					
				};
			$("#tt").datagrid_clc(dfOpts);
			
			
			$('#file_upload').uploadify({
				"queueID":"file_upload-queue",
				"multiple":true,
				'queueSizeLimit' : 50,
				"height":30,
				"width":"100%",
				"formData":{},
				"fileTypeDesc":"图片...",
				"fileTypeExts":"*.gif; *.jpg; *.png",
				"fileSizeLimit":"1000K",
				"fileObjName":"uploadFile",
				"buttonText":"选择文件",
				'buttonClass':"myup",
				'auto':false,
				'swf'      : '/member/css/uploadify.swf',
				'uploader' : '/upload/uploadFile.htm',
				'onCancel' : function(file) {
		          //  alert('The file ' + file.name + ' was cancelled.');
		        }
			});
			
			
			
			
		})($);
	
		
		
	</script>
	<style type="text/css">
		#tt td{
				vertical-align:middle;
		}
	</style>
	
	<div class="easyui-layout" style="width: 100%;height: 100%;">
		<div data-options="region:'center'" class="easyui-layout" style="overflow: hidden;">
			<div data-options="region:'center'">
				<table id="tt" >
				
				</table>
			</div>
		</div>
		<div data-options="region:'east'"  style="width:215px;overflow: hidden;" class="easyui-layout">
			<div data-options="region:'north'" style="height:40px;overflow: hidden;">
				<table class='mytabimg'>
					<tr>
						<td>
							<input id="file_upload" name="file_upload" type="file">
						</td>
						<td>
							<input id="start_upload"  value="开始上传" type="button" onclick="$('#file_upload').uploadify('upload','*')" >
						</td>
					</tr>
				</table>
			</div>
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