/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itla.edu.black.nombre;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class ObtenerNombre {
    
    Connection con;
    
    public ObtenerNombre(Connection con){
    
        this.con = con;
        
    }
     
    public String[] getNombre(String email){
    
        String[] nombreUsuario = {"",""};
        
        try{
        
           Statement getNombre = (Statement) con.createStatement();
           
           ResultSet resultadoNombre = getNombre.executeQuery("select nombre,USER_PHOTO from usuario where email = '"+email+"' ");
           
           
           
           while(resultadoNombre.next()){
           
               nombreUsuario[0] = resultadoNombre.getString("nombre");
               nombreUsuario[1] = resultadoNombre.getString("USER_PHOTO");
           
           }
        
        }catch(Exception e){
        
        }
        
        return nombreUsuario;
    
    }
    
    
}
