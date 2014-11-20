<%-- 
    Document   : products
    Created on : Oct 26, 2014, 12:12:53 PM
    Author     : Ashley, Yonas, Phat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="styles/styles.css" rel="stylesheet" type="text/css"/>
        <title>Welcome!</title>
        <script>
            function validateLogin(formLogin){
                alert("login invalid");
                //add code to check if user exists in db and if pw matches
            }
            function validate(form){
                
                var isValid = true;
          
                //Check if input is empty
                if(form.txtNumber.value === ""){
                    //show error
                    document.getElementById("errNumber").innerHTML = "Number is required.";
                    isValid = false;
                } 
                
                //Check if input is non 0 or negative
                //Append error message (if there was already one).
                else if(form.txtNumber.value <= 0){
                    //show error
                    document.getElementById("errNumber").innerHTML = "Minimum is 1.";
                    isValid = false;
                }
               
               if(isValid)
                   form.submit();               
                    
                    
            }
        </script>
    </head>
    <body>
        <div class="background">
        <jsp:include page="WEB-INF/jspf/timerScript.jsp" /><%--move this to each item in product --%>
        <div class="container">
        <table width="150" border="0" align="right">
                <tr>
                    <td>
                      <p><a href="./cart.jsp"><img src="images/cart.png" alt="cart" width="40" height="40" longdesc="cart" align="right"></a></p>
                    </td>
                    <td>
                        <form name="formLogin" method="post" action="">  
                        <table> 
                            <tr>
                              <td>Account</td>
                              <td>
                                <input type="text" name="acctName" id="acctName">
                              </td>
                            </tr>
                            <tr>
                              <td>Password</td>
                              <td><input type="password" name="password" id="password"></td>
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
            <!-- end .content --></div>
            <%@include file="/WEB-INF/jspf/footer.jspf" %>
          <!-- end .container --></div>
    <!-- end background --></div>      
    </body>
</html>
