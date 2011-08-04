<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" import="itla.edu.black.conexion.Conexion"%>
<%@page session="true" import="itla.edu.black.nombre.ObtenerNombre"%>
<%@page session="true" import="itla.edu.black.login.Login"%>

<%

    Connection con = Conexion.getConexion();
    
    ObtenerNombre nombre = new ObtenerNombre(con);
    
    Login log = new Login(con);
    
    int resultados = log.loginSession(request.getParameter("email"),request.getParameter("pass"));

    out.println(resultados);
    
    if(resultados>0){
    
        HttpSession sesion=request.getSession();

        sesion.setAttribute("usuario",request.getParameter("email"));
        sesion.setAttribute("userName",nombre.getNombre(request.getParameter("email"))[0]);
        sesion.setAttribute("USER_PHOTO",nombre.getNombre(request.getParameter("email"))[1]);

        response.sendRedirect("home.jsp");
    }
    
%>