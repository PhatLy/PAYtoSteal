
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
        <script>
            function validate(form) {

                var isValid = true;

                //Check if input is empty
                if (form.txtNumber.value === "") {
                    //show error
                    document.getElementById("errNumber").innerHTML = "Number is required.";
                    isValid = false;
                }

                //Check if input is non 0 or negative
                //Append error message (if there was already one).
                else if (form.txtNumber.value <= 0) {
                    //show error
                    document.getElementById("errNumber").innerHTML = "Minimum is 1.";
                    isValid = false;
                }

                if (isValid)
                    form.submit();


            }
        </script>
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

                    
                    <!--
                    <h1>Welcome to our store!</h1>

                    <p>Please type the number of products you'd like to view.</p>

                    <form action='ProductsServlet' method="post">

                        <table border='0' align="center" cellpadding="2" cellspacing="2">
                            <tr>
                                <td>Type number:</td>
                                <td ><input type='text' name='txtNumber' autocomplete="off" />  
                                    <span id='errNumber' class='error'/>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type='button' value="Display products" onclick="validate(this.form)"/></td>
                            </tr>
                        </table>

                    </form>
                    
                    -->
                    
                    <form action="CartServlet" method="post">
                <table border="1" align="center" cellpadding="20" cellspacing="0">
                    <tbody>        
                        <c:forEach var="item" items="${requestScope.items}">
                        <tr>
                            <td width="100px"><image src="images/${item.imgSrc}" width="75" height="75"></td>
                            <%--<td width="100px"><a href="productsPg.jsp?name=${item.itemName}"</a>${item.itemName}</td>--%>
                            <td>${item.itemName}</td>
                            <td width="100px">Price: $${item.price}</td>
                            <input type="hidden" name="${item.itemName}" value="${item.itemName}"/>
                            <td><input type="button" value="Add to cart" 
                                       onclick="location.href='CartServlet?itemName=${item.itemName}'"/>
                                <jsp:include page="WEB-INF/jspf/timerScript.jsp" /><!--timer function -->


                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </form>
                    
                    
                    <!-- end .content --></div>
                    <%@include file="/WEB-INF/jspf/footer.jspf" %>
                <!-- end .container --></div>
            <!-- end background --></div>      
    </body>
</html>
