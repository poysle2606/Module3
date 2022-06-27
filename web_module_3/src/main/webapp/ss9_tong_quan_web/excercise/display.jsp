<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/27/2022
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tính chiết khấu</title>
</head>
<body>
<form action="/change" method="post">
    <h2>Tính chiết khấu sản phẩm</h2>
    <label>Mô tả sản phẩm</label> <br>
    <input type="text" placeholder="Mô tả sản phẩm" size="55"> <br>
    <label>Giá niêm yết</label> <br>
    <input type="text" name="money" placeholder="0" size="25"> <br>
    <label>Tỉ lệ chiết khấu</label> <br>
    <input type="text" name="percent" placeholder="0" size="25">
    <button type="submit">Calculate Discount</button>
</form>
<h2>Discount Amount is: ${discountAmount}</h2>
<h2>Discount Price is: ${discountPrice}</h2>

</body>
</html>
