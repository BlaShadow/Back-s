
package itla.edu.black.photos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GetPhotos {
    
    Connection con;
    
    public GetPhotos(Connection con){
    
        this.con = con;
    
    }
    
    public ArrayList getPhotos(String id_album){
    
        ArrayList photos = new ArrayList();
        
        try{
        
            Statement query = con.createStatement();
            
            ResultSet resultado = query.executeQuery("select url,id_photo from photos where id_album = '"+id_album+"' ");
            
            while(resultado.next()){
            
                String[] photo = {"",""};
                
                photo[0] = resultado.getString(1);
                photo[1] = resultado.getString(2);
                
                photos.add(photo);
            
            }
        
        }catch(Exception e){
        
        }
        
        return photos;
    
    }
    
}
