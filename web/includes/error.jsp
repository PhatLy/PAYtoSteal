<%-- 
    Document   : error
    Created on : Nov 30, 2014, 4:27:01 PM
    Author     : Yonas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Aw aw aw, snap:)</h1>
        Our dedicated engineers are working on resolving this issue.
        
        Error message:<br>
        ${requestScope['javax.servlet.error.message']}
    </body>
</html>
