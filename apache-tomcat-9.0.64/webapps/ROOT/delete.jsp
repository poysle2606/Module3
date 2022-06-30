<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting Users</title>
</head>
<body>
<h1>Delete users</h1>
<p>
    <a href="/users">Back to Users list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td>${requestScope["users"].getName()}</td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>${requestScope["users"].getEmail()}</td>
            </tr>
            <tr>
                <td>Address:</td>
                <td>${requestScope["users"].getAddress()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete customer"></td>
                <td><a href="/users">Back to User list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>