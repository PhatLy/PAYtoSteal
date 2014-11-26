<%-- 
    Document   : checkout
    Created on : Oct 25, 2014, 6:24:01 PM
    Author     : Ashley, Yonas, Phat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/styles.css" rel="stylesheet" type="text/css"/>
        <title>Checkout Page</title>
       
    </head>
    <body>
    <div class="background">
        <div class="container">
            <table width="150" border="0" align="right">
                <tr>
                    <td>
                      <p><a href="./cart.jsp"><img src="images/cart.png" alt="cart" width="40" height="40" longdesc="cart" align="right"></a></p>
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
            <h1>Checkout</h1>
        
            <p>Your total is: $${requestScope.cost}</p>
            <p>Enter payment information:</p>
         
            <form action="PaymentServlet" method="post">
                <table align="center">
                    <tbody>
                        <tr>
                            <td><img src="images/cards.png" width="168" height="25"/></td>
                        </tr>
                        <tr>
                            <td>Name on Card:</td>
                            <td><input type="text" name="name" autocomplete="off"/></td>
                        </tr>
                        <tr>
                            <td>Card Number:</td>
                            <td><input type="text" name="num" autocomplete="off"/></td>
                        </tr>
                        <tr>
                            <td>Security Code:</td>
                            <td><input type="text" name="code" autocomplete="off"/></td>
                        </tr>
                    </tbody>
                </table>
                <input type="submit" value="Place Order"/>
            </form>
        
        <!-- end .content --></div>
        
        <!-- end .container --></div>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>

    <!-- end background --></div>
    </body>
</html>
