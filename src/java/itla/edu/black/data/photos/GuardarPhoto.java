
package itla.edu.black.data.photos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class GuardarPhoto {
    
    Connection con;
    
    public GuardarPhoto(Connection con){
    
        this.con = con;
    
    }
    
    public String guardarPhoto(String email){
    
        String dir = "esta en blanco";
        String nombreQ = "";
        String id = "";
    
        try{
        
            Statement query = con.createStatement();
            
            ResultSet nombre = query.executeQuery("select id_usuario from usuario where email = '"+email+"' ");
            
            while(nombre.next()){
            
                nombreQ=nombre.getString(1);
            
            }
            
            ResultSet photo_id = query.executeQuery("select (id_photo)+1 from photos order by id_photo desc limit 1 ");
            
            while(photo_id.next()){
            
                id = photo_id.getString(1);
            
            }
            
            dir = nombreQ+"-"+id;
            
        
        }catch(Exception e){
        
            dir = e+"";
            
        }
        
        
        return dir;
    }
    
}
