
package itla.edu.black.albunes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GetAlbuns {
    
    Connection con; 
    
    public GetAlbuns(Connection con){
    
        this.con = con;
    
    }
    
    
    public ArrayList getAlbuns(String email){
    
        ArrayList<String[]> albunes = new ArrayList();
        
        try{
            Statement albun = con.createStatement();
            
            ResultSet result = albun.executeQuery("select * from albums where id_usuario = (select id_usuario from usuario where email = '"+email+"')");
            
            while(result.next()){
            
                String[] datos = {"","",""};
                
                datos[0] = result.getString(1);
                datos[1] = result.getString(2);
                datos[2] = result.getString(3);
                albunes.add(datos);
            
            }
            
                    }
        catch(Exception e){
        
        
        }
        return albunes;
    }
    
}
