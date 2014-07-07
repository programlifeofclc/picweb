(function($){
	$.extend({
		
	
		
		
		
	});
	
	
	$.fn.extend({
		cBox:function(options){
			var that = this;
			(function init(options){
				var priv = this;
				var indexObj = null,$bigImg = null,$smallImg=null,$smallPoint=null;//$[]
				var defaults = {
							data:[],
							href:null,
							leftDiv1:true,
							leftDiv2:true
						};
				var opts = $.extend(defaults,options);
				var wid = that.width();
				var hei = that.height();
				//加载数据
				if(opts.href){
					$.ajax({type:"post",url:opts.href,data:{},async:false,dataType:"json",
	              			success:function(data){
	              				opts.data = data;
	              			}});  
				}
				
				//是否加载缩略图的框
				if(opts.leftDiv1){
	   				var leftDiv1 = $("<div class='letdiv'></div>").width(150).height(hei).css("overflow","hidden").appendTo(that);
	
	   				$("<div class='letdiv_upbox'></div>")
	   				.width(150)
	   				.appendTo(leftDiv1)
	   				.hover(function(){
	   							$(this).animate({opacity:1},500);
	   						},function(){
	   							$(this).animate({opacity:0},500);
	   						}).mousedown(function(){
	   								var n = Math.abs(letdiv_midbox2.css("marginTop").replace("px",""));
	   								var height1 = letdiv_midbox2.height();
	   								var height2 = letdiv_midbox.height();
	   								if(n >= height2){
	   									letdiv_midbox2.animate({marginTop:-(n-height2)-80}, 500);
	   								}else{
	   									letdiv_midbox2.animate({marginTop:0}, 500);
	   								}
	   						}).hover(function(){that.cBoxStop();},function(){that.cBoxTrun();});
	   				
	   				var letdiv_midbox = $("<div class='letdiv_midbox'></div>").width(150).height(hei).appendTo(leftDiv1);
	   				var letdiv_midbox2 = $("<div class='letdiv_midbox'></div>").width(150).appendTo(letdiv_midbox);
	   				var letdiv_downbox = $("<div class='letdiv_downbox'></div>").width(150).appendTo(leftDiv1);
	   				letdiv_downbox.hover(function(){
	   							$(this).animate({opacity:1},500);
	   						},function(){
	   							$(this).animate({opacity:0},500);
	   						}).mousedown(function(){
	   								var n = Math.abs(letdiv_midbox2.css("marginTop").replace("px",""));
	   								var height1 = letdiv_midbox2.height();
	   								var height2 = letdiv_midbox.height();
	   								if((height1-height2-n) >= height2){
	   									letdiv_midbox2.animate({marginTop:-n-height2+80}, 500);
	   								}else{
	   									letdiv_midbox2.animate({marginTop:height2-height1}, 500);
	   								}
	   						}).hover(function(){that.cBoxStop();},function(){that.cBoxTrun();});
	   				$.each(opts.data, function(i,o){
	   						$("<a href='javascript:void(0)'><img src='" + o.src + "'/></a>")
	   						.appendTo(letdiv_midbox2)
	   						.hover(function(){
	   							indexObj&&indexObj.index==i?that.cBoxStop():$(this).animate({borderWidth:"8px",opacity:1},200);
	   						},function(){
	   							indexObj&&indexObj.index==i?that.cBoxTrun():$(this).animate({borderWidth:"2px",opacity:0.8},200);
	   						}).click(function(){
	   							that.cBoxShow(i);
	   						});
	   				});
	   				$smallImg = letdiv_midbox2.find("a");
	   			}
	   			
	   			//大图片
				var leftDiv_left = $("<div class='letdiv'></div>").width(wid-(opts.leftDiv2?8:0)-(opts.leftDiv1?150:0)).height(hei).appendTo(that).css("background","#EEE");
				$.each(opts.data, function(i,o){
							$("<img class='letdiv_img'/>")
							.attr("src",opts.data[i]?opts.data[i].bigsrc:"")
							.css({"width":"100%","height":"100%","display":"none"})
							.appendTo(leftDiv_left)
	   						.hover(function(){
	   							that.cBoxStop();
								$(this).animate({borderRadius:"22px",borderWidth:"8px"},200);
							},function(){
								that.cBoxTrun();
								$(this).animate({borderRadius:"2px",borderWidth:"2px"},200);
							});
	   			});
	   			$bigImg = leftDiv_left.find("img");// $("img",leftDiv_left);
				
	   			//是否加载最左边的框
	   			if(opts.leftDiv2){
	   				var leftDiv2 = $("<div class='letdiv'></div>").width(8).height(hei).appendTo(that);
	   				var n = opts.data.length;
	   				$.each(opts.data, function(i,o){
	   					$("<div class='letdiv_minbox'></div>").height(hei/n>8?8:hei/n).width(8).appendTo(leftDiv2).click(function(){
	   						try{
								window.clearTimeout(priv.n);
							}catch(e){}
	   						priv.n = window.setTimeout(function(){
	   													that.cBoxStop();
	   													that.cBoxTrun();
	   													that.cBoxShow(i);
	   												},300);
	   					});
	   				});
	   				$smallPoint = leftDiv2.find("div");
	   			}
				
				//public方法区
				that.cBoxShow = function(obj){
					if((typeof obj)=="number"){
						indexObj?indexObj.obj.fadeOut(500):null;
						var o = $($bigImg[obj]);
						o.fadeIn(1000);
						go(obj,indexObj?indexObj.index:null);
						indexObj = {index:obj,obj:o};
						return obj;
					}
					if((typeof obj)=="object"){
						indexObj?indexObj.obj.fadeOut(500):null;
						var n = $bigImg.index(obj);
						obj.fadeIn(1000);
						go(n,indexObj?indexObj.index:null);
						indexObj = {index:n,obj:obj};
						return n;
					}
					function go(i,n){
						if(opts.leftDiv1){
							if($smallImg){
								if(n!=null){
									$($smallImg[n]).animate({borderWidth:"2px",opacity:0.8},200);
								}
								if(i!=null){
									$($smallImg[i]).animate({borderWidth:"8px",opacity:1},200);
								}
								var size = $smallImg.size();
								var height1 = $smallImg.parent().height();
								var height2 = $smallImg.parent().parent().height();
								var oneHeight = height1/size;
								var mtop = oneHeight * i + oneHeight/2;
								if(mtop >= height2/2 && (height1 - mtop) >= height2/2){
									$smallImg.parent().animate({marginTop:height2/2-mtop}, 500);
								}else 
									if(mtop < height2/2 && (height1 - mtop) >= height2/2){
										$smallImg.parent().animate({marginTop:0}, 500);
									}else 
										if(mtop >= height2/2 && (height1 - mtop) < height2/2){
											$smallImg.parent().animate({marginTop:height2-height1}, 500);
										}
							}
						}
						if(opts.leftDiv2){
							$smallPoint&&n!=null?$($smallPoint[n]).css("background","#729316"):null;
							$smallPoint&&i!=null?$($smallPoint[i]).css("background","#2A4909"):null;
						}
					}
					
				}
				that.cBoxNext = function(){
					var n = indexObj?indexObj.index:0;
					n = $bigImg?$bigImg.size()<=(n+1)?0:n+1:0;
					//初始下循环 使不会点击下一个图片后 马上流转
					that.cBoxStop();
	   				that.cBoxTrun();
	   				
					that.cBoxShow(n);
					return n;
				}
				that.cBoxPrevious = function(){
					var n = indexObj?indexObj.index:0;
					n = $bigImg?(n-1)<0?($bigImg.size()-1):(n-1):0;
					//初始下循环 使不会点击下一个图片后 马上流转
					that.cBoxStop();
	   				that.cBoxTrun();
	   					   				
					that.cBoxShow(n);
					return n;
				}
				that.cBoxData = function(){
					return opts.data;
				}
				that.cBoxStop = function(){
					try{
						window.clearInterval(priv.trun_n);
					}catch(e){}
				}
				that.cBoxTrun = function(s){
					try{
						window.clearInterval(priv.trun_n);
					}catch(e){}
					priv.trun_n = window.setInterval(function(){that.cBoxNext()},s?s:3000);
				}
				
				//私有方法区
 				priv.clearTOut = function(n){
 					try{
 						n?window.clearTimeout(n):null;
 					}catch(e){}
 				}
 				priv.clearIval = function(n){
 					try{
 						n?window.clearInterval(n):null;
 					}catch(e){}
 				}
			
				$bigImg.size()>0?that.cBoxShow(0):"";
				that.cBoxTrun();
			})(options);
			return that;
		}
	
	
	
	});
	
})(jQuery)