package jwb.novice.javaweb.shopping;

import java.util.Iterator;

public interface Cart {
	
	public void add(Item item);
	
	public Iterator<Item> iterator();

	public int size();
}