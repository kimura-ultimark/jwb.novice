package jwb.novice.javaweb.shopping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart implements Cart {
	
	private List<Order> orderList = new ArrayList<Order>();

	@Override
	public void add(Item item) {
		
		// orderListの中にitemに対する注文が含まれているかチェックする。
		int position = 0;
		if ((position = orderList.indexOf(new Order(item))) > -1) {
			
			// orderListの中にitemに対する注文が含まれている場合は、そのitemに対する注文の注文数を増加させる。
			Order order = orderList.get(position);
			order.increase(1);
		} else {
			
			// orderListの中にitemに対する注文が含まれていない場合は、新たにOrderオブジェクトを生成してカートに追加する。
			orderList.add(new Order(item));
		}
	}

	@Override
	public Iterator<Order> iterator() {
		
		orderList.sort(new Comparator<Order>() {

			@Override
			public int compare(Order order01, Order order02) {
				
				String productCd01 = order01.orderedItem().getProductCd();
				String productCd02 = order02.orderedItem().getProductCd();
				
				return productCd01.compareTo(productCd02);
			}
			
		});
		
		return orderList.iterator();
	}

	@Override
	public int size() {
		
		return orderList.size();
	}

}