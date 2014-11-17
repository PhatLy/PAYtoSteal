<%-- 
    Document   : products
    Created on : Oct 25, 2014, 6:22:20 PM
    Author     : Ashley, Yonas, Phat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/styles.css" rel="stylesheet" type="text/css"/>
        <title>Item Page</title>
        
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
        
        <table width="150" border="0" align="right">
            
        </table>
          <div class="header"><a href="index.jsp"><img src="images/StoreLogo.png" alt="Store Logo Here" name="Store_logo" width="342" height="123" id="Store_logo" style="background: #FFF; display:block;" /></a>
          </div>
 
          <div class="content">
          
        <h1>Pick an item to add to your cart</h1>
        <%-- yonas: 1. moved form tag out of the for loop.
                    2. replaced form submit with anchor link--%>
            <form action="CartServlet" method="post">
                <table border="1" align="center" cellpadding="20" cellspacing="0">
                    <tbody>        
                        
        <c:forEach var="item" items="${requestScope.items}">

                        <tr>
                            <td width="75px"><image src="${item.imgSrc}" width="75" height="75"></td>
                            <td width="75px">${item.itemName}</a></td>
                            <td width="75px">Price: $${item.price}</td>
                            <input type="hidden" name="${item.itemName}" value="${item.itemName}"/>
                            <td width="75px"><%--<a href="CartServlet?itemName=${item.itemName}">Add to cart</a>--%>
                            <input type="button" value="Add to cart" 
                                       onclick="location.href='CartServlet?itemName=${item.itemName}'; 
                                           return false;"/></td>
                        </tr>

        </c:forEach>

                    </tbody>
                </table>
            </form>
                        
        <span id="errNumber" class="error">
            ${msg}
        </span>
        
        <!-- end .content --></div>
        
        <!-- end .container --></div>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    <!-- end background --></div>
    </body>
</html>

