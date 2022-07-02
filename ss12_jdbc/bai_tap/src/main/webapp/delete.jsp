<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/1/2022
  Time: 11:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete Users</h1>
<form method="post" action="/user">
  <h3>Are you sure?</h3>
  <fieldset>
    <legend>Users information</legend>
    <table>
      <tr>
        <td>ID: </td>
        <td>${requestScope["users"].getId()}</td>
      </tr>
      <tr>
        <td>Name: </td>
        <td>${requestScope["users"].getName()}</td>
      </tr>
      <tr>
        <td>Email:</td>
        <td>${requestScope["users"].getEmail()}</td>
      </tr>
      <tr>
        <td>Address: </td>
        <td>${requestScope["users"].getAddress()}</td>
      </tr>
      <tr>
        <td><input type="submit" value="delete"></td>
        <td><a href="/user">Back to Users list</a></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>
