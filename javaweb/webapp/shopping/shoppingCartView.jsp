<%@page import="java.math.BigDecimal"%>
<%@page import="jwb.novice.javaweb.shopping.Item"%>
<%@page import="jwb.novice.javaweb.shopping.Order"%>
<%@page import="java.util.Iterator"%>
<%@page import="jwb.novice.javaweb.shopping.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table {
	width : 75%;
	border-collapse : collapse;
	margin-bottom : 1.0rem;
}

thead tr {
	background-color : #80cfcf;
}

td {
	border-bottom : 1px solid #242424; 
	line-height : 1.00rem;
}
</style>
<script type="text/javascript">
function gotoConfirm() {
	document.location.href = "confirmPurchase.jsp";
}
</script>
<title>Insert title here</title>
</head>
<body>
	<%
	Cart cart = (Cart)session.getAttribute(Cart.class.getSimpleName());
	BigDecimal totalPrice = BigDecimal.ZERO;
	%>
	<h2>ショッピングカート</h2>
	<%
	if (cart == null) {
	%>
	<p style="color: red; font-weight: bold;">カートの中に商品がありません。</p>
	<%
	} else {
	%>
	<table>
		<col width="10%"/>
		<col width="40%"/>
		<col width="20%"/>
		<col width="10%"/>
		<col width="20%"/>
		<thead>
			<tr>
				<td>商品コード</td>
				<td>商品名</td>
				<td>単価</td>
				<td>数量</td>
				<td>購入金額</td>
			</tr>
		</thead>
		<tbody>
			<%
			Iterator<Order> iterator = cart.iterator();
			while (iterator.hasNext()) {
				Order order = iterator.next();
				Item currentItem = order.orderedItem();
				totalPrice = totalPrice.add(order.purchasePrice());
			%>
			<tr>
				<td><%= currentItem.getProductCd() %></td>
				<td><%= currentItem.getProductdNm() %></td>
				<td><%= currentItem.getUnitPrice() %></td>
				<td><%= order.quantity() %></td>
				<td><%= order.purchasePrice() %></td>
			</tr>
			<%
			}
			%>
			<tr>
				<td colspan="4"><b>合計金額</b></td>
				<td><%= totalPrice %></td>
			</tr>
		</tbody>
	</table>
	<%
	}
	%>
	<div style="margin-bottom: 1.0rem;">
		<button type="button" onclick="gotoConfirm()" <%= cart == null ? "disabled" : "" %>>購入を確定する</button>
	</div>
	<a href="items.jsp">取扱商品一覧に戻る</a>
</body>
</html>