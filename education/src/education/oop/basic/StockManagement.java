package education.oop.basic;

public interface StockManagement {
	
	// 問い合わせを受けて在庫を返す。
	public int queryStock(String item);
	
	// 出荷指示を受けて問い合わせ番号を返す。
	public String ship(String name, String address, String item);
}
