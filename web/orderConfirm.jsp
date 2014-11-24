<%-- 
    Document   : orderConfirm
    Created on : Nov 20, 2014, 9:21:20 PM
    Author     : Ashley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/styles.css" rel="stylesheet" type="text/css"/>
        <title>Order Confirm</title>
    </head>
    <body>
        <div class="background">
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

        <div class="header"><a href="index.jsp"><img src="images/StoreLogo.png" alt="Store Logo Here" name="Store_logo" width="342" height="123" id="Store_logo" style="background: #FFF; display:block;" /></a>
        <!-- end .header --></div> 
        
        <div class="content">
            
        <h1>Your order has been placed!</h1>
        <p>Thank you for shopping with us!</p>
        
        <!-- end .content --></div>
        
        <!-- end .container --></div>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
        <!-- end background --></div>
    </body>
</html>
