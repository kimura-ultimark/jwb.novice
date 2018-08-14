package jwb.novice.javaweb.items;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jwb.novice.javaweb.MySQLDatabase;
import jwb.novice.javaweb.shopping.Item;
import jwb.novice.javaweb.shopping.ItemSummaryView;

public class ItemManager implements ItemSummaryView {

	@Override
	public List<Item> itemList() {
		
		List<Item> itemList = new ArrayList<Item>();
		
		MySQLDatabase database = new MySQLDatabase("jdbc/javaweb");
		
		try {
			
			Connection conn = database.connect();
			String sql = "SELECT product_cd, product_nm, unit_price FROM product";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				Item item = new Item();
				item.setProductCd(rs.getString("product_cd"));
				item.setProductdNm(rs.getString("product_nm"));
				item.setUnitPrice(rs.getBigDecimal("unit_price"));
				
				itemList.add(item);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return itemList;
	}
}