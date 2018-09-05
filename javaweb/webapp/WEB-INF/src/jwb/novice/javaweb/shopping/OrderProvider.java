package jwb.novice.javaweb.shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import jwb.novice.javaweb.MySQLDatabase;

public class OrderProvider {
	
	
	public boolean accept(PurchaseOrder purchaseOrder) throws SQLException {
		
		MySQLDatabase database = new MySQLDatabase("jdbc/javaweb");
		Connection conn = database.connect();
		
		String orderNo = "0000001";
		
		StringBuffer insclientInfo = new StringBuffer();
		insclientInfo.append("INSERT INTO client_info (order_no, family_name, first_name, pref, city, address) VALUES ");
		insclientInfo.append("(?, ?, ?, ?, ?, ?)");
		
		PreparedStatement stmtClient = conn.prepareStatement(insclientInfo.toString());
		stmtClient.setString(1, orderNo);
		stmtClient.setString(2, purchaseOrder.getClient().getFamilyName());
		stmtClient.setString(3, purchaseOrder.getClient().getFirstName());
		stmtClient.setString(4, purchaseOrder.getClient().getPref());
		stmtClient.setString(5, purchaseOrder.getClient().getCity());
		stmtClient.setString(6, purchaseOrder.getClient().getAddress());
		
		int result = stmtClient.executeUpdate();
		
		if (result < 1) {
			
			conn.rollback();
			conn.close();
			return false;
		}
		
		Iterator<Order> iterator = purchaseOrder.getOrderList().iterator();
		int rowNo = 1;
		while (iterator.hasNext()) {
			
			Order order = iterator.next();
			StringBuffer insOrderInfo = new StringBuffer();
			insOrderInfo.append("INSERT INTO order_info (order_no, row_no, product_cd, quantity, purchase_amount) VALUES ");
			insOrderInfo.append("(?, ?, ?, ?, ?)");
			
			PreparedStatement stmtOrder = conn.prepareStatement(insOrderInfo.toString());
			stmtOrder.setString(1, orderNo);
			stmtOrder.setInt(2, rowNo++);
			stmtOrder.setString(3, order.orderedItem().getProductCd());
			stmtOrder.setInt(4, order.quantity());
			stmtOrder.setBigDecimal(5, order.purchasePrice());
			
			result = stmtOrder.executeUpdate();
			
			if (result < 1) {
				
				conn.rollback();
				conn.close();
				return false;
			}
		}
		
		conn.commit();
		conn.close();
		
		return true;
	}
}