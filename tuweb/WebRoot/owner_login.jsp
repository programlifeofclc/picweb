<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html style="height:100%">
<head>
	<!--[if lt IE 9]>
		<script type="text/javascript" src="js/html5.js"></script>
	<![endif]-->
	<meta http-equiv="pragma" content="no-cache"/> 
	<meta http-equiv="cache-control" content="no-cache,must-revalidate"/>  
	<meta http-equiv="expires" content="0"/>  
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>html5</title>
	<style type="text/css">
		*{outline: none;}
		input::-webkit-input-placeholder {
			     font-family:"楷体";
				 font-weight:bold;
				}
		input::-moz-placeholder {
			    font-family:"楷体";
				font-weight:bold;
			}
		body{
			background:#E9E9E9;
			height:100%;
			overflow: hidden;
		 }
		 table{
		 	border:none;
		 	width: 100%;
		 	height:100%;
		 }
		 td{
		 	vertical-align:middle;
		 	text-align: center;
		 	height:100%;
		 }
		 #box{
		 			width:400px;
					height:300px;
					background-color:#0A6CC1;
				 	-moz-border-radius: 10px;      /* Gecko browsers */
				    -webkit-border-radius: 10px;   /* Webkit browsers */
				    border-radius:10px;            /* W3C syntax */
				    text-align: center;
				    margin: 0px auto;
				    overflow: hidden;
				    box-shadow: 0px 0px 100px #222 inset ;
				    font-family:"楷体";
				    font-weight:bold;
		 		}
		 #loginbox{ font-family:"楷体";
				    font-weight:bold;
		 			margin:70px auto 0px;
					width:300px;
					height:100px;
					background-color:#EEE;
				 	-moz-border-radius: 10px;      /* Gecko browsers */
				    -webkit-border-radius: 10px;   /* Webkit browsers */
				    border-radius:10px;            /* W3C syntax */
				    text-align: center;
				    box-shadow: 0px 0px 1px #000 inset;
				}
		#loginbutton{
					border:none;
					margin:30px auto;
					width:300px;
					height:50px;
					background-color:#B6EE65;
				 	-moz-border-radius: 10px;      /* Gecko browsers */
				    -webkit-border-radius: 10px;   /* Webkit browsers */
				    border-radius:10px;
				    box-shadow: 0px 0px 2px #000 inset;
				    color: green;
				    font-size: 20px;
				    line-height: 50px;
				    cursor: pointer;
				    font-family:"楷体";
				    font-weight:bold;
				}
		#loginname{
				height:47px;
				width:260px;
				border:none; 
				background:none 
				}
		#loginpws{
				height:47px;
				width:260px;
				border:none;
				border-top:1px #ccc solid; 
				background:none
				}
		#loginbutton:HOVER {
				box-shadow: 0px 0px 6px #000;
				}
		#loginbox:HOVER {
				box-shadow: 0px 0px 6px #000;
				}
	</style>
</head>
<body>
	<form action="login!login.htm" method="post" style="height: 100%">
	<table>
		<tr>
			<td>
				<div id="box">
					<div id="loginbox">
						<input id="loginname" name="user.loginName" type="text" placeholder="账户" required="required">
						<input id="loginpws" name="user.loginPws"  type="password" placeholder="密码" required="required">
					</div>
					<button id="loginbutton" >進入管理</button>
				</div>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>