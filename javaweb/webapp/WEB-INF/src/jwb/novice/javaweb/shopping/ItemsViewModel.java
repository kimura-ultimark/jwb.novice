package jwb.novice.javaweb.shopping;

import java.util.List;

import jwb.novice.javaweb.items.ItemManager;

public class ItemsViewModel {
	
	
	public List<Item> itemList() {
		
		ItemSummaryView sumView = new ItemManager();
		
		return sumView.itemList();
	}
}