function showDivs(){
    
    divPadre = document.getElementById("upload_padre");
    divHijo = document.getElementById("upload");
    
    if(divPadre.style.display=="block"){
    
        divPadre.style.display="none";
        divHijo.style.display="none";
    
    }else{
        
        divPadre.style.display="block";
        divHijo.style.display="block";
        
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

