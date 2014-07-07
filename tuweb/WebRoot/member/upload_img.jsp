<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>上传文件</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

</head>

<body>
	<script type="text/javascript">
		$(function() {
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
		});
	</script>
	
	
	<div class="easyui-layout" style="width: 100%;height: 100%;">
		<div data-options="region:'center'" class="easyui-layout" style="overflow: hidden;">
			<div data-options="region:'center'">
				图片主题:<input class="easyui-validatebox" validType="minLength[5]">
				图片简介:<input class="easyui-validatebox" validType="minLength[5]">
			</div>
			<div data-options="region:'south'" style="height:30px;overflow: hidden;">
				<input id="file_upload" name="file_upload" type="file">
			</div>
		</div>
		<div data-options="region:'east'"  style="width:280px;overflow: hidden;" class="easyui-layout">
			<div data-options="region:'center'">
				<div id="file_upload-queue" 
					class="uploadify-queue" 
					style="width: 100%;overflow:auto;color:#000">
				</div>
			</div>
			<div data-options="region:'south'" style="height:30px;overflow: hidden;">
				<input id="start_upload"  value="开始上传" type="button" onclick="$('#file_upload').uploadify('upload','*')" >
			</div>
		</div>
	</div>
</body>
</html>