function showChange(){
    
    padre = document.getElementById("photo_perfil_padre");
    hijo = document.getElementById("photo_perfil_hijo");
    
    if(padre.style.diplay=="block"){
        
        padre.style.display="none";
        hijo.style.display="none";
        
    }else{
     
     padre.style.display="block";
     hijo.style.display="block";
        
    }
    
}

function imgCheck(value){
    
    value = value.split(".");
    value = value[value.length-1];
    value = value.toLowerCase();
    
    if(value=="png" || value=="jpg" || value=="gif"){
        
        document.formulario.extencion.value=value;
        
        alert(document.formulario.extencion.value);
        return true;
        
    }else{
        
        alert("Formato Desconosido");
        return false;
        
    }
    
}


function crearAlbum(){
    
    contenedor = document.getElementById("albunes");
    
    nombreAlbun = prompt("Nombre de albun ?");
    
    window.location="crearAlbum.jsp?nombre="+nombreAlbun+"&email="+document.getElementById("page").className+" ";
    
    
}

