<%@page import="itla.edu.black.data.photos.GuardarPhotosDB"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.tomcat.util.http.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.tomcat.util.http.fileupload.FileItemFactory"%>
<%@page import="itla.edu.black.data.photos.GuardarPhoto"%>
<%@page import="itla.edu.black.conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%
            String nombre = "";
            
            Connection con = Conexion.getConexion();
            
            GuardarPhoto photoG = new GuardarPhoto(con);
            GuardarPhotosDB photosDB = new GuardarPhotosDB(con);
            
            nombre = photoG.guardarPhoto(request.getParameter("email"))+"-"+request.getParameter("id");
            
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            List items = upload.parseRequest(request);
            
            for (Object item : items) {
                
               FileItem uploaded = (FileItem) item;
              
               if (!uploaded.isFormField()) {
                  
               String[] nameFile = (uploaded.getName()).split("\\.");
               String ext = nameFile[nameFile.length-1];
               
               String file ="";
               file= application.getRealPath("/")+"data-photos\\";
          
                  File fichero = new File(file+nombre+"."+ext);
                  uploaded.write(fichero);
                  
                  String resultado = photosDB.guardar(request.getParameter("id"),request.getParameter("email"),"data-photos/"+nombre+"."+ext);
                  
                  //out.println(resultado);
                  
                  response.sendRedirect("photos_details.jsp?id="+request.getParameter("id")+"&email="+request.getParameter("email") +"");
                  
               } else {
                  
               }
            } 
        %>

