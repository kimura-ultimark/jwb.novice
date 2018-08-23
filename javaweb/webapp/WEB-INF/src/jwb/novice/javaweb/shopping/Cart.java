package jwb.novice.javaweb.shopping;

import java.util.Iterator;

public interface Cart {
	
	public void add(Item item);
	
	public Iterator<Order> iterator();

	public int size();
}