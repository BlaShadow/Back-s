package itla.edu.black.noticias;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Noticias {
    
    Connection con;
    
    public Noticias(Connection con){
    
        this.con = con;
    
    }
    
    public ArrayList news(){
    
        ArrayList resultado = new ArrayList();
        
        String query = "select email,nombre from usuario ";
        
        try{
        
            Statement noticias = (Statement) con.createStatement();
            
            ResultSet result = noticias.executeQuery("select email,nombre,user_photo,id_usuario from usuario ");
            
            while(result.next()){
            
                String[] rows = {"","","",""};
                rows[0] = result.getString(1);
                rows[1] = result.getString(2);
                rows[2] = result.getString(3);
                rows[3] = result.getString(4);
                
                resultado.add(rows);   
            }
        
        }catch(Exception e){
        
            String errore[] = {"",""};
            errore[0] = ""+e;
            errore[1] = query;
            
            resultado.add(errore);
        
        }
    
        
        return resultado;
    }
    
}
