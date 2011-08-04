
package itla.edu.black.conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Conexion {
    
    //referencia conexion
    static Connection con;
    static Conexion clase;
    
    private Conexion(){
        
        try{
        
            Class.forName("com.mysql.jdbc.Driver");   
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/black", "root", "");
        
        }catch(Exception e){
        
        }
    
    }
    
    public static Connection getConexion(){
    
        if(clase==null){
        
            clase = new Conexion();
        
        }
        
        return con;
    
    }
    
    
    
    public String registrar(String nombre, String apellido,String clave,String mail){
    
        try{
            
        
            Statement insert = con.createStatement();
            
            insert.executeUpdate("insert into usuario(Nombre,Apellidos,clave,Email) values('"+nombre+"','"+apellido+"','"+clave+"','"+mail+"') ");
    
            return "ok";
        
        }catch(Exception e){
        
            return ""+e;
        
        }
        
    
    }
    //Taken
    
    
    public int checkMail(String email){
    
        int filas=0;
        
        try{
            
            Statement check = con.createStatement();
        
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
    //taken
    
    
    public int loginSession(String mail, String pass){
    
        int logT = 0;
        
        try{
        
            Statement log = con.createStatement();
            
            ResultSet logResultado = log.executeQuery("select * from usuario where email='"+mail+"' and clave='"+pass+"'");
            
            logResultado.last();
            
            logT = logResultado.getRow();
            
            return logT;
        
        }catch(Exception e){
        
        
        }
        
        
        return logT;
    }
    
    //Taken
    
    public String[] getNombre(String email){
    
        String[] nombreUsuario = {"",""};
        
        try{
        
           Statement getNombre = con.createStatement();
           
           ResultSet resultadoNombre = getNombre.executeQuery("select nombre,USER_PHOTO from usuario where email = '"+email+"' ");
           
           
           
           while(resultadoNombre.next()){
           
               nombreUsuario[0] = resultadoNombre.getString("nombre");
               nombreUsuario[1] = resultadoNombre.getString("USER_PHOTO");
           
           }
        
        }catch(Exception e){
        
        }
        
        return nombreUsuario;
    
    }
    
    //taken
    
    public String newFeed(String id, String feed){
        
        String error="";
    
        try{
            Statement newEstado = con.createStatement();

            error = "" + newEstado.executeUpdate("insert into estados(id_usuario,estado,fecha) values((select id_usuario from usuario where email = '"+id+"'),'"+feed+"',CURDATE()) ");

        }catch(Exception e){
            
            error+=e;
        
        }
        
        return error;
    
    }
    
    //taken
    
    public ArrayList lastEstate(String id,int elementos){
    
        ArrayList resultado = new ArrayList();
        
        try{
        
        Statement ultimo = con.createStatement();
        
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
    
    //taken
    
    public String saveInfo(String nombre,String apellido,String oldpass,String newpass,String estado,String sexo,String mail){
    
        String algo ="0";
        
        try{
        
            Statement save = con.createStatement();
            //algo = "update usuario set nombre='"+nombre+"' apellido='"+apellido+"' clave='"+newpass+"' sexo='"+sexo+"' estado='"+estado+"' where email='"+mail+"' and clave='"+oldpass+"' ";
            
            algo = ""+save.executeUpdate("update usuario set nombre='"+nombre+"', apellidos='"+apellido+"', clave='"+newpass+"', sexo='"+sexo+"', estado='"+estado+"' where email='"+mail+"' and clave='"+oldpass+"' ");
        
        }catch(Exception e){
        
            algo+=e;
        }
        
        return algo;
    
    }
    
    //taken
    
    public String addComentario(String id,String comentario,String usuario){
    
        String resultado = "";
        
        try{
        
            Statement agregarComentario = con.createStatement();
            
            resultado = ""+agregarComentario.executeUpdate("insert into comentario_estado(id_estado,id_usuario,comentario) values('"+id+"',(select id_usuario from usuario where email='"+usuario+"'),'"+comentario+"')");
        
            
        
        }
        catch(Exception e){
        
            resultado = ""+e;
            
        }
        
        return resultado;
    }
    
    //taken
    
    public ArrayList showComentario(String id_estado){
    
        ArrayList<String[]> resultados = new ArrayList();
        
        try{
        
            Statement query =con.createStatement();
            
            ResultSet resul = query.executeQuery("select user_photo,email,comentario from usuario join comentario_estado where id_estado = '"+id_estado+"' ");
        
            while(resul.next()){
            
                String[] filas = {"","",""};
                filas[0] = resul.getString(1);
                filas[1] = resul.getString(2);
                filas[2] = resul.getString(3);
                
                resultados.add(filas);
                
            
            }
            
        }catch(Exception e){}
    
        
        return resultados;
    }
    
    //taken
    
    public ArrayList news(){
    
        ArrayList resultado = new ArrayList();
        
        String query = "select email,nombre from usuario where id_usuario = (select id_elemento from news where tipo = 1) ";
        
        try{
        
            
            Statement noticias = con.createStatement();
            
            ResultSet result = noticias.executeQuery("select email,nombre from usuario ");
            
            while(result.next()){
            
                String[] rows = {"",""};
                rows[0] = result.getString(1);
                rows[1] = result.getString(2);
                
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
