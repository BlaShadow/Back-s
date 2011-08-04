package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class uploadPhotoPerfil_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/homeFunctions.js\"></script>\n");
      out.write("        <link href=\"css/preset_css.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("        <link href=\"css/upload.css\" rel=\"stylesheet\" media=\"screen\">\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body onload=\"\">\n");
      out.write("        \n");
      out.write("        ");


        HttpSession sesion=request.getSession(false);
			
        if(sesion.getAttribute("usuario")==null){

                response.sendRedirect("index.jsp");

        }

        
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div id=\"page\">\n");
      out.write("            \n");
      out.write("            <div id=\"header\"></div>\n");
      out.write("            \n");
      out.write("            <div id=\"body\">\n");
      out.write("                \n");
      out.write("                <a id=\"logoutId\" href=\"#\" onclick=\"logout()\">");
      out.print( session.getAttribute("userName"));
      out.write(" LogOut</a>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <div id=\"photo_perfil\"><img src=\"");
      out.print( session.getAttribute("USER_PHOTO"));
      out.write(" \" width=\"90%\">\n");
      out.write("                \n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"clear\"><hr>\n");
      out.write("                </div>\n");
      out.write("                <!------------------------------------------------------------------------->\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <div id=\"menu\">\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    <a href=\"home.jsp\"><div id=\"\" class=\"item\" onclick=\"showMenu('inicio')\">Inicio</div></a>\n");
      out.write("                    <a href=\"home.jsp\"><div id=\"\" class=\"item\" onclick=\"unshowDiv()\">Perfil</div></a>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div id=\"cuerpo\">\n");
      out.write("                \n");
      out.write("                        <div id=\"divUpload\" align=\"center\">\n");
      out.write("                            \n");
      out.write("                            <form action=\"subir.jsp\" enctype=\"MULTIPART/FORM-DATA\">\n");
      out.write("                                \n");
      out.write("                                <input type=\"file\" name=\"photo\"><br>\n");
      out.write("                                <button>Subir</button>\n");
      out.write("                                \n");
      out.write("                            </form>\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                \n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("             <div class=\"clear\"></div>   \n");
      out.write("            </div>\n");
      out.write("            <div id=\"footer\"><hr></div>\n");
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
