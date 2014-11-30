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
            <div class="header"><a href="IndexServlet"><img src="images/StoreLogo.png" alt="Store Logo Here" name="Store_logo" width="342" height="123" id="Store_logo" style="background: #FFF; display:block;" /></a>

        <!-- end .header --></div>
        <div class="content">

        <h1>Your Cart</h1>
        
        <%--table border 0 align center put for loop in one column--%>
        <c:forEach var="LineItem" items="${sessionScope.cart.items}">
        <form action="CartServlet" method="post">
            <table border="1" align="center" cellpadding="20" cellspacing="0">
                <tbody>
                    <tr>
                        <%--<td><image src="images/${LineItem.imgSrc}" width="75" height="75"></td>--%>
                        <td width="300px">${LineItem.itemName}</td>
                        <td width="100px">Price: $${LineItem.price}</td>
                        <%--<td>Price: $${(requestScope.item.discount / 100) * requestScope.item.price}</td>--%>
                        <td width="100px">Quantity: <input type="text" name="txtQuantity" value="${LineItem.quantity}" style="width: 30px;"/></td>
                        <input type="hidden" name="hidAction" value="update" />
                        <input type="hidden" name="hidSku" value="${LineItem.itemSku}" />
                        <td><input type="submit" name="btnUpdate" value="Update"/> </td>
                    </tr>
                </tbody>
            </table>
        </form>
        </c:forEach>
        
        <p>Set quantity to 0 to remove item from cart.</p>


        <%-- yonas: to facilitate the submission for bthUpdate, i've moved btnCheckout into a separate form
        we'll get the cart details from the session variable.--%>
        <form action="CheckoutServlet" method="post">
            <input type="submit" name="btnCheckout" value="Checkout"/>
        </form>

        <form action="IndexServlet" method="post">
            <input type="submit" value="Continue Shopping"/>
        </form>
        <!-- end .content --></div>

        <!-- end .container --></div>
        <%@include file="../includes/footer.jsp" %>
        <!-- end background --></div>
    </body>
</html>