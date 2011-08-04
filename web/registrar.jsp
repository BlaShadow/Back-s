<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="itla.edu.black.conexion.Conexion" %> 
<%@page import="itla.edu.black.registrarusuario.Registrar" %> 

<%
    
    Connection con = Conexion.getConexion();
    
    Registrar registro = new Registrar(con);
    
   String respuesta = registro.registrar(request.getParameter("nombre"),
                                request.getParameter("apellido"),
                                request.getParameter("clave"),
                                request.getParameter("email"));
   out.println(respuesta);
   
%>