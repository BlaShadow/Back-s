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
			
        if(sesion.getAttribute("usuario")==null){

                response.sendRedirect("index.jsp");

        }
        
        Connection con =Conexion.getConexion(); 
        
        UserData data = new UserData(con);

            String[] userData = data.getUserData((String)session.getAttribute("usuario"));

        %>
        
        
        <div id="page">
            
            <div id="header"></div>
            
            <div id="body">
                
                <a id="logoutId" href="#" onclick="logout()"><%= session.getAttribute("userName")%> LogOut</a>
                
                
                <div id="photo_perfil"><img src="<%=userData[1]%> " width="90%"></div>
                <div id="nuevo">
                    
                    <form onsubmit="return false" name="feedForm">
                        
                        <textarea rows="3" cols="57" id="feed" name="textArea" maxlength="80" onkeyup="contadora()"></textarea><br>
                        <label id="contador">80</label>
                               <button onclick="newFeed('<%= session.getAttribute("usuario")%>',document.feedForm.textArea.value);document.feedForm.reset()">Publicar</button>
                        
                    </form>
                    
                </div>
                <div id="estado">
                    
                    <%
                    
                        
                        
                        LastEstate last = new LastEstate(con);
                        
                        ArrayList<String[]> ultimoEstado = last.lastEstate((String)session.getAttribute("usuario"),1);
                        
                        try{
                            
                            out.println(ultimoEstado.get(0)[0]);
                        //out.println(ultimoEstado.get(0)[0].toString());
                                               }catch(Exception e){}
                    %>
                    
                </div>
                
                <div class="clear"><hr></div>
                <!------------------------------------------------------------------------->
                
                
                <div id="menu">
                    
                    
                    <a href="javascript:void()"><div id="" class="item" onclick="showMenu('inicio')">Inicio</div></a>
                    <a href="javascript:void()"><div id="" class="item" onclick="unshowDiv()">Perfil</div></a>
                    <a href="javascript:void()"><div id="" class="item" onclick="showMenu('divAmigos')">Informacion</div></a>
                    <a href="Photos.jsp?user=<%= session.getAttribute("usuario")%> "><div id="" class="item">Photos</div></a>
                    <a href="javascript:void()"><div id="" class="item" onclick="showMenu('configurar')">Confirgurar</div></a>
                    
                </div>
                
                <div id="cuerpo">
                
                        <div id="divAmigos" name="elementos" class="blokes" align="center">
                            
                            <% 
                            
                            
                                String[] userDataFull = data.getUserData((String)session.getAttribute("usuario"),1);
                            


                                %>
                                
                                
                                <table border="3" width="300px">
                                    
                                    
                                    <tr >
                                        
                                        <td colspan="2"><img src="<%=userDataFull[1]%>" width="200px;" heigth="150px"></td>
                                        
                                    </tr>
                                    
                                    <tr>
                                        
                                        <td></td>
                                        <td><%=userDataFull[0]%></td>
                                        
                                    </tr>
                                    
                                    <tr>
                                        
                                        <td></td>
                                        <td><%=userDataFull[2]%></td>
                                        
                                    </tr>
                                    
                                    <tr>
                                        
                                        <td></td>
                                        <td><%=userDataFull[3]%></td>
                                        
                                    </tr>
                                    
                                    <tr>
                                        
                                        <td></td>
                                        <td><%=userDataFull[4]%></td>
                                        
                                    </tr>
                                    
                                    
                                </table>
                            
                        </div>
                        
                        <div id="muro" name="elementos" class="blokes">
                            
                            <% 
                            
                                ShowComentario show = new ShowComentario(con);
                            
                                ArrayList<String[]> estados = last.lastEstate((String)session.getAttribute("usuario"),20);
                                
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
                                            "','"+userData[1]+"')\">Comentar</button></form><label onclick='mostrarComentarioOcultar(this)'>MostrarComentarios</label><hr></div>");
                                }

                            %>
                            
                        </div>
                            
                        <div id="configurar" name="elementos" class="blokes" align="center">
                            
                            <form onsubmit="return false" name="info">
                                
                                <table align="center" width="70%">
                                    
                                    <tr>
                                        
                                        <td>Nombre</td>
                                        <td><input type="text" name="nombre" maxlength="40"><br></td>
                                        
                                    </tr>
                                    
                                    <tr>
                                        
                                        <td>apellido</td>
                                        <td><input type="text" name="apellido" maxlength="40"><br></td>
                                        
                                    </tr>
                                    
                                    <tr>
                                        
                                        <td>Vieja Clave</td>
                                        <td><input type="password" name="oldpass"><br></td>
                                        
                                    </tr>
                                    
                                    <tr>
                                        
                                        <td>Nueva Clave</td>
                                        <td><input type="password" name="Newpass"><br></td>
                                        
                                    </tr>
                                    
                                    <tr>
                                        
                                        <td>sexo</td>
                                        <td><select name="sexo">
                                                
                                                <option value="0"></option>
                                                <option value="hombre">hombre</option>
                                                <option value="mujer">mujer</option>
                                                
                                            </select><br></td>
                                        
                                    </tr>
                                    
                                    <tr>
                                        
                                        <td>Estado Civil</td>
                                        <td>
                                            
                                            <select name="estadoCivil">
                                                
                                                <option value="0"></option>
                                                <option value="casado">Casado</option>
                                                <option value="soltero">Soltero</option>
                                                <option value="una relacion">Una Relacion</option>
                                                <option value="viudo">Viudo</option>
                                                
                                            </select>
                                            <br>
                                        </td>
                                        
                                        
                                    </tr>
                                    
                                    <tr>
                                        
                                        <td colspan="2" align="center"><button onclick="saveInfo(document.info.nombre.value,
                                            document.info.apellido.value,
                                            document.info.oldpass.value,
                                            document.info.Newpass.value,
                                            document.info.estadoCivil.options[document.info.estadoCivil.selectedIndex].text,
                                            document.info.sexo.options[document.info.sexo.selectedIndex].text,'<%= session.getAttribute("usuario")%>')">Guardar</button></td>
                                        
                                    </tr>
                                    
                                </table>
                                
                            </form>
                            
                        </div>
                            
                        <div id="photos" name="elementos" class="blokes">
                            
                            <a href="uploadPhotoPerfil.jsp">Cambiar Photo de Perfil</a>
                            
                        </div>
                        
                        <div id="inicio" name="elementos" class="blokes" align="center">
                            
                                    <button onclick="news()">News</button>
                                    <div id="newsDiv"></div>
                            
                        </div>
                
                </div>
                
             <div class="clear"></div>   
            </div>
            <div id="footer"><hr></div>
            
        </div>
        
    </body>
</html>
