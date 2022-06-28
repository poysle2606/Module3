<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/28/2022
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Máy tính đơn giản</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/calculator" method="post">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <td>First calculator</td>
                <td><input type="text" name="firstOperand"></td>
            </tr>
            <tr>
                <td>Operator</td>
                <td><select name="operand">
                    <option value="+">Cộng</option>
                    <option value="-">Trừ</option>
                    <option value="*">Nhân</option>
                    <option value="/">Chia</option>
                </select></td>
            </tr>
            <tr>
                <td>Second Calculator</td>
                <td><input type="text" name="secondOperand"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit" name="button">Calculator</button></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
