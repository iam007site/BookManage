<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <%@include file="/commons/common.jsp" %>
  </head>
  
  <body>
    我的购物车： <br>
	<table border="1">
		<tr>
			<td>书名</td>
			<td>数量</td>
			<td>操作</td>
		</tr>
		<c:forEach items="shoppingCartItems" var="shoppingCartItem">
		<tr>
		<td>${shoppingCartItem.getProduct().getbName()}</td>
		<td>${shoppingCartItem.getQuantity())}</td>
		<td><a href="">删除</a></td>
		</tr>
		
		</c:forEach>
	</table>
</body>
</html>
