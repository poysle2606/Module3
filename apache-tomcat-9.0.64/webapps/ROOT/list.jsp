<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/29/2022
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Product List</h1>
<p>

    <button style="border-radius: 10px">
        <a href="/product?action=create" style="text-decoration: none">Create new Product</a>
    </button>
</p>
<table class="table table-striped">
    <tr>
        <th colspan="7  " style="text-align: center">
            Danh sách sản phẩm
        </th>
    </tr>
    <tr>
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Giá sản phẩm</th>
        <th>Số lượng</th>
        <th>Nhà sản xuất</th>
    </tr>

    <c:forEach items="${requestScope['productList']}" var="product">
        <tr>
            <td>${product.getId()}</td>
            <td>
                <a href="/product?action=view&id=${product.getId()}">${product.getName()}</a>
            </td>
            <td>${product.getPrice()}</td>
            <td>${product.getAmount()}</td>
            <td>${product.getProduction()}</td>
            <td>
                <a href="/product?action=edit&id=${product.getId()}">edit</a>
            </td>
            <td>
                <a href="/product?action=delete&id=${product.getId()}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
