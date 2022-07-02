<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/2/2022
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<center><h1>Update Product</h1></center>
<form action="" method="post" style="width: 30%; margin-left: 450px">
    <fieldset>
        <legend><h3>Product information</h3></legend>
        <table align="center">
            <tr>
                <td>ID Product:</td>
                <td><input disabled type="text" name="id" value="${product.idProduct}"></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value="${product.nameProduct}"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="price" value="${product.priceProduct}"></td>
            </tr>
            <tr>
                <td>Production:</td>
                <td><input type="text" name="production" value="${product.production}"></td>
            </tr>
            <tr>
                <td><button type="submit"><a href="/products" style="text-decoration: none">Back Menu</a></button></td>
                <td>
                    <button type="submit">Update Product</button>
                </td>
            </tr>
        </table>

    </fieldset>
</form>
</body>
</html>
