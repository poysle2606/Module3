<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/30/2022
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>User Management Application</title>
</head>
<body>
<center>
  <h1>User Management</h1>
  <h2>
    <a href="/users">List All Users</a>
  </h2>
</center>
<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">
      <caption>
        <h2>
          Edit User
        </h2>
      </caption>
      <c:if test="${users != null}">
        <input type="hidden" name="id"  value='${users.id}'/>
      </c:if>
      <tr>
        <th>User Name:</th>
        <td>
          <input type="text" name="name" size="45"
                 value="${users.name}"
          />
        </td>
      </tr>
      <tr>
        <th>User Email:</th>
        <td>
          <input type="text" name="email" size="45"
                 value="${users.email}"
          />
        </td>
      </tr>
      <tr>
        <th>Address:</th>
        <td>
          <input type="text" name="address" size="15"
                 value="${users.address}"
          />
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="Save"/>
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
