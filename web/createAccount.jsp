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
                var isValid = true;
          
                //Check if input is empty
                if(form.firstname.value === ""){
                    //show error
                    document.getElementById("errFname").innerHTML = "First Name can not be empty.";
                    isValid = false;
                }
                else
                    document.getElementById("errFname").innerHTML = "";
                if(form.lastname.value === ""){
                    //show error
                    document.getElementById("errLname").innerHTML = "Last Name can not be empty.";
                    isValid = false;
                } 
                else
                    document.getElementById("errLname").innerHTML = "";
                if(form.email.value === ""){
                    //show error
                    document.getElementById("errEmail").innerHTML = "Email can not be empty.";
                    isValid = false;
                } 
                else
                    document.getElementById("errEmail").innerHTML = "";
                if(form.password1.value === ""){
                    //show error
                    document.getElementById("errPassfield").innerHTML = "Password can not be empty.";
                    isValid = false;
                } 
                else
                    document.getElementById("errPassfield").innerHTML = "";
                if(form.password1.value != form.password2.value){
                    //show error
                    document.getElementById("errMatch").innerHTML = "Passwords do not match.";
                    isValid = false;
                } 
                else
                    document.getElementById("errMatch").innerHTML = "";
               if(isValid)
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
                <table border="0" align="Left">
                    <tbody>
                        <tr>
                            <td><p>First Name</p></td>
                            <td><p><input type="text" name="firstname"></p></td>
                            <td><span id='errFname' class='error'/></td>
                        </tr>
                        <tr>
                            <td><p>Last Name</p></td>
                            <td><p><input type="text" name="lastname"></p></td>
                            <td><span id='errLname' class='error'/></td>
                        </tr>
                        <tr>
                            <td class="label">Country</td>
                            <td>
                                <form action="writeCountry" method="get">
                                    <select name='country'>
                                        <option value='United States' selected>United States
                                        <option value="Canada"> Canada
                                        <option value="Mexico">Mexico
                                    </select>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td><p>Email</p></td>
                            <td><p><input type="text" name="email"></p></td>
                            <td><span id='errEmail' class='error'/></td>
                        </tr>
                        <tr>
                            <td><p>Username</p></td>
                            <td><p><input type="text" name="username"></p></td>
                            <td><span id='errUname' class='error'/></td>
                        </tr>
                        
                        <tr>
                            <td><p>Password</p></td>
                            <td><p><input type="password" name="password1"></p></td>
                            <td><span id='errPassfield' class='error'/></td>
                        </tr>
                        <tr>
                            <td><p>Re-type Password</p></td>
                            <td><p><input type="password" name="password2"></p></td>
                            <td><span id='errMatch' class='error'/></td>
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
