<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/homeFunctions.js"></script>
        <link href="css/preset_css.css" rel="stylesheet" media="screen">
        <link href="css/upload.css" rel="stylesheet" media="screen">
        
    </head>
    <body onload="">
        
        <%

        HttpSession sesion=request.getSession(false);
			
        if(sesion.getAttribute("usuario")==null){

                response.sendRedirect("index.jsp");

        }

        %>
        
        
        <div id="page">
            
            <div id="header"></div>
            
            <div id="body">
                
                <a id="logoutId" href="#" onclick="logout()"><%= session.getAttribute("userName")%> LogOut</a>
                
                
                <div id="photo_perfil"><img src="<%= session.getAttribute("USER_PHOTO")%> " width="90%">
                
                </div>
                
                <div class="clear"><hr>
                </div>
                <!------------------------------------------------------------------------->
                
                
                <div id="menu">
                    
                    
                    <a href="home.jsp"><div id="" class="item" onclick="showMenu('inicio')">Inicio</div></a>
                    <a href="home.jsp"><div id="" class="item" onclick="unshowDiv()">Perfil</div></a>
                    
                </div>
                
                <div id="cuerpo">
                
                        <div id="divUpload" align="center">
                            
                            <form action="subir.jsp" enctype="MULTIPART/FORM-DATA">
                                
                                <input type="file" name="photo"><br>
                                <button>Subir</button>
                                
                            </form>
                            
                        </div>
                
                </div>
                
             <div class="clear"></div>   
            </div>
            <div id="footer"><hr></div>
            
        </div>
        
    </body>
</html>
