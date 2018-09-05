<%@page import="java.math.BigDecimal"%>
<%@page import="jwb.novice.javaweb.shopping.Cart"%>
<%@page import="java.util.Iterator"%>
<%@page import="jwb.novice.javaweb.shopping.Item"%>
<%@page import="jwb.novice.javaweb.shopping.Order"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	line-height : 1.50rem;
}
</style>
</head>
<body>
	<%
	Cart cart = (Cart)session.getAttribute(Cart.class.getSimpleName());
	BigDecimal totalPrice = BigDecimal.ZERO;
	%>
	<form action="purchaseConfirm" method="post">
		<section style="padding: 24px;">
			<h4>お届け先情報</h4>
			<table>
				<col width="15%"/>
				<col width="35%"/>
				<col width="15%"/>
				<col width="35%"/>
				<tr>
					<td style="border: none;">姓</td>
					<td style="border: none;"><input type="text" name="familyName"></td>
					<td style="border: none;">名</td>
					<td style="border: none;"><input type="text" name="firstName"></td>
				</tr>
				<tr>
					<td style="border: none;">郵便番号</td>
					<td style="border: none;"><input type="text" name="zipCode"></td>
					<td style="border: none;" colspan="2">※ハイフンなし</td>
				</tr>
				<tr>
					<td style="border: none;">都道府県</td>
					<td style="border: none;"><input type="text" name="pref"></td>
					<td style="border: none;" colspan="2"></td>
				</tr>
				<tr>
					<td style="border: none;">市区町村</td>
					<td style="border: none;" colspan="3"><input type="text" name="city" size="128"></td>
				</tr>
				<tr>
					<td style="border: none;">番地・建物</td>
					<td style="border: none;" colspan="3"><input type="text" name="address" size="128"></td>
				</tr>
			</table>
		</section>
		<section style="padding: 24px;">
			<h4>ご注文商品</h4>
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
		</section>
		<section style="padding: 24px;">
			<button type="submit">注文確定</button>
		</section>
	</form>
</body>
</html>