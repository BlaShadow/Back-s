package itla.edu.black.comentario;

import java.sql.Connection;
import java.sql.Statement;

public class AddComentario {
    
    Connection con;
    
    public AddComentario(Connection con){
    
        this.con = con;
    
    }
     
    public String addComentario(String id,String comentario,String usuario){
    
        String resultado = "";
        
        try{
        
            Statement agregarComentario = (Statement) con.createStatement();
            
            resultado = ""+agregarComentario.executeUpdate("insert into comentario_estado(id_estado,id_usuario,comentario) values('"+id+"',(select id_usuario from usuario where email='"+usuario+"'),'"+comentario+"')");
        
            
        
        }
        catch(Exception e){
        
            resultado = ""+e;
            
        }
        
        return resultado;
    }
    
    
}
