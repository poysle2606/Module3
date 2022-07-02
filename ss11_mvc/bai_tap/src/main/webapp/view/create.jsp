<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/29/2022
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<h1>Create Product</h1>
<p>
    <a href="/product">Back menu</a>
</p>

<form action="" method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Mã sản phẩm: Mã sản phẩm tự tăng</td>
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
                <td>Số lượng:</td>
                <td><input type="text" name="amount" id="amount"></td>
            </tr>
            <tr>
                <td>Nhà sản xuất:</td>
                <td><input type="text" name="production" id="production"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit">Thêm mới sản phẩm</button>
                </td>
            </tr>
        </table>

    </fieldset>
</form>
<p>
    <c:if test="${requestScope['message'] !=null}">
        <span class="message">${requestScope['message']}</span>
    </c:if>
</p>
</body>
</html>
