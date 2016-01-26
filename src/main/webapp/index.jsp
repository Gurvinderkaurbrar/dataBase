<%-- 
    Document   : index
    Created on : 26-Jan-2016, 4:29:40 PM
    Author     : c0665336
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbsample.DBSample"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%=DBSample.getTable()%>
       Hello World!
    </body>
</html>
