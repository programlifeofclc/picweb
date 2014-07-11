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

$.extend($.fn.pagination.defaults, {
			beforePageText : '页数',
			afterPageText : '共{pages}',
			displayMsg : '从{from} 到 {to}，共 {total}条'
		});




$.extend({
			// 当树形使用简单数据类型时候使用
			convert : function(rows, id, parentId) {
				function exists(rows, parentId) {
					if (parentId == "" || parentId == null) {
						parentId = "clc_null";
					}
					for (var i = 0; i < rows.length; i++) {
						if (rows[i][id] == parentId)
							return true;
					}
					return false;
				}

				var nodes = [];
				// 得到顶层节点
				for (var i = 0; i < rows.length; i++) {

					var row = rows[i];
					if (rows[i]['checked'] == 'true') {
						rows[i]['checked'] = true;
					} else if (rows[i]['checked'] == 'false') {
						rows[i]['checked'] = false;
					}
					if (!exists(rows, row[parentId])) {
						nodes.push(row);
					}
				}
				var toDo = [];
				for (var i = 0; i < nodes.length; i++) {
					toDo.push(nodes[i]);
				}
				while (toDo.length) {
					var node = toDo.shift(); // 父节点
					// 得到子节点
					for (var i = 0; i < rows.length; i++) {
						var row = rows[i];
						if (row[parentId] == node[id]) {
							var child = row;
							if (node.children) {
								node.children.push(child);
								// node.state = "closed";
							} else {
								node.children = [child];
								// node.state = "closed";
							}
							// alert(child.id+"---"+child.checked)
							toDo.push(child);
						}
					}
				}
				for (var g = 0; g < nodes.length; g++) {
					//alert(nodes[g].checked+"---")
				}
				return nodes;
			}
});


$.fn.extend({
	datagrid_clc : function(setting,psetting) {
		var thiz = this;
		// 表格配置
		var dfOpts = {
			fit : true,
			fitColumns : true,
			nowrap : true,
			pagination : true,
			striped : true,
			singleSelect : true,
			rownumbers : true,
			loadMsg : " 加载中.... ",
			loadFilter : function(data) {
				return data;
			}
		};
		// 初始化表格
		$.extend(dfOpts, setting ? setting : {});
		thiz.datagrid(dfOpts);
		return thiz;
	}

});


 