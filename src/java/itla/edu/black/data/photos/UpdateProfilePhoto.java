
package itla.edu.black.data.photos;

import java.sql.Connection;
import java.sql.Statement;

public class UpdateProfilePhoto {
    
    Connection con;
    
    public UpdateProfilePhoto(Connection con){
    
        this.con = con;
    
    }
    
    public void updatePhoto(String email,String url){
    
        try{
        
            Statement query = con.createStatement();
            
            query.executeUpdate("update usuario set USER_PHOTO = '"+url+"' where email = '"+email+"' ");
        
        }catch(Exception e){
        
        }
    
    }
    
}
