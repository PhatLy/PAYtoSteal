<%-- 
    Document   : product
    Created on : Nov 24, 2014, 7:12:31 AM
    Author     : Yonas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product management</title>
    </head>
    <body>
        <h1>Product management</h1>

        <form action="AdminServlet" method="post">
            <input type="hidden" name="hidAction" value="List"/>
            <input type="submit" value="Update/Delete items"  />     
        </form>


        <form action="AdminServlet" method="post">
            <h3>Add a product</h3>

            <table>

                <tr>
                    <td>SKU</td>
                    <td><input type="text" name="txtSku"/></td>
                </tr>

                <tr>
                    <td>Image path</td>
                    <td><input type="text" name="txtImgSrc"/></td>
                </tr>

                <tr>
                    <td>Name</td>
                    <td><input type="text" name="txtItemName"/></td>
                </tr>

                <tr>
                    <td>Price</td>
                    <td><input type="text" name="txtPrice"/></td>
                </tr>

                <tr>
                    <td>Description</td>
                    <td>
                        <textarea rows="4" cols="50" name="txtDescription"></textarea>
                    </td>
                </tr>

                <tr>
                    <td>Discount</td>
                    <td><input type="text" name="txtDiscount"/></td>
                </tr>

                <tr>
                    <td>Discount start Time</td>
                    <td><input type="text" name="txtDiscountStartTime"/></td>
                </tr>

                <tr>
                    <td>Discount end Time</td>
                    <td><input type="text" name="txtDiscountEndTime"/></td>
                </tr>

                <tr>
                    <td></td>
                    <td>
                        <input type="hidden" name="hidAction" value="Create"/>
                        <input type="submit" name="btnAddProduct" value="Add product"/>

                        ${requestScope.msg}

                    </td>
                </tr>
            </table>
        </form>


    </body>
</html>
