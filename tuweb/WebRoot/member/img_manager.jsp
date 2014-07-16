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
	
		(function($){
			function slt(value,rowData,rowIndex){
				var img = "<img style='margin-top:6px;' src='/"+rowData.imgUrl+"/img_32_32.jpg'/>"
				return img;
			}
			
			var dfOpts = {
					singleSelect:true,
					idField: 'id',
					striped:true,
					nowrap:false,
					remoteSort:false,
					url:"/manager/file/findImgs.htm",
					columns:[[{field:'id',title:'ID',width:30,checkbox:true},
					          {field:'imgName',title:'图片名',width:70,sortable:true},
					          {field:'slt',title:'缩略图',width:32,align:'center',formatter:slt},
					          {field:'createTime',title:'时间',width:70,align:'center',formatter:function(v){return v.substr(0,9);}},
					          {field:'imgUrl',title:'路径',width:100,align:'center'},
					          {field:'themeIds',title:'主题',width:100,align:'center',
					          		editor:{
					          			type:'combobox',
					          			options:{
					          				value:"",
					          				url:'/manager/file/findThemesComboBox.htm',
					          				valueField:'themeName',
					          				textField:'themeName',
					          				multiple:true,
					          				editable:false,
					          				onLoadSuccess: function(val){
					          	              var vs = $(this).combobox("getValues");
					          	              if(vs==""){return;}
					          	              $(this).combobox("clear");
					          	              vs = (vs+"").split(",");
					          	          	  $(this).combobox("setValues",vs);
					          	            }
					          			}
					          		}
					          		
					          },
					          {field:'keyWord',title:'关键字',width:100,align:'center',editor:"text"},
					          {field:'imgContext',title:'内容',width:100,align:'center',editor:'textarea'},
					          {field:'imgUploader',title:'操作人',width:30,align:'center'}
					         ]],
					queryParams:{},
					toolbar:[{
						text:'编辑选中',
						handler:function(){
							var row = $("#tt").datagrid("getSelected");
							var i = $("#tt").datagrid("getRowIndex",row);
							$("#tt").datagrid("beginEdit",i);
						}
					},'-',{
						text:'保存编辑',
						handler:function(){
							var row = $("#tt").datagrid("getSelected");
							var i = $("#tt").datagrid("getRowIndex",row);
							$("#tt").datagrid("endEdit",i);
							var changarr = $("#tt").datagrid("getChanges","updated");
							for(var i = 0; i < changarr.length;i++){
								var img = changarr[i];
								var dat = {
											"totoImgs.id":img.id,
											"totoImgs.imgContext":img.imgContext,
											"totoImgs.keyWord":img.keyWord,
											"totoImgs.themeIds":img.themeIds
											};
								
								$.ajax({
									async:false,
									url:"/manager/file/updateImg.htm",
									data:dat,
									success:function(data){
										if($.trim(data)!="success"){
											$.messager.alert('提示:','保存失败!');
										}
									},
									dataType:"text",
									type:"POST"
								});
							}
							$("#tt").datagrid("acceptChanges");
						}
					},'-',{
						text:'取消编辑',
						handler:function(){
							var row = $("#tt").datagrid("getSelected");
							var i = $("#tt").datagrid("getRowIndex",row);
							$("#tt").datagrid("cancelEdit",i);
						}
					}]
				};
			$("#tt").datagrid_clc(dfOpts);
			
			
			
			$('#file_upload').uploadify({
				"queueID":"file_upload-queue",
				"multiple":true,
				'queueSizeLimit' : 50,
				"height":30,
				"width":"100%",
				"formData":{"a":"2"},
				"fileTypeDesc":"图片...",
				"fileTypeExts":"*.gif; *.jpg; *.png",
				"fileSizeLimit":"1000K",
				"fileObjName":"uploadFile",
				"buttonText":"选择文件",
				'buttonClass':"myup",
				'auto':false,
				'swf'      : '/back_css/uploadify.swf',
				'uploader' : '/manager/upload/uploadFile.htm',
				'onCancel' : function(file) {}
			});
			
			$("#start_upload").click(function(e){
				var val = $("#themecom").combobox("getValues");
				val = val.toString();
				if(val==""){
					$.messager.alert('提示:','请选择主题');
					return;
				}
				$('#file_upload').uploadify('settings','formData',{themeIds:val})
				$('#file_upload').uploadify('upload','*');
			})
			
			
		})($);
		
	</script>
	
	<div class="easyui-layout" style="width: 100%;height: 100%;">
		<div data-options="region:'center'" class="easyui-layout" style="overflow: hidden;">
			<div data-options="region:'center'">
				<table id="tt" >
				</table>
			</div>
		</div>
		<div data-options="region:'east'"  style="width:215px;overflow: hidden;" class="easyui-layout">
			<div data-options="region:'north'" style="height:80px;overflow: hidden;">
				<table class='mytabimg'>
					<tr>
						<td>
							<input id="file_upload" name="file_upload" type="file">
						</td>
						<td>
							<input id="start_upload"  value="开始上传" type="button" >
						</td>
					</tr>
					<tr>					
						<td colspan="2" style="text-align: center;">
								<span>主题:</span><input id="themecom" style="width:160px" class="easyui-combobox" name="themes" data-options="url:'/manager/file/findThemesComboBox.htm',valueField:'themeName',textField:'themeName',multiple:true,editable:false">
						</td>
					</tr>
				</table>
			</div>
			<div data-options="region:'center'">
				<div id="file_upload-queue" class="uploadify-queue"  style="width: 100%;overflow:auto;color:#000">
				</div>
			</div>
		</div>
	</div>
</body>
</html>