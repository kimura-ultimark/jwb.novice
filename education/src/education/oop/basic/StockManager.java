package education.oop.basic;

public class StockManager implements StockManagement {

	@Override
	public int queryStock(String item) {
		
		return 100;
	}

	@Override
	public String ship(String name, String address, String item) {
		
		Delivery delivery = new DeliveryManager();
		return delivery.deliver(name, address, item);
	}
}