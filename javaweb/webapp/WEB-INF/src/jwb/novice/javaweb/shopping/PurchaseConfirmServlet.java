package jwb.novice.javaweb.shopping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jwb.novice.javaweb.Client;

@WebServlet("/shopping/purchaseConfirm")
public class PurchaseConfirmServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		// 顧客情報生成
		Client client = new Client();
		client.setFamilyName(req.getParameter("familyName"));
		client.setFirstName(req.getParameter("firstName"));
		client.setZipCode(req.getParameter("zipCode"));
		client.setPref(req.getParameter("pref"));
		client.setCity(req.getParameter("city"));
		client.setAddress(req.getParameter("address"));
		
		// 注文情報取得
		Cart cart = (Cart)session.getAttribute(Cart.class.getSimpleName());
		List<Order> orderList = new ArrayList<Order>();
		
		Iterator<Order> iterator = cart.iterator();
		while (iterator.hasNext()) {
			
			orderList.add(iterator.next());
		}
		
		// 注文書生成
		PurchaseOrder purchaseOrder = new PurchaseOrder(client, orderList);
		
		// 注文書をDB登録
		
		
		req.getRequestDispatcher("/shopping/orderResult.jsp").forward(req, res);
	}
}
