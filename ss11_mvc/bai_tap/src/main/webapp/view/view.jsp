<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/29/2022
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Product</title>
</head>
<body>
<h1>Product details</h1>
<form action="" method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Mã sản phẩm: </td>
                <td>${requestScope["productList"].getId()}</td>
            </tr>
            <tr>
                <td>Tên sản phẩm: </td>
                <td>${requestScope["productList"].getName()}</td>
            </tr>
            <tr>
                <td>Giá:</td>
                <td>${requestScope["productList"].getPrice()}</td>
            </tr>
            <tr>
                <td>Số lượng: </td>
                <td>${requestScope["productList"].getAmount()}</td>
            </tr>
            <tr>
                <td>Nhà sản xuất: </td>
                <td>${requestScope["productList"].getProduction()}</td>
            </tr>
            <tr>
                <td><a href="/product">Back to customer list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
