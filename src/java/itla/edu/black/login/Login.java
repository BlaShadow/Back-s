
package itla.edu.black.login;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class Login {
    
    Connection con;
    
    public Login(Connection con){
    
        this.con = con;
    
    }
    
    public int loginSession(String mail, String pass){
    
        int logT = 0;
        
        try{
        
            Statement log = (Statement) con.createStatement();
            
            ResultSet logResultado = log.executeQuery("select * from usuario where email='"+mail+"' and clave='"+pass+"'");
            
            logResultado.last();
            
            logT = logResultado.getRow();
            
            return logT;
        
        }catch(Exception e){
        
        
        }
        
        
        return logT;
    }
    
}
