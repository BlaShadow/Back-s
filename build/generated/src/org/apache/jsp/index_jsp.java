package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>..::Black::..</title>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/indexFunction.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/login.js\"></script>\n");
      out.write("        <link href=\"css/preset_css.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("        <link href=\"css/Style_Index.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("     </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        ");

        
        HttpSession sesion=request.getSession(false);
			
        if(sesion.getAttribute("usuario")!=null){
                response.sendRedirect("home.jsp");
        }
        
        
      out.write("\n");
      out.write("        <div id=\"page\">\n");
      out.write("            \n");
      out.write("            <div id=\"header\"></div>\n");
      out.write("            \n");
      out.write("            <div id=\"body\">\n");
      out.write("                \n");
      out.write("                <div id=\"login\" align=\"center\">\n");
      out.write("                    \n");
      out.write("                    <form onsubmit=\"return false\" name=\"loginFormulario\">\n");
      out.write("                        \n");
      out.write("                        <table>\n");
      out.write("                            \n");
      out.write("                           <!--Email Login  --> \n");
      out.write("                            <tr>\n");
      out.write("                                <td>Email</td>\n");
      out.write("                                <td>\n");
      out.write("                                <input type=\"text\" name=\"email\"/>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                           <!--Clave Login  --> \n");
      out.write("                            <tr>\n");
      out.write("                                \n");
      out.write("                                <td>Clave:</td>\n");
      out.write("                                <td>\n");
      out.write("                                <input type=\"password\" name=\"pass\"/>\n");
      out.write("                                </td>\n");
      out.write("                                \n");
      out.write("                            </tr>\n");
      out.write("                            <!--Error Login -->\n");
      out.write("                            <tr>\n");
      out.write("                                \n");
      out.write("                                <td colspan=\"2\" id=\"failLogin\" align=\"center\"></td>\n");
      out.write("                                \n");
      out.write("                            </tr>\n");
      out.write("                            <!--Button Login -->.\n");
      out.write("                            <tr align=\"center\">\n");
      out.write("                                <td></td>\n");
      out.write("                                <td align=\"center\">\n");
      out.write("                                    <button onclick=\"LoginFunction(document.loginFormulario.email.value,document.loginFormulario.pass.value)\">Log in</button>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            \n");
      out.write("                            <tr>\n");
      out.write("                                <td colspan=\"2\" align=\"right\" >\n");
      out.write("                                    <a href=\"#\" onclick=\"login();\">No Estas Registrado?</a>\n");
      out.write("                                </td>\n");
      out.write("                            \n");
      out.write("                            </tr>\n");
      out.write("                            \n");
      out.write("                        </table>\n");
      out.write("                        \n");
      out.write("                    </form>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div id=\"singin\" align=\"center\">\n");
      out.write("                    \n");
      out.write("                    <form method=\"\" onsubmit=\"return false\" name=\"registro\">\n");
      out.write("                        \n");
      out.write("                        <table border=\"2\" width=\"70%\">\n");
      out.write("                            \n");
      out.write("                            <tr>\n");
      out.write("                                \n");
      out.write("                                <td>Nombre :\n");
      out.write("                                </td>\n");
      out.write("                                \n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"text\" name=\"nombre\">\n");
      out.write("                                </td>\n");
      out.write("                                   \n");
      out.write("                                <td id=\"ErrorNombre\" class=\"tdR\">\n");
      out.write("                                </td>\n");
      out.write("                                \n");
      out.write("                            </tr>\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                            <tr>\n");
      out.write("                                \n");
      out.write("                                <td>\n");
      out.write("                                    Apellido:\n");
      out.write("                                </td>\n");
      out.write("                                \n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"text\" name=\"apellido\">\n");
      out.write("                                </td>\n");
      out.write("                                   \n");
      out.write("                                <td id=\"ErrorApellido\" class=\"tdR\">\n");
      out.write("                                </td>\n");
      out.write("                                \n");
      out.write("                            </tr>\n");
      out.write("                            \n");
      out.write("                            <tr>\n");
      out.write("                                \n");
      out.write("                                <td>Clave:\n");
      out.write("                                </td>\n");
      out.write("                                \n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"text\" name=\"clave\">\n");
      out.write("                                </td>\n");
      out.write("                                   \n");
      out.write("                                <td id=\"ErrorClave\" class=\"tdR\">\n");
      out.write("                                </td>\n");
      out.write("                                \n");
      out.write("                            </tr>\n");
      out.write("                            \n");
      out.write("                            <tr>\n");
      out.write("                                \n");
      out.write("                                <td>Repetir Clave:\n");
      out.write("                                </td>\n");
      out.write("                                \n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"text\" name=\"rclave\">\n");
      out.write("                                </td>\n");
      out.write("                                   \n");
      out.write("                                <td id=\"ErrorRClave\" class=\"tdR\">\n");
      out.write("                                </td>\n");
      out.write("                                \n");
      out.write("                            </tr>\n");
      out.write("                            \n");
      out.write("                            <tr>\n");
      out.write("                                \n");
      out.write("                                <td>Correo:\n");
      out.write("                                </td>\n");
      out.write("                                \n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"text\" name=\"mail\">\n");
      out.write("                                </td>\n");
      out.write("                                   \n");
      out.write("                                <td id=\"ErrorMail\" class=\"tdR\">\n");
      out.write("                                </td>\n");
      out.write("                                \n");
      out.write("                            </tr>\n");
      out.write("                            \n");
      out.write("                            <tr align=\"center\">\n");
      out.write("                                \n");
      out.write("                                <td colspan=\"3\">\n");
      out.write("                                    <button onclick=\"singinValidar()\">Sing in</button>\n");
      out.write("                                </td>\n");
      out.write("                            \n");
      out.write("                            </tr>\n");
      out.write("                            \n");
      out.write("                            <tr>\n");
      out.write("                                \n");
      out.write("                                <td colspan=\"3\" align=\"right\"><a href=\"#\" onclick=\"login()\">Login</a></td>\n");
      out.write("                                \n");
      out.write("                            </tr>\n");
      out.write("                            \n");
      out.write("                        </table>\n");
      out.write("                        <input type=\"hidden\" value=\"false\" id=\"mailT\">\n");
      out.write("                    </form>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div id=\"footer\"></div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
