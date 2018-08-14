package jwb.novice.javaweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jwb.novice.javaweb.shopping.ItemDetailViewModel;

@WebServlet("/shopping/itemDetail")
public class ItemDetailServlet extends HttpServlet {
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		String itemCd = req.getParameter("selectedCode");
		ItemDetailViewModel vm = new ItemDetailViewModel(itemCd);
		
		req.setAttribute(ItemDetailViewModel.class.getSimpleName(), vm);
		req.getRequestDispatcher("/shopping/itemDetail.jsp").forward(req, res);
	}
}