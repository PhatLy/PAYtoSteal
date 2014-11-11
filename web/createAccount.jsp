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
        <div class="container">
        
          <div class="header"><a href="index.jsp"><img src="images/StoreLogo.png" alt="Store Logo Here" name="Store_logo" width="342" height="123" id="Store_logo" style="background: #FFF; display:block;" /></a>
        
 
          <div class="content">
            
            <%@ page import="java.util.List, java.util.ArrayList" %>
            <% 
                List<String> countries = new ArrayList<String>();
                countries.add("United States");
                countries.add("Mexico");
                countries.add("Canada");
                countries.add("Russia");
            %>
        <h1>New Account</h1>
        <%--<request.getSession().setAttribute("userName", UserMgmt.getUsers());
        <c: forEach var="user" items="${requestScope.userAccounts}">
        should be in .java file
        </c:>
        --%>
            <form action="accountVerify.jsp" method="post">
                <table border="0" align="Center">
                    <tbody>
                        <tr>
                            
                            <td>First Name: ${param.firstName}</td>
                            <td><input type="text" name="firstName"/></td>
                        </tr>
                        <tr>
                            <td class="label">Last Name</td>
                            <td><input type="text" name="lastname"/></td>
                        </tr>
                        <tr>
                            <td class="label">Country</td>
                            <td>
                                <select name="country">
                                    <%
                                        for(int i=0; i<countries.size(); i++){
                                    %>
                                    <option value="<%=countries.get(i)%>"><%=countries.get(i)%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="label">Email</td>
                            <td><input type="text" name="email"/></td>
                        </tr>
                        <tr>
                            <td class="label">Username</td>
                            <td><input type="text" name="username"/></td>
                        </tr>
                        <tr>
                            <td class="label">Password</td>
                            <td><input type="password" name="password1"/></td>
                        </tr>
                        <tr>
                            <td class="label">Password (Verify)</td>
                            <td><input type="password" name="password2"/></td>
                        </tr>
                    </tbody>
                </table>
                <input type="button" value="Create" onclick="validate(this.form)"/>
            </form>
            <!-- end .content --></div>
            <%@include file="/WEB-INF/jspf/footer.jspf" %>
            <!-- end .container --></div>

    </body>
</html>
