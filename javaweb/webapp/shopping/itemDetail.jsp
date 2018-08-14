<%@page import="jwb.novice.javaweb.shopping.Item"%>
<%@page import="jwb.novice.javaweb.shopping.ItemDetailViewModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	ItemDetailViewModel vm = (ItemDetailViewModel)request.getAttribute(ItemDetailViewModel.class.getSimpleName());
	Item item = vm.itemDetail();
	%>
	<img src="../img/<%= item.getProductImg() %>">
	<h2><%= item.getProductdNm() %></h2>
	<b>価格：<%= item.getUnitPrice() %>円</b>
	<div style="margin:1.0rem 0;"><%= item.getDescription() %></div>
	<a href="items.jsp">Back</a>
</body>
</html>