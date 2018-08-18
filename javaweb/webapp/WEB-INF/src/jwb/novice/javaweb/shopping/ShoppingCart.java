package jwb.novice.javaweb.shopping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart implements Cart {
	
	private List<Item> itemList = new ArrayList<Item>();

	@Override
	public void add(Item item) {
		
		itemList.add(item);
	}

	@Override
	public Iterator<Item> iterator() {

		return itemList.iterator();
	}

	@Override
	public int size() {
		
		return itemList.size();
	}

}