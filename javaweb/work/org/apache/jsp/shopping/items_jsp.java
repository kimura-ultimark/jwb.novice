/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.10
 * Generated at: 2018-08-25 14:55:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.shopping;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jwb.novice.javaweb.shopping.Item;
import java.util.List;
import jwb.novice.javaweb.shopping.ItemsViewModel;
import jwb.novice.javaweb.shopping.ItemSummaryView;

public final class items_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("jwb.novice.javaweb.shopping.ItemSummaryView");
    _jspx_imports_classes.add("jwb.novice.javaweb.shopping.Item");
    _jspx_imports_classes.add("jwb.novice.javaweb.shopping.ItemsViewModel");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function selectCode(selectedCode) {\r\n");
      out.write("\tdocument.getElementById(\"selectedCode\").value = selectedCode\r\n");
      out.write("\tdocument.itemSelect.submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function shoppingCartView() {\r\n");
      out.write("\tdocument.location.href = \"shoppingCartView.jsp\";\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("table {\r\n");
      out.write("\twidth : 65%;\r\n");
      out.write("\tborder-collapse : collapse;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("thead tr {\r\n");
      out.write("\tbackground-color : #80cfcf;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("td {\r\n");
      out.write("\tborder-bottom : 1px solid #242424; \r\n");
      out.write("\tline-height : 1.00rem;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".currency {\r\n");
      out.write("\ttext-align : right;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<title>取扱商品一覧</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

	ItemsViewModel vm = new ItemsViewModel();
	List<Item> items = vm.itemList();
	
      out.write("\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<col width=\"50%\"/>\r\n");
      out.write("\t\t<col width=\"50%\"/>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td><h2>取扱商品一覧</h2></td>\r\n");
      out.write("\t\t\t<td style=\"text-align: right\">\r\n");
      out.write("\t\t\t\t<button id=\"shoppingCartView\" type=\"button\" onclick=\"shoppingCartView()\">ショッピングカートを見る</button>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<form method=\"post\" action=\"itemDetail\" name=\"itemSelect\">\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<col width=\"15%\"/>\r\n");
      out.write("\t\t\t<col width=\"45%\"/>\r\n");
      out.write("\t\t\t<col width=\"25%\"/>\r\n");
      out.write("\t\t\t<col width=\"15%\"/>\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>商品コード</td>\r\n");
      out.write("\t\t\t\t\t<td>商品名</td>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: right;\">単価</td>\r\n");
      out.write("\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t");

				for (Item item : items) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( item.getProductCd() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( item.getProductdNm() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"currency\">");
      out.print( item.getUnitPrice() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"currency\"><button type=\"button\" onclick=\"selectCode('");
      out.print( item.getProductCd() );
      out.write("')\">詳細</button></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

				}
				
      out.write("\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"selectedCode\" id=\"selectedCode\">\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
