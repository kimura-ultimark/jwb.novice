package jwb.novice.javaweb.shopping;

import jwb.novice.javaweb.img.ImageManager;
import jwb.novice.javaweb.items.ItemManager;

public class ItemDetailViewModel {
	
	
	private String itemCd;
	
	
	private Cart cart = new ShoppingCart();
	
	
	public ItemDetailViewModel(String itemCd) {
		
		this.itemCd = itemCd;
	}
	
	public Item itemDetail() {
		
		ItemDetailView detailView = new ItemManager();
		Item item = detailView.itemDetail(itemCd);
		
		ItemImageView imageView = new ImageManager();
		imageView.itemImage(item);
		
		return item;
	}
	
	
	public Cart shoppingCart() {
		
		return cart;
	}
	
	
	public void saveCart(Cart cart) {
		
		this.cart = cart;
	}
}