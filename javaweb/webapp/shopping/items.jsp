<%@page import="jwb.novice.javaweb.shopping.Item"%>
<%@page import="java.util.List"%>
<%@page import="jwb.novice.javaweb.shopping.ItemsViewModel"%>
<%@page import="jwb.novice.javaweb.shopping.ItemSummaryView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
function selectCode(selectedCode) {
	document.getElementById("selectedCode").value = selectedCode
	document.itemSelect.submit();
}

function shoppingCartView() {
	document.location.href = "shoppingCartView.jsp";
}
</script>
<style type="text/css">
table {
	width : 65%;
	border-collapse : collapse;
}

thead tr {
	background-color : #80cfcf;
}

td {
	border-bottom : 1px solid #242424; 
	line-height : 1.00rem;
}

.currency {
	text-align : right;
}
</style>
<title>取扱商品一覧</title>
</head>
<body>
	<%
	ItemsViewModel vm = new ItemsViewModel();
	List<Item> items = vm.itemList();
	%>
	<table>
		<col width="50%"/>
		<col width="50%"/>
		<tr>
			<td><h2>取扱商品一覧</h2></td>
			<td style="text-align: right">
				<button id="shoppingCartView" type="button" onclick="shoppingCartView()">ショッピングカートを見る</button>
			</td>
		</tr>
	</table>
	<form method="post" action="itemDetail" name="itemSelect">
		<table>
			<col width="15%"/>
			<col width="45%"/>
			<col width="25%"/>
			<col width="15%"/>
			<thead>
				<tr>
					<td>商品コード</td>
					<td>商品名</td>
					<td style="text-align: right;">単価</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<%
				for (Item item : items) {
				%>
				<tr>
					<td><%= item.getProductCd() %></td>
					<td><%= item.getProductdNm() %></td>
					<td class="currency"><%= item.getUnitPrice() %></td>
					<td class="currency"><button type="button" onclick="selectCode('<%= item.getProductCd() %>')">詳細</button></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<input type="hidden" name="selectedCode" id="selectedCode">
	</form>
</body>
</html>