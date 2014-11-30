<%-- 
    Document   : productList
    Created on : Nov 24, 2014, 11:42:59 AM
    Author     : Yonas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product list</title>
    </head>
    <body>
        
        <table  align="center">
                    <tbody>        
                        <c:forEach var="item" items="${requestScope.items}">
                        <tr>
                            <td>sku: ${item.sku}"</td>
                            <td>Image source: ${item.imgSrc}"</td>
                            <td>Item name: ${item.itemName}</td>
                            <td>Item price: ${item.price}</td>
                            <td><input type="button" name="btnDelete" value="Delete" 
                                       onclick="location.href='AdminServlet?itemName=${item.sku}&Action=Delete'"/></td>
                            <td><input type="button" name="btnUpdate" value="Update" 
                                       onclick="location.href='AdminServlet?itemName=${item.sku}&Action=Update'"/></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
        
    </body>
</html>
