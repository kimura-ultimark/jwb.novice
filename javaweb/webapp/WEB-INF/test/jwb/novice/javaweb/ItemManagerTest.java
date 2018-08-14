package jwb.novice.javaweb;

import java.util.List;

import jwb.novice.javaweb.items.ItemManager;
import jwb.novice.javaweb.shopping.Item;
import jwb.novice.javaweb.shopping.ItemSummaryView;

public class ItemManagerTest {

	public static void main(String[] args) {
		
		ItemSummaryView itemManager = new ItemManager();
		List<Item> itemList = itemManager.itemList();
		
		for (Item item : itemList) {
			
			System.out.println(item.getProductCd() + " : " + item.getProductdNm());
		}
	}
}