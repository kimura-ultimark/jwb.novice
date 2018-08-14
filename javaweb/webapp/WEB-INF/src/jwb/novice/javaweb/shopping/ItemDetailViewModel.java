package jwb.novice.javaweb.shopping;

import jwb.novice.javaweb.img.ImageManager;
import jwb.novice.javaweb.items.ItemManager;

public class ItemDetailViewModel {
	
	
	private String itemCd;
	
	
	public ItemDetailViewModel(String itemCd) {
		
		this.itemCd = itemCd;
	}
	
	
	public Item itemDetail() {
		
		// 商品管理システムにアクセス
		ItemDetailView detailView = new ItemManager();
		Item item = detailView.itemDetail(itemCd);
		
		// 画像管理システムにアクセス
		ItemImageView imageView = new ImageManager();
		imageView.itemImage(item);
		
		return item;
	}
}