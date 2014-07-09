//替换提示确定和取消按钮
$.extend($.messager.defaults,{  
    ok:"确定",  
    cancel:"取消"  
}); 

$.clcbug = false;

$.extend($.fn.calendar.defaults,{
	weeks:["日","一","二","三","四","五","六"],
	months:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]
});

$.extend($.fn.datebox.defaults,{
	formatter:function(date){
	      var y = date.getFullYear();
	      var m = date.getMonth()+1;
	      var d = date.getDate();
	      return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	  }
});

$.extend({
	//变量
	resizeTimer:null,
	/**
	 * 监听窗口变化方法
	 * @param win window
	 * @param func 函数
	 */
	winResize : function(win,func){
		$(win).resize(function() {
			if($.resizeTimer){
				clearTimeout($.resizeTimer);
			}
			$.resizeTimer = setTimeout(func, 500);
		});
	},
	/**
	 * 自己定义的一些窗口变化时候需要执行的操作
	 */
	refreshWindows:function(){
		//$("#mytabs").tabs('getSelected').find("div[id$='_initLay']").layout(); 
	},
	//当树形使用简单数据类型时候使用
	convert : function(rows,id,parentId) {
		function exists(rows, parentId) {
			if(parentId == "" || parentId == null){
				parentId = "clc_null";
			}
			for ( var i = 0; i < rows.length; i++) {
				if (rows[i][id] == parentId)
					return true;
			}
			return false;
		}

		var nodes = [];
		// 得到顶层节点
		for ( var i = 0; i < rows.length; i++) {
			
			var row = rows[i];
			if(rows[i]['checked']=='true'){
				rows[i]['checked']=true;
			}else if(rows[i]['checked']=='false'){
				rows[i]['checked']=false;
			}
			if (!exists(rows, row[parentId])) {
				nodes.push(row);
			}
		}
		var toDo = [];
		for ( var i = 0; i < nodes.length; i++) {
			toDo.push(nodes[i]);
		}
		while (toDo.length) {
			var node = toDo.shift(); // 父节点
			// 得到子节点
			for ( var i = 0; i < rows.length; i++) {
				var row = rows[i];
				if (row[parentId] == node[id]) {
					var child = row;
					if (node.children) {
						node.children.push(child);
					//	node.state = "closed";
					} else {
						node.children = [ child ];
					//	node.state = "closed";
					}
				//	alert(child.id+"---"+child.checked)
					toDo.push(child);
				}
			}
		}
		for(var g=0;g<nodes.length;g++){
			//alert(nodes[g].checked+"---")
		}
		return nodes;
	},
	/**
	 * 
	 * @param dataGridID  table的id带#号
	 * @param setting dataGrid参数
	 * @param paginationID 分页参数
	 * @return {dataGrid:$(dataGridID),pagination:$(paginationID))}
	 */
	easyUi_Datagrid:function(dataGridID,dataGridsetting,paginationID,paginationSetting){
		if(!dataGridID){
			return false;
		}
		//表格配置
		var defaultOptions = {
			 	fit:true,
                fitColumns:true,
                nowrap: true,
                striped:true,  
                singleSelect:true,
                rownumbers:true,
                loadMsg:" 加载中.... ",
               	loadFilter:function(data){
               		//当加载完成数据后显示分页工具条
               		if(paginationID){
               			initPagination1504(data.counts , data.pageSize , data.pageNumber);
               		}
               		data.total = data.rows.length;
               		return data;
               	}
            };
		
		
		$.extend(defaultOptions,dataGridsetting?dataGridsetting:{});
		
		var $dataGrid = $(dataGridID);
		var $pagination = paginationID?$(paginationID):null;
		
		//初始化表格
		$dataGrid.datagrid(defaultOptions);  
		
		function initPagination1504(counts,pageSize,pageNumber){
			var defaultPaginaOptions = {
					total:counts,
       			    pageSize:pageSize,
	   			  	pageList:[10,30,50],
	   			 	showRefresh:false,
	   			 	beforePageText:'页数',
	   			    afterPageText:'共{pages}',
	   			    displayMsg:'从{from} 到 {to}，共 {total}条',
	   			 		onSelectPage:function(pages, pageSize){
	   			 			var queryParams = $dataGrid.datagrid("options").queryParams;
	   			 			//合并查找对象
	   			 			$.extend(queryParams, {pageSize:pageSize,pageNumber:pages});
	   			 			//加载指定页面数据
	   			 			$dataGrid.datagrid('load',queryParams);
	   			 		}
	   				};
			$.extend(defaultPaginaOptions,paginationSetting?paginationSetting:{});
			
			if(pageNumber == 1 || pageNumber == 0){
				defaultPaginaOptions.pageNumber = 1;
			}
			$pagination.pagination(defaultPaginaOptions);
		}
		return {dataGrid:$dataGrid,pagination:$pagination};
	},
	/**
	 * * 树形表格
	 * @param treeGridID id带#号
	 * @param treeGridSetting 设置{}
	 * @param simpleDataBoolean 是否使用简单数据类型 boolean类型,true 使用简单数据类型
	 * @param dataId 简单数据类型中的主键列
	 * @param dataFatherId 简单数据类型中的指向父键列
	 */
	easyUi_Treegrid:function(treeGridID,treeGridSetting,simpleDataBoolean,dataId,dataFatherId){
		var defaultSetting = {
			  	fit:true,
		        fitColumns:true,
		        nowrap: true,
		        striped:true,  
		        singleSelect:true,
		        rownumbers:true,
		       	loadMsg:" 加载中.... ",
		        loadFilter : function(rows) {
		        	 	//return [{"state":"closed","id":0,"createTime":"2013-09","updateOperator":"clc","createOperator":"clc","updateTime":"2013-10","menuType":0,"menuHref":"/index.jsp","fatherId":0,"menuName":"菜单0","children":[{"state":"open","id":1,"createTime":"2013-09","updateOperator":"clc","createOperator":"clc","updateTime":"2013-10","menuType":0,"menuHref":"/index.jsp","fatherId":0,"menuName":"菜单2"},{"state":"open","id":2,"createTime":"2013-09","updateOperator":"clc","createOperator":"clc","updateTime":"2013-10","menuType":0,"menuHref":"/index.jsp","fatherId":0,"menuName":"菜单2"}]}];
		        		if(simpleDataBoolean){
		        			return $.convert(rows,dataId,dataFatherId);
		        		}else{
		        			return rows;
		        		}
		        }
		    };
		$.extend(defaultSetting,treeGridSetting?treeGridSetting:{});
		$(treeGridID).treegrid(defaultSetting);
		return $(treeGridID);
	},
	/**
	 *  弹出框方法
	 * @param options
	 * @param id 带#
	 * @returns
	 */
	easyUi_window:function(options,id){
		if(!id){
			if($("#win_clc").length){
				$("#win_clc").window("destroy");
			}
			var defaultOptions = {
					title:'弹出框',
					width:500,
					height:400,
					modal:true,
					collapsed:false,
					minimizable:false,
					collapsible:false,
					loadingMessage:"加载中....."
			};
			$.extend(defaultOptions,options);
			var win = $("<div id='win_clc'></div>");
			win.window(defaultOptions);
			win.closeSelf = function(){
				$("#win_clc").window("destroy");
			};
			return win;
		}else{
			if($(id).length){
				$(id).window("destroy");
			}
			var defaultOptions = {
					title:'弹出框',
					width:500,
					height:400,
					modal:true,
					collapsed:false,
					minimizable:false,
					collapsible:false,
					loadingMessage:"加载中....."
			};
			$.extend(defaultOptions,options);
			var win = $("<div id='" + id.replace("#","") + "'></div>");
			win.window(defaultOptions);
			win.closeSelf = function(){
				$(id).window("destroy");
			};
			return win;
		}
		
	},
	/**
	 * 关闭弹出框方法
	 * @param options
	 */
	easyUi_window_close:function(id){
		if(!id){
			if($("#win_clc").length){
				$("#win_clc").window("destroy");
			}
		}else{
			if($(id).length){
				$(id).window("destroy");
			}
		}
	},
	/**
	 *  弹出框方法
	 * @param options
	 * @param id 带#
	 * @returns
	 */
	easyUi_dialog:function(options,id){
		if(!id){
			if($("#dialog_clc").length){
				$("#dialog_clc").dialog("destroy");
			}
			var defaultOptions = {
					title:'弹出框',
					width:500,
					height:400,
					modal:true,
					collapsed:false,
					minimizable:false,
					collapsible:false,
					loadingMessage:"加载中....."
			};
			$.extend(defaultOptions,options);
			var dia = $("<div id='dialog_clc' style='overflow-x:hidden'></div>");
			dia.dialog(defaultOptions);
			dia.closeSelf = function(){
				$("#dialog_clc").dialog("destroy");
			};
			return dia;
		}else{
			if($(id).length){
				$(id).dialog("destroy");
			}
			var defaultOptions = {
					title:'弹出框',
					width:500,
					height:400,
					modal:true,
					collapsed:false,
					minimizable:false,
					collapsible:false,
					loadingMessage:"加载中....."
			};
			$.extend(defaultOptions,options);
			var dia = $("<div id='" + id.replace("#","") + "'  style='overflow-x:hidden'></div>");
			dia.dialog(defaultOptions);
			dia.closeSelf = function(){
				$(id).dialog("destroy");
			};
			return dia;
		}
		
	},
	/**
	 * 关闭弹出框方法
	 * @param options
	 */
	easyUi_dialog_close:function(id){
		if(!id){
			if($("#dialog_clc").length){
				$("#dialog_clc").dialog("destroy");
			}
		}else{
			if($(id).length){
				$(id).dialog("destroy");
			}
		}
	},
	closeCheckSon:false,
	closeCheckBro:false,
	easyUi_tree:function(treeid,options,id,parentId){
		var dafultOptions = {
				loadFilter : function(rows) {
					if(id){
						return $.convert(rows,id,parentId);
					}else{
						return rows;
					}
				}
			};
		
		if(options && !options.cascadeCheck){
				var onCheck = function(node, checked){
										var $this = $(this);
										if(checked && !$.closeCheckSon){
											$.closeCheckSon = true; 
											//checkSon(node);
											checkParents(node); 
											$.closeCheckSon = false;
										}
				
										if(!checked && !$.closeCheckBro){
											$.closeCheckBro = true; 
											checkUnSon(node); 
											checkBro(node); 
											$.closeCheckBro = false;
										}
				
										function checkParents(node){
											var parent = $this.tree("getParent",node.target);
											if(parent){ $this.tree("check",parent.target); 
											checkParents(parent);}
										}
				
										function checkSon(node){
											if(!node.checked){$this.tree("check",node.target);}
											var sons = $this.tree("getChildren",node.target);
											if(sons && sons.length > 0){
												for(var i = 0; i < sons.length;i++){
													$this.tree("check",sons[i].target);
												}
											}
										}
										function checkUnSon(node){
											if(node.checked){
												$this.tree("uncheck",node.target);
												var sons = $this.tree("getChildren",node.target);
												if(sons && sons.length > 0){
													for(var i = 0; i < sons.length;i++){
														$this.tree("uncheck",sons[i].target);
													}
												}
											}
										}
										function checkBro(node){
											var parent = $this.tree("getParent",node.target);
											if(parent){
												var sons = $this.tree("getChildren",parent.target);
												var isAllFalse = true;
												for(var i = 0 ; i < sons.length ;i++){
													if(sons[i].checked){
														isAllFalse = false;
														break;
													}
												}
												if(isAllFalse){
													$this.tree("uncheck",parent.target);
													checkBro(parent);
												}
											}
										}
								};
			dafultOptions.onCheck = onCheck;
		}
		
		$.extend(dafultOptions,options?options:{});
		$(treeid).tree(dafultOptions);
		return $(treeid); 
	}
});


