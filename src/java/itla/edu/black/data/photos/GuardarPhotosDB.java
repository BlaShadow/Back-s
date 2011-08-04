package itla.edu.black.data.photos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class GuardarPhotosDB {
    
    Connection con;
    
    public GuardarPhotosDB(Connection con){
    
        this.con = con;
    
    }
    
    public String guardar(String id,String email,String url){
    
        String insert= "";
        
        
        try{
            
            if(id==null){
                
                Statement getId = con.createStatement();

                ResultSet idResultset = getId.executeQuery(" select id_album from albums where id_usuario = (select id_usuario from usuario where email = '"+email+"') and nombre_album = 'Photos Perfil' ");

                while(idResultset.next()){
                
                    id = idResultset.getString(1);
                    
                
                }
               
            }
            int id2 = Integer.parseInt(id);
        
            Statement query = con.createStatement();
            
            insert += ""+query.executeUpdate("insert into photos(id_album,id_usuario,url) values("+id2+",(select id_usuario from usuario where email = '"+email+"'),'"+url+"') ");
        
        }catch(Exception e){
    
            insert += ""+e;
            
        }
        
        return insert;
    }
    
}
