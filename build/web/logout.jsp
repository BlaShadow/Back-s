<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>

<%

    HttpSession session_ = request.getSession(false);
    
    session.invalidate();
    

    response.sendRedirect("index.jsp");
    
%>