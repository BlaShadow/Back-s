
package itla.edu.black.comentarios;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ShowComentario {
    
    Connection con;
    
    public ShowComentario(Connection con){
    
        this.con = con;
    
    }
    
     public ArrayList showComentario(String id_estado){
    
        ArrayList<String[]> resultados = new ArrayList();
        
        try{
        
            Statement query =(Statement) con.createStatement();
            
            ResultSet resul = query.executeQuery("select u.user_photo,u.email,c.comentario from usuario u join comentario_estado c where id_estado = '"+id_estado+"' and u.id_usuario = c.id_usuario ");
        
            while(resul.next()){
            
                String[] filas = {"","",""};
                filas[0] = resul.getString(1);
                filas[1] = resul.getString(2);
                filas[2] = resul.getString(3);
                
                resultados.add(filas);
                
            
            }
            
        }catch(Exception e){}
    
        
        return resultados;
    }
    
    
}
