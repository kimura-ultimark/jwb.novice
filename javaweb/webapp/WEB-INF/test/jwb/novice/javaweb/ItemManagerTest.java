package jwb.novice.javaweb;

import jwb.novice.javaweb.shopping.Item;
import jwb.novice.javaweb.shopping.ItemDetailViewModel;

public class ItemManagerTest {

	public static void main(String[] args) {
		
		ItemDetailViewModel vm = new ItemDetailViewModel("0004");
		Item item = vm.itemDetail();
		
		System.out.println(item.getProductdNm() + " : " + item.getDescription() + " : " + item.getProductImg());
	}
}