package itla.edu.black.estados;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LastEstate {
    
    Connection con;
    
    public LastEstate(Connection con){
    
        this.con = con;
    
    }
    
    
    public ArrayList lastEstate(String id,int elementos){
    
        ArrayList resultado = new ArrayList();
        
        try{
        
        Statement ultimo = (Statement) con.createStatement();
        
        ResultSet resultadoUltimo = ultimo.executeQuery("select estado,id_estado from estados where id_usuario = (select id_usuario from usuario where email = '"+id+"')  order by id_estado desc limit "+elementos+" ");
        
        while(resultadoUltimo.next()){
        
            String resultadoString[]={resultadoUltimo.getString("estado"),resultadoUltimo.getString("id_estado")};
            resultado.add(resultadoString);
        
        }    
        
        }catch(Exception e){
        
            String resultadoString[]={""+e,""+e};
            resultado.add(resultadoString);
            
        }
        return resultado;
    
    }
    
    
    
}
