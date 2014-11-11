<%-- 
    Document   : products
    Created on : Oct 25, 2014, 6:22:20 PM
    Author     : Ashley, Yonas, Phat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/styles.css" rel="stylesheet" type="text/css"/>
        <title>Item Page</title>
        
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div class="container">
        <table width="100" border="0" align="right">
            <tr>
              <td>Account</td>
              <td><form name="form1" method="post" action="">
                <input type="text" name="acctName" id="acctName">
              </form></td>
            </tr>
            <tr>
              <td>Password</td>
              <td><form name="form2" method="post" action="">
                <input type="text" name="password" id="password">
              </form></td>
            </tr>
        </table>
        
        <h1>Pick an item to add to your cart</h1>
             
        <c:forEach var="item" items="${requestScope.items}">
            <form action="CartServlet" method="post">
                <table border="1" align="center" cellpadding="20" cellspacing="0">
                    <tbody>
                        <tr>
                            <td width="75px"><image src="${item.imgSrc}" width="75" height="75"></td>
                            <td width="75px">${item.itemName}</a></td>
                            <td width="75px">Price: $${item.price}</td>
                            <input type="hidden" name="${item.itemName}" value="${item.itemName}"/>
                            <input type="hidden" name="itemCount" value="${requestScope.itemCount}"/>
                            <td width="75px"><input type="submit" name="Add To Cart"/></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </c:forEach>
        <span id="errNumber" class="error">
            ${msg}
        </span>
    </body>
</html>

