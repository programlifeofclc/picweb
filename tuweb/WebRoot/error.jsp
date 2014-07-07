<%@ page language="java" contentType="text/html; charset=UTF-8" import="utils.BeanScope" pageEncoding="UTF-8" isELIgnored="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!doctype html>
<html>
<%
	response.setHeader("progma","no-cache");   
	response.setHeader("Cache-Control","no-cache");   
	response.setDateHeader("Expires",0);
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="cache-control" content="no-cache"> 
<meta http-equiv="expires" content="0">
<title>html5</title>
</head>
<body>
	<c:forEach items="${beanScope.listValue}" var="my">
		<c:out value="${my.loginPws}"></c:out>
	</c:forEach>
	
</body>
</html>