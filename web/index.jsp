<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>..::Black::..</title>
        <script type="text/javascript" src="js/indexFunction.js"></script>
        <script type="text/javascript" src="js/login.js"></script>
        <link href="css/preset_css.css" rel="stylesheet" media="screen">
        <link href="css/Style_Index.css" rel="stylesheet" media="screen">
     </head>
    
    <body>
        <%
        
        HttpSession sesion=request.getSession(false);
			
        if(sesion.getAttribute("usuario")!=null){
                response.sendRedirect("home.jsp");
        }
        
        %>
        <div id="page">
            
            <div id="header"></div>
            
            <div id="body">
                
                <div id="login" align="center">
                    
                    <form onsubmit="return false" name="loginFormulario">
                        
                        <table>
                            
                           <!--Email Login  --> 
                            <tr>
                                <td>Email</td>
                                <td>
                                <input type="text" name="email"/>
                                </td>
                            </tr>
                           <!--Clave Login  --> 
                            <tr>
                                
                                <td>Clave:</td>
                                <td>
                                <input type="password" name="pass"/>
                                </td>
                                
                            </tr>
                            <!--Error Login -->
                            <tr>
                                
                                <td colspan="2" id="failLogin" align="center"></td>
                                
                            </tr>
                            <!--Button Login -->.
                            <tr align="center">
                                <td></td>
                                <td align="center">
                                    <button onclick="LoginFunction(document.loginFormulario.email.value,document.loginFormulario.pass.value)">Log in</button>
                                </td>
                            </tr>
                            
                            <tr>
                                <td colspan="2" align="right" >
                                    <a href="#" onclick="login();">No Estas Registrado?</a>
                                </td>
                            
                            </tr>
                            
                        </table>
                        
                    </form>
                    
                </div>
                
                <div id="singin" align="center">
                    
                    <form method="" onsubmit="return false" name="registro">
                        
                        <table border="2" width="70%">
                            
                            <tr>
                                
                                <td>Nombre :
                                </td>
                                
                                <td>
                                    <input type="text" name="nombre">
                                </td>
                                   
                                <td id="ErrorNombre" class="tdR">
                                </td>
                                
                            </tr>
                            
                            
                            <tr>
                                
                                <td>
                                    Apellido:
                                </td>
                                
                                <td>
                                    <input type="text" name="apellido">
                                </td>
                                   
                                <td id="ErrorApellido" class="tdR">
                                </td>
                                
                            </tr>
                            
                            <tr>
                                
                                <td>Clave:
                                </td>
                                
                                <td>
                                    <input type="text" name="clave">
                                </td>
                                   
                                <td id="ErrorClave" class="tdR">
                                </td>
                                
                            </tr>
                            
                            <tr>
                                
                                <td>Repetir Clave:
                                </td>
                                
                                <td>
                                    <input type="text" name="rclave">
                                </td>
                                   
                                <td id="ErrorRClave" class="tdR">
                                </td>
                                
                            </tr>
                            
                            <tr>
                                
                                <td>Correo:
                                </td>
                                
                                <td>
                                    <input type="text" name="mail">
                                </td>
                                   
                                <td id="ErrorMail" class="tdR">
                                </td>
                                
                            </tr>
                            
                            <tr align="center">
                                
                                <td colspan="3">
                                    <button onclick="singinValidar()">Sing in</button>
                                </td>
                            
                            </tr>
                            
                            <tr>
                                
                                <td colspan="3" align="right"><a href="#" onclick="login()">Login</a></td>
                                
                            </tr>
                            
                        </table>
                        <input type="hidden" value="false" id="mailT">
                    </form>
                    
                    
                    
                </div>
                
            </div>
            
            <div id="footer"></div>
            
        </div>
        
    </body>
</html>
