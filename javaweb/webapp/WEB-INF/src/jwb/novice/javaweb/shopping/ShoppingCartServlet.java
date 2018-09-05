package jwb.novice.javaweb.shopping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shopping/addItem")
public class ShoppingCartServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		// Cartオブジェクトをセッションから復元
		Cart cart = (Cart)req.getSession().getAttribute(Cart.class.getSimpleName());
		
		// ViewModelの生成と商品の詳細情報の取得
		ItemDetailViewModel vm = new ItemDetailViewModel(req.getParameter("currentItemCd"));
		Item item = vm.itemDetail();
		
		// Cartに商品を追加してセッションに保存
		cart = cart == null ? vm.shoppingCart() : cart;
		cart.add(item);
		req.getSession().setAttribute(Cart.class.getSimpleName(), cart);
		vm.saveCart(cart);
		req.setAttribute(ItemDetailViewModel.class.getSimpleName(), vm);
		
		// itemDetail.jspにフォワード
		req.setAttribute("cartVisiblity", true);
		req.getRequestDispatcher("/shopping/itemDetail.jsp").forward(req, res);
	}
}