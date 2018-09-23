package jwb.novice.javaweb.shopping;

import java.io.IOException;
import java.sql.SQLException;
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
		
		Client client = new Client();
		client.setFamilyName(req.getParameter("familyName"));
		client.setFirstName(req.getParameter("firstName"));
		client.setZipCode(req.getParameter("zipCode"));
		client.setPref(req.getParameter("pref"));
		client.setCity(req.getParameter("city"));
		client.setAddress(req.getParameter("address"));
		
		Cart cart = (Cart)session.getAttribute(Cart.class.getSimpleName());
		List<Order> orderList = new ArrayList<Order>();
		
		Iterator<Order> iterator = cart.iterator();
		while (iterator.hasNext()) {
			
			orderList.add(iterator.next());
		}
		
		PurchaseOrder purchaseOrder = new PurchaseOrder(client, orderList);
		OrderProvider provider = new OrderProvider();
		
		String orderNo = "";
		
		try {
			orderNo = provider.accept(purchaseOrder);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (orderNo == null) {
			
			req.getRequestDispatcher("/shopping/confirmPurchase.jsp").forward(req, res);
			return;
		}
		
		session.removeAttribute(Cart.class.getSimpleName());
		req.setAttribute("orderNo", orderNo);
		req.getRequestDispatcher("/shopping/orderResult.jsp").forward(req, res);
	}
}
