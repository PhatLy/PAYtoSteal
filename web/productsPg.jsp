<%-- 
    Document   : productsPg
    Created on : Nov 20, 2014, 8:51:03 PM
    Author     : Ashley, Yonas, Phat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${requestScope.name.itemName}</title>
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
        
        <h1>${requestScope.name.itemName}</h1>
        <form>
            <table>
                <tbody>
                    <tr>
                        <td rowspan="3"><image src=${requestScope.name.imgSrc} width="200" height="200"></td>
                        <td>Price: $${requestScope.name.price}</td>
                    </tr>
                    <tr>
                        <td>Description:</td>
                    </tr>
                    <tr>
                        <td>${requestScope.name.description}</td>
                    </tr>
                </tbody>
            </table>
        </form>
                    
        <!-- end .content --></div>
        
        <!-- end .container --></div>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    <!-- end background --></div>            
    </body>
</html>
