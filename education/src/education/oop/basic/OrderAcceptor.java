package education.oop.basic;

public class OrderAcceptor implements OrderAcceptance {
	
	private String item;

	@Override
	public String[] queryItems() {
		return new String[] {
				"テレビ", "ノートパソコン", "タブレット", "DVDプレーヤー"
		};
	}

	@Override
	public boolean order(String item) {
		
		StockManagement sm = new StockManager();
		this.item = item;
		return sm.queryStock(item) > 0;
	}

	@Override
	public String confirm(String name, String address) {
		
		StockManagement sm = new StockManager();
		return sm.ship(name, address, item);
	}

}
