function boxRightLeft(sec){
	var size = sec?sec.length:null;
	var thiz = this;
	var index = 0;
	if(sec&&sec.length >0){
		window.setInterval()
	
	
	}
	
	var go = function(index){
	alert(22);
	
	
	}
	
	function ss(){
		alert(2);
	}
	
	thiz.next = function(){
		if(index >= (size-1)){
			index = 0;
		}else{
			index++;
		}
		
	
	}
	
	thiz.pre = function(){
	
	
	}
	
	
	
}

var d = new boxRightLeft();


//一个移动滚动条的js

function stopDefaultA() {
	$("a[href^='#']").click(function(e) {
				var ah = $(this).attr("href").replace("#", "");
				if (ah.length > 0) {
					var $a = $("#"+ah).length>0?$("#"+ah):$($("a[name='" + ah + "']")[0]);
					
					window.setTimeout(function() {
								totop($a);
							}, 100);

					function totop(thiz) {
						var top = thiz.offset().top;
						var scrollTop = $(window).scrollTop();
						if (Math.abs(scrollTop - top) < 6) {
							return;
						}
						var jl = (top - scrollTop);
						if (jl > 0) {
							jl = 9;
						} else {
							jl = -7;
						}
						$(window).scrollTop(scrollTop + jl)
						window.setTimeout(function() {
									totop(thiz);
								}, 1);
					}
				}

				if (e && e.preventDefault) {
					e.preventDefault();
				} else {
					window.event.returnValue = false;
				}
				return false;
			});

}
