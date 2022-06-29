<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/29/2022
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa sản phẩm</title>
</head>
<body>
<h1>Chỉnh sửa sản phẩm</h1>
<p>
    <a href="/product">Back menu</a>
</p>

<form action="" method="post">
    <fieldset>
        <legend>Edit Product</legend>
        <table>
            <tr>
                <td>Mã sản phẩm: Mã sản phẩm tự cập nhật</td>
            </tr>
            <tr>
                <td>Tên sản phẩm:</td>
                <td><input type="text" name="name" id="name" value="${requestScope["productList"].getName()}"></td>
            </tr>
            <tr>
                <td>Giá sản phẩm:</td>
                <td><input type="text" name="price" id="price" value="${requestScope["productList"].getPrice()}"></td>
            </tr>
            <tr>
                <td>Số lượng:</td>
                <td><input type="text" name="amount" id="amount" value="${requestScope["productList"].getAmount()}"></td>
            </tr>
            <tr>
                <td>Nhà sản xuất:</td>
                <td><input type="text" name="production" id="production" value="${requestScope["productList"].getProduction()}"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit">Cập nhật sản phẩm</button>
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
