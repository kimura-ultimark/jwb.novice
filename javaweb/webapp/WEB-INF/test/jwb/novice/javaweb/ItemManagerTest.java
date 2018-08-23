package jwb.novice.javaweb;

import java.util.Iterator;

import jwb.novice.javaweb.shopping.Cart;
import jwb.novice.javaweb.shopping.Item;
import jwb.novice.javaweb.shopping.Order;
import jwb.novice.javaweb.shopping.ShoppingCart;

public class ItemManagerTest {

	public static void main(String[] args) {
		
		Item item01 = new Item();
		item01.setProductCd("0001");
		
		Item item02 = new Item();
		item02.setProductCd("0001");
		
		// item01.equals(item02) == true;
		// item01.hashCode() == item02.hashCode();
		// item02.equals(item01) == true;
		
		Cart cart = new ShoppingCart();
		cart.add(item01);
		cart.add(item02);
		
		Iterator<Order> iterator = cart.iterator();
		while (iterator.hasNext()) {
			
			Order order = iterator.next();
			System.out.println(order.orderedItem().getProductCd() + " : " + order.quantity());
		}
	}
}