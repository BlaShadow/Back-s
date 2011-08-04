<%@page import="itla.edu.black.photos.GetPhotos"%>
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
        <title>PHOTOS</title>
        <script type="text/javascript" src="js/homeFunctions.js"></script>
        <link href="css/preset_css.css" rel="stylesheet" media="screen">
        <link href="css/photosDetalles_style.css" rel="stylesheet" media="screen">
        <script type="text/javascript" src="js/prototype.js"></script>
        <script type="text/javascript" src="js/scriptaculous.js?load=effects,builder"></script>
        <script type="text/javascript" src="js/lightbox.js"></script>
        <script type="text/javascript" src="js/photosDetalles.js"></script>
        <link rel="stylesheet" href="css/lightbox.css" type="text/css" media="screen" />
        
    </head>
    <body onload="">
        
        <div id="upload" align="center">
                     
            <div align="center" id="divUpload">
                
                <form enctype="multipart/form-data" method="post" action="imagenSubir.jsp?id=<%=request.getParameter("id")%>&email=<%=request.getParameter("email")%>" name="formulario" onsubmit="return imgCheck(document.formulario.photo.value)">

                      <input type="file" name="photo"><br>
                      <input type="hidden" name="extencion" value="algo">
                      <button>Subir</button>
                      

                  </form>
            </div>
                              
            </div>
       <div id="upload_padre" onclick="showDivs()"></div> 
                      
        <%

        HttpSession sesion=request.getSession(false);
			
        if(sesion.getAttribute("usuario")==null || request.getParameter("user")==""){

                response.sendRedirect("index.jsp");

        }
       
        Connection con = Conexion.getConexion();

            UserData data = new UserData(con);

            String[] userData = data.getUserData(request.getParameter("email"));

        %>
        <div id="page">
            
            <div id="header">
                
            </div>
            
            <div id="body">
                
                <a id="logoutId" href="#" onclick="logout()"><%= session.getAttribute("userName")%> LogOut</a>
                
                
                <div id="photo_perfil"><img src="<%= userData[1]%> " width="90%">
                
                </div>
                
                
                <div class="clear"><hr>
                    
                </div>
                <!------------------------------------------------------------------------->
                <div id="menu">
                    
                    
                    <a href="home.jsp"><div id="" class="item" onclick="unshowDiv()">Perfil</div></a>
                    
                </div>
                
                <div id="cuerpo" align="center">
                    
                    <% if(session.getAttribute("usuario").equals(request.getParameter("email"))){ %>
                        <button onclick="showDivs()">Subir Photos</button> 
                    <% } %>    
                    
                        <div id="albunes" style="" align="center">
                       
                            
                            
                        <%
                        
                            GetPhotos albun = new GetPhotos(con);
                            
                            ArrayList<String[]> phtoos = albun.getPhotos(request.getParameter("id"));
                            
                            for(int o = 0;o<phtoos.size();o++){
                                
                                out.println("<div><a href='"+phtoos.get(o)[0]+"' rel=\"lightbox[photos]\">");
                                out.println("<img src='"+phtoos.get(o)[0] +"'>");
                                out.println("</a></div>");
                            
                            }
                            

                        %>
                        <div style="clear:both"></div>
                        </div>
                        
                </div>
                 
                         <div style="clear:both"></div>        
               
        <!----Footer---->                 
        <div id="footer">
            
            
            
        </div>
            
    </body>
</html>

