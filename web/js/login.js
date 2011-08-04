//javacript index


//switch logon singin
function login(){
    
    
    login_ = document.getElementById("login");
    singin_ = document.getElementById("singin");
    
    
    if(singin_.style.display=="block"){
        
        login_.style.display="block";
        singin_.style.display="none";
        
    }else{
        
        login_.style.display="none";
        singin_.style.display="block";
        
    }
    
    
}

//validar los datros
function singinValidar(){
   
    form = document.registro;
    nombre = form.nombre.value;
    apellido = form.apellido.value;
    clave = form.clave.value;
    rclave = form.rclave.value;
    mail = form.mail.value;
    
    errorNombre = document.getElementById("ErrorNombre");
    errorApellido = document.getElementById("ErrorApellido");
    errorClave = document.getElementById("ErrorClave");
    errorReClave = document.getElementById("ErrorRClave");
    errorMail = document.getElementById("ErrorMail");
    
    errorNombre.innerHTML="";
    errorApellido.innerHTML="";
    errorClave.innerHTML="";
    errorReClave.innerHTML="";
    errorMail.innerHTML="";
    
    if(nombre==""){
        
        errorNombre.innerHTML="<font color='white'>Campo Vacio</font>";
        
    }
    
    if(apellido==""){
        
        errorApellido.innerHTML="<font color='white'>Campo Vacio</font>";
        
    }
    
    if(clave==""){
        
        errorClave.innerHTML="<font color='white'>Campo Vacio</font>";
        
    }
    
    if(rclave==""){
        
        errorReClave.innerHTML="<font color='white'>Campo Vacio</font>";
        
    }else{
        
        if(clave!=rclave){
            
            errorReClave.innerHTML="<font color='white'>Las claves no coinciden</font>";
            
        }
        
    }
   
   if(!validateEmail(mail)){
       
       errorMail.innerHTML="<font color='white'>Correo Invalido</font>";    
   }
   
     
    if(nombre!="" && apellido!="" && clave.length>4 &&  rclave!="" && clave==rclave && validateEmail(mail)){

        errorMail.innerHTML="<img src='img/loaderLogin.gif'>";
        checkMail(nombre,apellido,clave,mail);

    }


}

//validar email
function validateEmail(elementValue){  
   var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;  
   return emailPattern.test(elementValue);  
 }


