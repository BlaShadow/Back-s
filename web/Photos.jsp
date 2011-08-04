<%@page import="java.util.ArrayList"%>
<%@page import="itla.edu.black.albunes.GetAlbuns"%>
<%@page import="itla.edu.black.conexion.Conexion"%>
<%@page import="itla.edu.black.data.UserData"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/photos.js"></script>
        <link href="css/preset_css.css" rel="stylesheet" media="screen">
        <link href="css/photos_style.css" rel="stylesheet" media="screen">
        
        <script>
            
            function logout(){
                
                log = confirm("Cerrar Sesion?");
                
                if(log){
                    
                    window.location = "logout.jsp";
                    
                }
                
            }
            
        </script>
        
    </head>
    <body onload="">
        
        <%

        HttpSession sesion=request.getSession(false);
			
        if(sesion.getAttribute("usuario")==null || request.getParameter("user")==""){

                response.sendRedirect("index.jsp");

        }
       
        Connection con = Conexion.getConexion();

            UserData data = new UserData(con);

            String[] userData = data.getUserData(request.getParameter("user"));

        %>
        <div id="page" class="<%=request.getParameter("user")%>">
            
            
            <!-------------------------------------------------------------->
            <div id="photo_perfil_padre">
                </div>
                <div id="photo_perfil_hijo" align="center">
                    
                    <form enctype="multipart/form-data" action="photoperfilchange.jsp?id=nulo&email=<%=request.getParameter("user")%>" method="post" name="formulario" onsubmit="return imgCheck(document.formulario.photoP.value)">
                        
                        <input type="file" name="photoP"><br>
                        <button onclick="">Subir</button>
                        
                    </form>
                    
                </div> 
                <!-------------------------------------------------------------->
            
            <div id="header"></div>
            
            <div id="body">
                
                <a id="logoutId" href="" onclick="logout()"><%= session.getAttribute("userName")%> LogOut</a>
                
                
                <div id="photo_perfil"><img src="<%= userData[1]%> " width="90%">
                
                </div>
                
                
                <div class="clear"><hr>
                    
                </div>
                <!------------------------------------------------------------------------->
                <div id="menu">
                    
                    
                    <a href="home.jsp"><div id="" class="item">Perfil</div></a>
                    <a href="javascirpt:void()" onclick="showChange()"><div id="" class="item">Photo Perfil</div></a>
                    
                </div>
                
                <div id="cuerpo" align="center">
                        
                        <div id="albunes" style="" align="center">
                            
                            
                            
                        <%
                        
                            GetAlbuns albun = new GetAlbuns(con);
                            
                            ArrayList<String[]> albunes = albun.getAlbuns(userData[0]);
                            
                            for(int o = 0;o<albunes.size();o++){
                                
                                out.println("<a href='photos_details.jsp?id="+albunes.get(o)[0]+"&email="+userData[0]+"' class='albunes_uno'><div>");
                                out.println("<label style='clear:both'>"+albunes.get(o)[1]+"</label>");
                                out.println("</div></a>");
                            
                            }
                            

                        %>
                        <div style="clear:both"></div>
                        </div>
                        
                         <button onclick="crearAlbum()">New Albun</button>   
                         
                </div>
                 
                         <div style="clear:both"></div>        
                        
        <div id="footer"></div>
            
    </body>
</html>

