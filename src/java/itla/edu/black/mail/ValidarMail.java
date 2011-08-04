package itla.edu.black.mail;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class ValidarMail {
    
    Connection con;
    
    public ValidarMail(Connection con){
    
        this.con = con;
    
    }
    
    public int checkMail(String email){
    
        int filas=0;
        
        try{
            
            Statement check = (Statement) con.createStatement();
        
            ResultSet resultado = check.executeQuery("select email from usuario where email='"+email+"'");
        
            while(resultado.next()){
            
                filas++;
            
            }
            
            resultado.last();
            
            return filas;
            
        }
        catch(Exception e){
        
        }
        
        return filas;
    
    }
    
}
