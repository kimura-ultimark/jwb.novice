package jwb.novice.javaweb;

import java.sql.SQLException;
import java.util.List;

import jwb.novice.javaweb.shopping.Order;
import jwb.novice.javaweb.shopping.OrderProvider;

public class ItemManagerTest {

	public static void main(String[] args) throws SQLException {
		
		OrderProvider provider = new OrderProvider();
		List<Order> orderList = provider.orderList("00000009");
		
		for (Order order : orderList) {
			
			System.out.println(order.orderedItem().getProductImg());
			System.out.println(order.orderedItem().getProductdNm());
			System.out.println(order.purchasePrice());
			System.out.println(order.quantity());
		}
	}
}