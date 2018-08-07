package education.oop.basic;

public interface Delivery {
	
	// 配送指示を受けて、問い合わせ番号を返す。
	public String deliver(String name, String address, String item);
}
