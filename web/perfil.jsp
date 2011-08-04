<%@page import="itla.edu.black.data.UserData"%>
<%@page import="itla.edu.black.estados.LastEstate"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="itla.edu.black.conexion.Conexion"%>
<%@page import="itla.edu.black.comentarios.ShowComentario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/homeFunctions.js"></script>
        <link href="css/preset_css.css" rel="stylesheet" media="screen">
        <link href="css/home_Style.css" rel="stylesheet" media="screen">
        
        <script language="javascript">
            
            function logout(){
                
                log = confirm("Cerrar Sesion?");
                
                if(log){
                    
                    window.location = "logout.jsp";
                    
                }
                
            }
            
            
        </script>
        
    </head>
    <body onload="unshowDiv(),ocultarComentario()">
        
        <%

        HttpSession sesion=request.getSession(false);
			
        if(sesion.getAttribute("usuario")==null || request.getParameter("email")==null){

                response.sendRedirect("index.jsp");

        }

        %>
        
        <%

            Connection con = Conexion.getConexion();

            UserData data = new UserData(con);

            String[] userData = data.getUserData(request.getParameter("email"));


        %>
        
        <div id="page">
            
            <div id="header"></div>
            
            <div id="body">
                
                <a id="logoutId" href="#" onclick="logout()"><%= session.getAttribute("userName")%> LogOut</a>
                
                
                <div id="photo_perfil"><img src="<%= userData[1] %> " width="90%">
                
                </div>
                
                <div id="estado">
                    
                    <%
                    out.println(userData[0]+userData[1]+userData[2]);
                    
                        LastEstate last = new LastEstate(con);
                        
                        ArrayList<String[]> ultimoEstado = last.lastEstate((String)session.getAttribute("usuario"),1);
                        
                        try{
                            
                            out.println(ultimoEstado.get(0)[0]);
                        //out.println(ultimoEstado.get(0)[0].toString());
                                               }catch(Exception e){out.println(e);}
                    %>
                    
                </div>
                
                <div class="clear"><hr>
                </div>
                <!------------------------------------------------------------------------->
                
                
                <div id="menu">
                    
                    <% out.println(userData[0]); %>
                    <a href="home.jsp"><div id="" class="item">Inicio</div></a>
                    <a href="javascript:void()"><div id="" class="item" onclick="unshowDiv()">Perfil</div></a>
                    <a href="javascript:void()"><div id="" class="item" onclick="showMenu('divAmigos')">Amigos</div></a>
                    <a href="Photos.jsp?user=<%= userData[0] %>"><div class="item">Photos</div></a>
                    
                </div>
                
                <div id="cuerpo">
                
                        <div id="divAmigos" name="elementos" class="blokes">
                            
                            
                        </div>
                        
                        <div id="muro" name="elementos" class="blokes">
                            
                            <% 
                            
                                ShowComentario show = new ShowComentario(con);
                            
                                ArrayList<String[]> estados = last.lastEstate((String)request.getParameter("email"),20);
                                
                                for(int i = 0;i<estados.size();i++){
                                    
                                    out.println("<div id='feedDiv' class='feedDiv'>"
                                                     + "<div class='estadosmuro'>"
                                                          + "<div id='estado_photo'>"
                                                               + "<img src='"+userData[1]+"' width='90%'>"
                                                            + "</div>"+estados.get(i)[0]+""
                                                         + "</div>"
                                                + "<div name='comentario'>");
                                    
                                    ArrayList<String[]> resultadoComentario = show.showComentario(estados.get(i)[1]);
                                    
                                    for(int indice = 0;indice<resultadoComentario.size();indice++){
                                    
                                        out.println("<div class='comentario' name='comentarios'>"
                                                         + "<div class='photo_comentario'>"
                                                         + "<img width='100%' heigth='100%' src="+resultadoComentario.get(indice)[0] +"></div> <div style='clear:both'> <p>"+resultadoComentario.get(indice)[1]+"</p>"+resultadoComentario.get(indice)[2] +"<p></p> </div></div>");
                                    
                                    }
                                    
                                    out.println("</div><form onsubmit='return false'><input type='hidden' value='"+estados.get(i)[1]+
                                            "'><textarea cols='60' maxlength='40' rows='2'></textarea><button onclick=\"comentar(this,'"+session.getAttribute("usuario")+
                                            "','"+session.getAttribute("USER_PHOTO")+"')\">Comentar</button></form><label onclick='mostrarComentarioOcultar(this)'>MostrarComentarios</label><hr></div>");
                                }

                            %>
                            
                        </div>
                            
                        <div id="photos" name="elementos" class="blokes">
                            
                            
                        </div>
                        
                </div>
                
             <div class="clear"></div>   
            </div>
            <div id="footer"><hr></div>
            
        </div>
        
    </body>
</html>
