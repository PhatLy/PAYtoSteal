<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<div class="header"><a href="IndexServlet">
                        <img src="images/StoreLogo.png" alt="Store Logo Here" name="Store_logo" width="342" height="123" id="Store_logo" style="background: #FFF; display:block;" /></a>
                </div>