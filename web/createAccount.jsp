<%-- 
    Document   : create account
    Created on : Nov 10, 2014, 12:12:53 PM
    Author     : Ashley, Yonas, Phat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/styles.css" rel="stylesheet" type="text/css"/>
        <title>Create Account</title>
        <script>
            function validate(form){
                //alert("Javascript enabled!!");
                form.submit();
            }
        </script>
    </head>
    <body>
    <div class ="background">
        <div class="container">
        
          <div class="header"><a href="index.jsp"><img src="images/StoreLogo.png" alt="Store Logo Here" name="Store_logo" width="342" height="123" id="Store_logo" style="background: #FFF; display:block;" /></a>
        
 
          <div class="content">
            
            
        <h1>New Account</h1>
            <form action="accountVerify.jsp" method="post">
                <table border="0" align="Center">
                    <tbody>
                        <tr>
                            <td>
                                <p>First Name</p>
                            </td>
                            <td>
                                <p><input type="text" name="firstname"></p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p>Last Name</p>
                            </td>
                            <td>
                                <p><input type="text" name="lastname"></p>
                            </td>
                        </tr>
                        <tr>
                            <td class="label">Country</td>
                            <td>
                                United States
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p>Email</p>
                            </td>
                            <td>
                                <p><input type="text" name="email"></p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p>Username</p>
                            </td>
                            <td>
                                <p><input type="text" name="username"></p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p>Password</p>
                            </td>
                            <td>
                                <p><input type="password" name="password1"></p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p>Re-type Password</p>
                            </td>
                            <td>
                                <p><input type="password" name="password2"></p>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <input type="button" value="Create" onclick="validate(this.form)"/>
            </form>
            <!-- end .content --></div>
            <%@include file="/WEB-INF/jspf/footer.jspf" %>
            <!-- end .container --></div>
        </div><!--end background-->
    </body>
</html>
