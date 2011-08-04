//alert("caego le file");

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
                catch(E) {xmlhttp=false;}
        }
        if (!xmlhttp && typeof XMLHttpRequest!='undefined') {xmlhttp=new XMLHttpRequest();}

        return xmlhttp;
    
}

function newFeed(id,feed){
    
    feedHTTP = getHTTP();
    
    feedHTTP.open("GET","newFeed.jsp?id="+id+"&feed="+feed,true);
    
    feedHTTP.onreadystatechange = function(){
        
        
        if(feedHTTP.status==200 && feedHTTP.readyState==4){
            
            alert(feedHTTP.responseText);
            
            if(feedHTTP.responseText==1){
                
                document.getElementById("estado").innerHTML="<font color='white'>"+feed+"</font>";
                
                div = document.createElement("div");
                div.className="estadosmuro";
                div.innerHTML="<font color='white'><div>"+document.getElementById("photo_perfil").innerHTML+"</div>"+feed+"</font>";
                
                document.getElementById("muro").appendChild(div);
                
                
            }else{
                
                alert("Error");
                
            }
            
        }
        
    };
    
    feedHTTP.send(null);
    
}

function showMenu(block){
    
    elementos = document.getElementById("cuerpo").getElementsByTagName("div");
    
    for(indice = 0 ; indice < elementos.length;indice++){
        
        elementos[indice].style.display="none";
        
    }
   
    try{
        
        document.getElementById(block).style.display="block";
        
    }catch(e){
       
        
    }
}

function unshowDiv(){
    
    divs = document.getElementById("cuerpo").getElementsByTagName("div");
    
    for(i = 0 ; i < divs.length; i ++){
        
        divs[i].style.display="none";
        
    }
    
    document.getElementById("muro").style.display="block";
    
    divsHijo = document.getElementById("muro").getElementsByTagName("div");
    
    for(e=0;e<divsHijo.length;e++){
    
        divsHijo[e].style.display="block";
   
    }
   
}

function contadora(){
    
    document.getElementById("contador").innerHTML=(document.getElementById("feed").value).length-80;
   
}

function saveInfo(nombre,apellido,oldpass,newpass,sexo,estado,mail){
    
    saveInfoHTTP = getHTTP();
    
    saveInfoHTTP.open("GET","saveInfo.jsp?nombre="+nombre+"&apellido="+apellido
        +"&oldpass="+oldpass+"&newpass="+newpass+"&sexo="+sexo+"&estado="+estado+"&mail="+mail,true);
    
    saveInfoHTTP.onreadystatechange = function(){
        
        if(saveInfoHTTP.status==200 && saveInfoHTTP.readyState==4){
            
            if(saveInfoHTTP.responseText==0){
                
                alert("Error");
                
            }
            
            if(saveInfoHTTP.responseText==1){
                
                alert("Cambios Realizado");
                document.info.reset();
                
            }
            
        }
        
    }
    
    saveInfoHTTP.send(null);
    
}

function comentar(algo,usuario,photo){
    
    id = algo.parentNode[0].value;
    
    comentario = algo.parentNode[1].value;
    
    comentarioHTTP = getHTTP();
    
    comentarioHTTP.open("GET","addComentario.jsp?id="+id+"&comentario="+comentario+"&usuario="+usuario,true);
    
    comentarioHTTP.onreadystatechange = function(){
        
        if(comentarioHTTP.status==200 && comentarioHTTP.readyState==4){
            
            if(parseInt(comentarioHTTP.responseText)==1){
                
                divComentarios = document.createElement("div");
                
                divComentarios.innerHTML="<div class='comentario'>\n\
                                                <div class='photo_comentario'>\n\
                                                        <img src='"+photo+"' width='100%'>\n\
                                                </div>\n\
                                                    <div style='clear:both'><p>"+usuario+"</p>"+
                                                    "<p>"+comentario+"</p>\n\
                                        </div>";
                
                algo.parentNode.parentNode.childNodes[1].appendChild(divComentarios);
                
                algo.parentNode.reset();
                
            }else{
             
             alert("Error");
                
            }
            
        }
        
    }
    
    comentarioHTTP.send(null);
}

function ocultarComentario(){
    
    abuelo = document.getElementsByName("comentario");
   
    for(o = 0 ;o<abuelo.length;o++){
        
        abuelo.item(o).style.display="none";
       
    }
    
}

function mostrarComentarioOcultar(id){
    
    divComentario = id.parentNode;
    
    if(divComentario.childNodes[1].style.display=="none"){
    
        divComentario.childNodes[1].style.display="block";
    
    }
    else{
        
        divComentario.childNodes[1].style.display="none";
        
    }

}

function news(){
    
    newsHTTP = getHTTP();
    
    newsHTTP.open("GET","noticias.jsp",true);
    
    newsHTTP.onreadystatechange =  function(){
    
        if(newsHTTP.status==200 && newsHTTP.readyState==4){
            
            newsDiv = document.getElementById("newsDiv");
            
            newsDiv.style.display="block";
            newsDiv.innerHTML="";
            
            resultado = newsHTTP.responseText.split("_");
            
            for(r= 0 ; r<(resultado.length)-1;r++){
                
                div = document.createElement("div");
                div.innerHTML="<div class='news'><a href='perfil.jsp?email="+resultado[r].split(",")[0]+"'><img src='"+resultado[r].split(",")[2]+"'><label>"+resultado[r].split(",")[0]+"</a></label>\n\
                                <label>"+resultado[r].split(",")[1]+"</label> </a><div>";
                newsDiv.appendChild(div);
               
            }
            
        }
    
    }
    
    newsHTTP.send(null);
    
}