<%@page import="jwb.novice.javaweb.shopping.Order"%>
<%@page import="java.util.Iterator"%>
<%@page import="jwb.novice.javaweb.shopping.Item"%>
<%@page import="jwb.novice.javaweb.shopping.ItemDetailViewModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
* {
	box-sizing : border-box;
	padding : 0;
}

.cart-container {
	height : 100%;
	width : 100%;
	background : rgba(0, 0, 0, 0.5);
	position : absolute;
	top : 0;
	left : 0;
	padding : 1.5rem;
	display : none;
}

.shopping-cart {
	height : 100%;
	width : 100%;
	background : rgba(255, 255, 255, 1.0);
	position : relative;
	top : 0;
	left : 0;
	padding : 1.0rem;
}

table {
	width : 75%;
	border-collapse : collapse;
}

thead tr {
	background-color : #80cfcf;
}

td {
	border-bottom : 1px solid #000000;
}

button {
	padding : 0.50rem 1.00rem;
}
</style>
<script type="text/javascript">
function setVisiblity(isVisible) {
	
	if (isVisible) {

		document.getElementById('cart-container').style.display = "block";
	} else {
		
		document.getElementById('cart-container').style.display = "none";
	}
}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="setVisiblity(<%= (Boolean)request.getAttribute("cartVisiblity") %>)">
	<%
	ItemDetailViewModel vm = (ItemDetailViewModel)request.getAttribute(ItemDetailViewModel.class.getSimpleName());
	Item item = vm.itemDetail();
	%>
	<img src="../img/<%= item.getProductImg() %>">
	<h2><%= item.getProductdNm() %></h2>
	<b>価格：<%= item.getUnitPrice() %>円</b>
	<div style="margin:1.0rem 0;"><%= item.getDescription() %></div>
	
	<!-- ここから -->
	<div class="cart-container" id="cart-container">
		<div class="shopping-cart">
			<div style="height: 5%; font-weight: bold; font-size: 1.25rem;">ショッピングカート</div>
			<div style="height: 90%; overflow-y: auto;">
				<!-- ここにカートに追加された商品の一覧が表示されます。 -->
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
					Iterator<Order> iterator = vm.shoppingCart().iterator();
					while (iterator.hasNext()) {
						Order order = iterator.next();
						Item currentItem = order.orderedItem();
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
					</tbody>
				</table>
			</div>
			<div style="height: 5%">
				<button type="button" onclick="setVisiblity(false)">閉じる</button>
			</div>
		</div>
	</div>
	
	<form method="post" action="addItem">
		<input type="hidden" name="currentItemCd" value="<%= item.getProductCd() %>">
		<button style="margin:1.0rem 0;" type="submit">この商品をカートに追加</button>
	</form>
	<!-- ここまで -->
	<a href="items.jsp">Back</a>
</body>
</html>