package itla.edu.black.update_user_info;

import java.sql.Connection;
import java.sql.Statement;


public class UpdateInfo {
    
    Connection con;
    
    public UpdateInfo(Connection con){
    
        this.con = con;
    
    }
    
    public String saveInfo(String nombre,String apellido,String oldpass,String newpass,String estado,String sexo,String mail){
    
        String algo ="0";
        
        try{
        
            Statement save = (Statement) con.createStatement();
            
            algo = ""+save.executeUpdate("update usuario set nombre='"+nombre+"', apellidos='"+apellido+"', clave='"+newpass+"', sexo='"+sexo+"', estado='"+estado+"' where email='"+mail+"' and clave='"+oldpass+"' ");
        
        }catch(Exception e){
        
            algo+=e;
        }
        
        return algo;
    
    }
    
    
}
