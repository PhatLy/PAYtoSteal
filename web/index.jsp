
<%-- 
    Document   : products
    Created on : Oct 26, 2014, 12:12:53 PM
    Author     : Ashley, Yonas, Phat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/styles.css" rel="stylesheet" type="text/css"/>
        <title>Welcome!</title>
    </head>
    <body>
        <div class="background">
        <%--<jsp:include page="WEB-INF/jspf/timerScript.jsp" /><%--move this to each item in product --%>
        <div class="container">
            <table width="150" border="0" align="right">
                <tr>
                    <td><p><a href="./cart.jsp"><img src="images/cart.png" alt="cart" width="40" height="40" longdesc="cart" align="right"></a></p></td>
                    <td>
                        <c:if test="${customer == null}">
                            <form name="formLogin" method="post" action="CustomerServlet"><!--if valid, make table invisible-->  
                                <table> 
                                    <tr>
                                        <td>Email</td>
                                        <td><input type="text" name="acctName" id="acctName"></td>
                                    </tr>
                                    <tr>
                                        <td>Password</td>
                                        <td><input type="password" name="password" id="password">
                                             </br><div class="error">${requestScope.msg}</div></td>
                                    </tr>
                                    <tr>
                                        <td><input type="hidden" name="hidAction" value="Login"/>
                                            <input type='submit' value="Login" /></td>
                                        <td><a href="customer.jsp"> Create Account</a></td>
                                    </tr>
                                </table>  
                            </form> 
                        </c:if>

                        <c:if test="${customer != null}">
                            <p>Welcome, ${customer.firstName}</p>
                             <a href="customer.jsp"> Update Account</a>
                        </c:if>
                    </td>
                </tr>
            </table>
            <table width="150" border="0" align="right">
            </table>
            <div class="header"><a href="IndexServlet"><img src="images/StoreLogo.png" alt="Store Logo Here" name="Store_logo" width="342" height="123" id="Store_logo" style="background: #FFF; display:block;" /></a>
        </div>

        <div class="content">
 
            <c:forEach var="item" items="${requestScope.items}">
            <form action="CartServlet" method="post">
                <table border="1" align="center" cellpadding="20" cellspacing="0">
                    <tbody>   
                        <tr>
                            <td wdith="100px"><image src="images/${item.imgSrc}" width="75" height="75"></td>
                            <td width="150px"><a href='ProdPgServlet?itmSku=${item.sku}'</a>${item.itemName}</td>
                            <td width="75px">Price: $${item.price}</td>
                            <input type="hidden" name="itmSku" value='${item.sku}'/>
                            <td><input type="submit" value="Add to cart"/></td>
                        </tr>
                    </tbody>
                </table>
            </form>
            </c:forEach>
                                       
        <!-- end .content --></div>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
        <!-- end .container --></div>
        <!-- end background --></div>      
    </body>
</html>
