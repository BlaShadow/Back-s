package itla.edu.black.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserData {
    
    Connection con;
    
    public UserData(Connection con){
    
        this.con = con;
        
    }
    
    public String[] getUserData(String email){
    
        String[] data = {"","",""};
        
        try{
        
            Statement getData = con.createStatement();
            
            ResultSet query = getData.executeQuery("select email,user_photo,nombre from usuario where email = '"+email+"' ");
            
            while(query.next()){
            
            data[0]=query.getString(1);
            data[1]=query.getString(2);
            data[2]=query.getString(3);
            }
        }catch(Exception e){
            
            data[0]=""+e;
        }
        
        return data;
        
    }
    
    
    public String[] getUserData(String email,int algo){
    
        String[] data = {"","","","",""};
        
        try{
        
            Statement getData = con.createStatement();
            
            ResultSet query = getData.executeQuery("select email,user_photo,nombre,sexo,estado from usuario where email = '"+email+"' ");
            
            while(query.next()){
            
            data[0]=query.getString(1);
            data[1]=query.getString(2);
            data[2]=query.getString(3);
            data[2]=query.getString(4);
            data[2]=query.getString(5);
            }
        }catch(Exception e){
            
            data[0]=""+e;
        }
        
        return data;
        
    }
}
