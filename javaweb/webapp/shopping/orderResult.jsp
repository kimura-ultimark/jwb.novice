<%@page import="jwb.novice.javaweb.shopping.Order"%>
<%@page import="java.util.List"%>
<%@page import="jwb.novice.javaweb.shopping.OrderProvider"%>
<%@page import="jwb.novice.javaweb.items.ItemManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="width: 50%; margin: 64px auto;">
		<h1>ご利用ありがとうございます。ご注文を受け付けました。</h1>
		<%
		String orderNo = request.getAttribute("orderNo").toString();
		%>
		<div>注文番号&emsp;：&emsp;<%= orderNo %></div>
		<div style="margin: 32px 0px; display: flex; flex-wrap: wrap;">
			<%
			OrderProvider provider = new OrderProvider();
			List<Order> orderList = provider.orderList(orderNo);
			for (Order order : orderList) {
			%>
			<div style="width: 128px; padding: 8px; border: 1px solid grey; box-shadow: 0 0 8px rgba(0,0,0,.5)">
				<div>
					<img src="../img/<%= order.orderedItem().getProductImg() %>">	
				</div>
				<div style="display: flex;flex-wrap: wrap">
					<div style="width: 100%;"><span><%= order.orderedItem().getProductdNm() %></span></div>
					<div style="flex-grow: 1;"><span><%= order.quantity() %>個</span></div>
					<div style="flex-grow: 1;"><span><%= order.purchasePrice() %>円</span></div>
				</div>
			</div>
			<%
			}
			%>
		</div>
		<a href="items.jsp">買い物を続ける</a>
	</div>
</body>
</html>