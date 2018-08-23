package jwb.novice.javaweb.shopping;

import java.math.BigDecimal;

public class Order {
	
	private Item item;
	
	private int quantity;
	
	private BigDecimal purchasePrice;
	
	
	public Order(Item item) {
		
		this(item, 1);
	}
	
	
	public Order(Item item, int quantity) {
		
		this.item = item;
		this.quantity = quantity;
		this.purchasePrice = item.getUnitPrice().multiply(new BigDecimal(this.quantity));
	}
	
	
	public void increase(int quantity) {
		
		this.quantity += quantity;
		this.purchasePrice = item.getUnitPrice().multiply(new BigDecimal(this.quantity));
	}
	
	
	public boolean contains(Item item) {
		
		return this.item.equals(item);
	}
	
	public Item orderedItem() {
		
		return item;
	}
	
	public int quantity() {
		
		return quantity;
	}
	
	public BigDecimal purchasePrice() {
		
		return this.purchasePrice;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Order order = (Order)obj;
		return this.orderedItem().getProductCd().equals(order.orderedItem().getProductCd());
	}
	
	@Override
	public int hashCode() {
		
		return this.orderedItem().getProductCd().hashCode();
	}
}