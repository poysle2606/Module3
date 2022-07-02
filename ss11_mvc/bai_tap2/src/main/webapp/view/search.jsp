<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/2/2022
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        button {
            border: none;
            border-radius: 10px;
        }

        button, a:hover {
            background-color: chartreuse;
            color: black;
        }

        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<center><h1>Product List</h1></center>
<form action="/products" style="margin-left:550px">
    <button><a href="/products?action=create">Create new Product</a></button>
</form>

<form action="/products" style="margin-left:550px">
    <button><a href="/products?action=sort">Sort By Name</a></button>
</form>

<button type="submit"><a href="/products" style="text-decoration: none">Back Menu</a></button>

<form action="/products" style="margin-left: 450px">
    <input type="text" name="searchName" size="35">
    <input class="btn btn-outline-success" type="submit" name="action" value="Search">
</form>


<table class="table table-striped">
    <tr>
        <th>ID Product</th>
        <th>Name</th>
        <th>Price</th>
        <th>Production</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${product}" var="products">
        <tr>
            <td><c:out value="${products.idProduct}"/></td>
            <td><c:out value="${products.nameProduct}"/></td>
            <td><c:out value="${products.priceProduct}"/></td>
            <td><c:out value="${products.production}"/></td>
            <td>
                <button><a href="/products?action=edit&id=${products.idProduct}">Edit</a></button>
                <button><a href="/products?action=edit&id=${products.idProduct}">Delete</a></button>
            </td>
        </tr>
    </c:forEach>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
