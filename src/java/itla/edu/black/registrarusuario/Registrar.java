package itla.edu.black.registrarusuario;

import java.sql.Connection;
import java.sql.Statement;

public class Registrar {
    
    private Connection con;
    
    public Registrar(Connection conexion){
        
        this.con = conexion;
    
    }
    
    public String registrar(String nombre, String apellido,String clave,String mail){
    
        int p = 66;
        
        try{
            
        
            Statement insert = (Statement)con.createStatement();
            
            p= insert.executeUpdate("insert into usuario(Nombre,Apellidos,clave,Email) values('"+nombre+"','"+apellido+"','"+clave+"','"+mail+"') ");
    
            return ""+p;
        
        }catch(Exception e){
        
            return ""+e;
        
        }
    }
    
    
}
