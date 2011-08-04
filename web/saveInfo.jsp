<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" import="itla.edu.black.conexion.Conexion"%>
<%@page session="true" import="itla.edu.black.update_user_info.UpdateInfo"%>


<%

    Connection con = Conexion.getConexion();
    
    UpdateInfo info =  new UpdateInfo(con);
    
    out.println(info.saveInfo(request.getParameter("nombre"),request.getParameter("apellido"),
                            request.getParameter("oldpass"), request.getParameter("newpass")
                            ,request.getParameter("sexo"),request.getParameter("estado")
                            ,request.getParameter("mail")));

    
%>

