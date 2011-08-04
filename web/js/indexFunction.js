////////Ajax

function getHTTP(){
    
    var xmlhttp=false;
	
        try
        {
                xmlhttp=new ActiveXObject("Msxml2.XMLHTTP");
        }
        catch(e)
        {
                try
                {
                        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                }
                catch(E) { xmlhttp=false; }
        }
        if (!xmlhttp && typeof XMLHttpRequest!='undefined') { xmlhttp=new XMLHttpRequest(); }

        return xmlhttp;
    
}

function insertarDB(nombre,apellido,clave,mail){
    
    httpObjeto = getHTTP();
    
    httpObjeto.open("GET","registrar.jsp?nombre="+nombre+"&apellido="+apellido+"&clave="+clave+"&email="+mail,true);
    
    httpObjeto.onreadystatechange=function(){
        
        if(httpObjeto.status==200 && httpObjeto.readyState==4){
            
            if(parseInt(httpObjeto.responseText)==1){
                
                login_.style.display="block";
                singin_.style.display="none";
                alert("Registrado");
                document.registro.reset();
                
                
            }else{
             
             alert("Internal Error");
             alert(httpObjeto.responseText);
                
            }
        }
        
    }
    
    httpObjeto.send(null);
    
}

function checkMail(nombre,apellido,clave,mail){
    
    httpObjetoCH = getHTTP();
    
    httpObjetoCH.open("GET","checkMail.jsp?email="+mail,true);
    
    httpObjetoCH.onreadystatechange = function(){
        
        if(httpObjetoCH.status==200 && httpObjetoCH.readyState==4){
            
            if(httpObjetoCH.responseText!=0){
                
                document.getElementById("ErrorMail").innerHTML="Mail Utilizado";
                
            }else{
                
                document.getElementById("ErrorMail").innerHTML="";
                insertarDB(nombre,apellido,clave,mail);
                
                
            }
            
        }
        
    }
    
    httpObjetoCH.send(null);
    
}

function LoginFunction(email,pass){
    
    document.getElementById("failLogin").innerHTML="<img src='img/login.gif'>";
    
    httpLogin = getHTTP();
    
    httpLogin.open("GET","login_session.jsp?email="+email+"&pass="+pass,true);
    
    httpLogin.onreadystatechange = function(){
        
        if(httpLogin.status==200 && httpLogin.readyState==4){
            
            if(httpLogin.responseText==0){
                
                document.getElementById("failLogin").innerHTML="<font size='5' color='white'>Datos Incorectos</font>";
                
            }else{
             
                window.location="home.jsp";
                
            }
            
        }
        
    }
    httpLogin.send(null);   
}