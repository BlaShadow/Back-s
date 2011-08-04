<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="itla.edu.black.conexion.Conexion"%>
<%@page import="itla.edu.black.noticias.Noticias"%>

<%

    Connection con = Conexion.getConexion();
    
    Noticias news = new Noticias(con);
    
    ArrayList<String[]> noticias = news.news();
    
    for(int i = 0;i<noticias.size();i++){
    
        out.println(noticias.get(i)[0] +","+ noticias.get(i)[1]);
        out.println("_");
    
    } 

%>

