<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/27/2022
  Time: 9:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Map<String, String> words = new HashMap<>();
%>

<%
    words.put("hello", "xin chào");
    words.put("how", "như nào");
    words.put("red", "màu đỏ");
    words.put("girl", "cô gái");

    String search = request.getParameter("search");

    String result = words.get(search);
    if (result != null) {
    }
%>


</body>
</html>
