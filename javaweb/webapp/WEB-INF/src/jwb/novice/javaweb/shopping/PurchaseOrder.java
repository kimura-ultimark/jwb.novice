package jwb.novice.javaweb.shopping;

import java.util.ArrayList;
import java.util.List;

import jwb.novice.javaweb.Client;

public class PurchaseOrder {
	
	
	private List<Order> orderList = new ArrayList<Order>();
	
	private Client client;
	
	
	public PurchaseOrder(Client client, List<Order> orderList) {
		
		this.client = client;
		this.orderList = orderList;
	}

	public List<Order> getOrderList() {
		return orderList;
	}


	public Client getClient() {
		return client;
	}
}
