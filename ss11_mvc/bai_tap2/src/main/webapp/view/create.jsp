<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/2/2022
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<center><h1>Create Product</h1></center>
<form action="" method="post" style="width: 30%; margin-left: 450px">
    <fieldset>
        <legend><h3>Product information</h3></legend>
        <table align="center">
            <tr>
                <td>Mã sản phẩm:</td>
                <td>Mã sản phẩm tự tăng</td>
            </tr>
            <tr>
                <td>Tên sản phẩm:</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Giá sản phẩm:</td>
                <td><input type="text" name="price" id="price"></td>
            </tr>
            <tr>
                <td>Nhà sản xuất:</td>
                <td><input type="text" name="production" id="production"></td>
            </tr>
            <tr>
                <td><button type="submit"><a href="/products" style="text-decoration: none">Back Menu</a></button></td>
                <td>
                    <button type="submit">Thêm mới sản phẩm</button>
                </td>
            </tr>
        </table>

    </fieldset>
</form>
</body>
</html>
