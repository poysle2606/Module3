<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/30/2022
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users Management Application</title>
</head>
<body>
<center>
    <h1>Users Management</h1>
    <h2>
        <a href="/user?action=c reate">Add new Users</a>
    </h2>

    <h2>
        <a href="/user?action=sort">Sort Users</a>
    </h2>

    <form action="/user">
        <input type="text" name="searchName">
        <input type="submit" name="action" value="Search">
    </form>
</center>

<div align="center">
    <table border="1px" cellpadding="5">
        <caption><h2>List Of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${users}" var="users">
            <tr>
                <td><c:out value="${users.id}"/></td>
                <td><c:out value="${users.name}"/></td>
                <td><c:out value="${users.email}"/></td>
                <td><c:out value="${users.address}"/></td>
                <td>
                    <a href="/user?action=edit&id=${users.id}">Edit</a>
                    <a href="/user?action=delete&id=${users.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
