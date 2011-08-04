<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="itla.edu.black.conexion.Conexion"%>
<%@page import="itla.edu.black.noticias.Noticias"%>

<%

    Connection con = Conexion.getConexion();
    
    Noticias news = new Noticias(con);
    
    ArrayList<String[]> resultado = news.news();
    
    for(int i = 0; i<resultado.size();i++ ){
    
        out.println(resultado.get(i)[0]+","+resultado.get(i)[1]+","+resultado.get(i)[2]+","+resultado.get(i)[3]);
        out.println("_");
    
    }

%>
