/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.82
 * Generated at: 2023-11-08 00:30:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.passagens;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class create_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"pt-br\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("<link rel=\"icon\" href=\"./assets/img/book-2-fill.svg\" type=\"image/svg\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../../assets/css/style.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" />\r\n");
      out.write("<title>Booki | Criar Passagem</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<main>\r\n");
      out.write("		<header class=\"header\">\r\n");
      out.write("			<h1>Criar Passagem</h1>\r\n");
      out.write("		</header>\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"container py-3\">\r\n");
      out.write("            <form action=\"../../passagem-create\">\r\n");
      out.write("	            <h2 class=\"text-center\">Criar</h2>\r\n");
      out.write("	            <div class=\"form-group mb-3\">\r\n");
      out.write("	                <label for=\"nome\" class=\"form-label\">\r\n");
      out.write("	                    Nome\r\n");
      out.write("	                </label>\r\n");
      out.write("	                <input type=\"text\" id=\"nome\" name=\"nome\" class=\"form-control\" value=\"\" />\r\n");
      out.write("	            </div>\r\n");
      out.write("	            \r\n");
      out.write("	            <div class=\"form-group mb-3\">\r\n");
      out.write("	                <label for=\"dataDeChegada\" class=\"form-label\">\r\n");
      out.write("	                    dataDeChegada\r\n");
      out.write("	                </label>\r\n");
      out.write("	                <input type=\"date\" id=\"dataDeChegada\" name=\"dataDeChegada\" class=\"form-control\" value=\"\" />\r\n");
      out.write("	            </div>\r\n");
      out.write("	            \r\n");
      out.write("	            <div class=\"form-group mb-3\">\r\n");
      out.write("	                <label for=\"dataDeSaida\" class=\"form-label\">\r\n");
      out.write("	                   dataDeSaida\r\n");
      out.write("	                </label>\r\n");
      out.write("	                <input type=\"date\" id=\"dataDeSaida\" name=\"dataDeSaida\" class=\"form-control\" value=\"\" />\r\n");
      out.write("	            </div>\r\n");
      out.write("	            \r\n");
      out.write("	             <div class=\"form-group mb-3\">\r\n");
      out.write("	                <label for=\"dataDeRetorno\" class=\"form-label\">\r\n");
      out.write("	                dataDeRetorno\r\n");
      out.write("	                </label>\r\n");
      out.write("	                <input type=\"date\" id=\"dataDeRetorno\" name=\"dataDeRetorno\" class=\"form-control\" value=\"\" />\r\n");
      out.write("	            </div>\r\n");
      out.write("	            \r\n");
      out.write("	            <div class=\"form-group mb-3\">\r\n");
      out.write("	                <label for=\"preco\" class=\"form-label\">\r\n");
      out.write("	                    Preço\r\n");
      out.write("	                </label>\r\n");
      out.write("	                <input type=\"number\" id=\"preco\" name=\"preco\" class=\"form-control\" step=\"0.01\" value=\"\" />\r\n");
      out.write("	            </div>\r\n");
      out.write("	            \r\n");
      out.write("	             <div class=\"form-group mb-3\">\r\n");
      out.write("	                <label for=\"id_passagem\" class=\"form-label\">\r\n");
      out.write("	                   informe o id existente do Aeroporto da qual essa passagem pertence\r\n");
      out.write("	                </label>\r\n");
      out.write("	                <input type=\"text\" id=\"id_aeroporto\" name=\"id_aeroporto\" class=\"form-control\" value=\"\" />\r\n");
      out.write("	            </div>\r\n");
      out.write("	            \r\n");
      out.write("	            \r\n");
      out.write("	\r\n");
      out.write("	            <button type=\"submit\" class=\"btn btn-primary\">\r\n");
      out.write("	                Enviar\r\n");
      out.write("	            </button>\r\n");
      out.write("	            <a href=\"../../passagem\" class=\"btn btn-danger\" style=\"margin-left: 10px\">\r\n");
      out.write("	                Cancelar\r\n");
      out.write("	            </a>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("		\r\n");
      out.write("    </main>\r\n");
      out.write("    \r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("	<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"></script>\r\n");
      out.write("	<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"></script>\r\n");
      out.write("	<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>\r\n");
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
