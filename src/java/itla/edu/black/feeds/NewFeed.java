package itla.edu.black.feeds;

import java.sql.Connection;
import java.sql.Statement;

public class NewFeed {
    
    Connection con;
    
    public NewFeed(Connection con){
    
        this.con = con;
    
    }
    
    public String newFeed(String id, String feed){
        
        String error="";
    
        try{
            Statement newEstado = (Statement) con.createStatement();

            error = "" + newEstado.executeUpdate("insert into estados(id_usuario,estado,fecha) values((select id_usuario from usuario where email = '"+id+"'),'"+feed+"',CURDATE()) ");

        }catch(Exception e){
            
            error+=e;
        
        }
        
        return error;
    
    }
    
    
}
