<%-- 
    Document   : cart
    Created on : Oct 25, 2014, 6:22:40 PM
    Author     : Ashley, Yonas, Phat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/styles.css" rel="stylesheet" type="text/css"/>
        <title>Shopping Cart</title>
    </head>
    
    <body>
    <div class="background">
        <div class="container">
            <table width="150" border="0" align="right">
                <tr>
                    <td>
                    </td>
                    <td>
                        <form name="form1" method="post" action="">  
                        <table> 
                            <tr>
                              <td>Account</td>
                              <td>
                                <input type="text" name="acctName" id="acctName">
                              </td>
                            </tr>
                            <tr>
                              <td>Password</td>
                              <td><input type="text" name="password" id="password"></td>
                            </tr>
                            <tr>
                                <td>
                                    <input type='button' value="Login" onclick="validateLogin(this.form)"/>
                                </td>
                                <td>
                                    <a href="createAccount.jsp"> Create Account</a>
                                </td>
                            </tr>
                    </table>  
                    </form>
                </td>
            </tr>
        </table>
        <div class="header"><a href="index.jsp"><img src="images/StoreLogo.png" alt="Store Logo Here" name="Store_logo" width="342" height="123" id="Store_logo" style="background: #FFF; display:block;" /></a>

           <!-- end .header --></div>
        <div class="content">

        <h1>Your Cart</h1>
        
        <form action="CheckoutServlet" method="post">
            <table border="1" align="center" cellpadding="20" cellspacing="0">
                <tbody>
                    <c:forEach var="itm" items="${sessionScope.cart.items}">
                    <tr>
                        <td><image src="images/${itm.item.imgSrc}" width="75" height="75"></td>
                        <td>${itm.item.itemName}</td>
                        <td>Price: $${itm.item.price}</td>
                        <td>Quantity: ${itm.quantity}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br><input type="submit" value="Checkout"/>
        </form>
        
        <form action="IndexServlet" method="post">
            <tr>
                <td><br><input type="submit" value="Continue Shopping"/></td>
            </tr>
        </form>
        <!-- end .content --></div>
        
        <!-- end .container --></div>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    <!-- end background --></div>
    </body>
</html>
