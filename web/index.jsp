<%-- 
    Document   : products
    Created on : Oct 26, 2014, 12:12:53 PM
    Author     : Ashley, Yonas, Phat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/styles.css" rel="stylesheet" type="text/css"/>
        <script src="includes/countdown.js" type="text/javascript"></script>
        <title>Welcome!</title>
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
                            <c:if test="${customer == null}">
                                <form name="formLogin" method="post" action="CustomerServlet"><!--if valid, make table invisible-->  
                                    <table> 
                                        <tr>
                                            <td>Email</td>
                                            <td>
                                                <input type="text" name="acctName" id="acctName">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Password</td>
                                            <td><input type="password" name="password" id="password">
                                                </br>
                                                <div class="error">
                                                    ${requestScope.msg}
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <input type="hidden" name="hidAction" value="Login"/>
                                                <input type='submit' value="Login" />

                                            </td>
                                            <td>

                                                <a href="customer.jsp"> Create Account</a>

                                            </td>
                                        </tr>
                                    </table>  
                                </form> </c:if>

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

                    <script>;
                        /*more info on this script
                         https://blog.smalldo.gs/2013/12/create-simple-countdown/
                         */
                        function startCountdown(placeHolder, year, month, day, hour, minute) {
                            month = month-1; //appears month starts at current month + 1. Need to reset it back.
                            var clock = document.getElementById(placeHolder)
                                    , targetDate = new Date(year, month, day, hour, minute, 00, 000); // Jan 1, 2050;

                            //new Date(year, month, day, hours, minutes, seconds, milliseconds)

                            clock.innerHTML = countdown(targetDate).toString();
                            setInterval(function () {
                                clock.innerHTML = countdown(targetDate).toString();
                            }, 1000);
                        }
                    </script>
                    
                    <c:forEach var="item" items="${requestScope.items}">
                    <form action="CartServlet" method="post">
                        <table border="1" align="center" cellpadding="20" cellspacing="0">
                            <tbody>   
                                <tr>
                                    <td wdith="100px"><image src="images/${item.imgSrc}" width="75" height="75"></td>
                                    <td width="150px"><a href='ProdPgServlet?itmSku=${item.sku}'</a>${item.itemName}</td>
                                    <%--<td width="75px">Price: $${(item.discount / 100) * item.price}</td>--%>
                                    <td>Price: $${item.price}</td>
                                    <td><%--Unique placeholder id for each item. ignore the
                                            bad value for the div below. --%>
                                        <div id="${item.sku}"></div>
                                        <script>
                                            startCountdown("${item.sku}",
                                            <fmt:formatDate value="${item.discountEndTime}" pattern="yyy" />
                                            , <fmt:formatDate value="${item.discountEndTime}" pattern="M" />
                                            , <fmt:formatDate value="${item.discountEndTime}" pattern="d" />
                                            , <fmt:formatDate value="${item.discountEndTime}" pattern="h" />
                                            , <fmt:formatDate value="${item.discountEndTime}" pattern="m" />);
                                        </script>
                                    </td>
                                    <input type="hidden" name="hidSku" value="${item.sku}"/>
                                    <input type="hidden" name="hidItemName" value="${item.itemName}"/>
                                    <input type="hidden" name="hidItemPrice" value="${item.price}"/>
                                    <input type="hidden" name="hidAction" value="add"/>
                                    <td><input type="submit"  value="Add to cart"/></td>
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