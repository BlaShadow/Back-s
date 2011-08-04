
package itla.edu.black.data.albums;

import java.sql.Connection;
import java.sql.Statement;


public class CrearAlbum {
    
    Connection con;
    
    public CrearAlbum(Connection con){
    
        this.con = con;
    
    }
    
    
    public String crearAlbum(String nombre,String email){
    
        String resultado = "";
    
        try{
        
            Statement statement = con.createStatement();
            
            int consulta = statement.executeUpdate("insert into albums(nombre_album,id_usuario) values('"+nombre+"' ,'(select id_usuario from usuario where email = '"+email+"')')");
        
            resultado +=consulta+"";
        }catch(Exception e){
        
            resultado += ""+e;
        
        }
    
        return resultado;
        
    }
    
}
