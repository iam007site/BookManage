<%@page import="com.hsq.model.Book"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>数目列表</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	数目列表：
	<br>
	<table border="1">
		<tr>
			<td>id</td>
			<td>书名</td>
			<td>简介</td>
			<td>价格</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${booklist}" var="book">
			<tr>
				<td>${book.id}</td>
				<td>${book.bName}</td>
				<td>${book.description}</td>
				<td>${book.price}</td>
				<td>
				<a href="delete.do?id=${book.id}">删除</a>
				&nbsp;&nbsp;&nbsp; 
				<a href="modify.jsp?id=${book.id}&bName=${book.bName}&description=${book.description}&price=${book.price}">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
