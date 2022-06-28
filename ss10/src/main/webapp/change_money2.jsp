<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/27/2022
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
 float money = Float.parseFloat(request.getParameter("rate"));
 float usd = Float.parseFloat(request.getParameter("usd"));

 float result = money * usd;
%>
<h1>Result: <%=result%></h1>

</body>
</html>
