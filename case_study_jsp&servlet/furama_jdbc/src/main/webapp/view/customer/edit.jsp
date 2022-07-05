<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/4/2022
  Time: 1:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../../home/css_furama.css">
</head>
<body>
<div id="header-furama">
    <div>
        <img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo@2x.png" height="80" width="80" alt="">
    </div>

    <div>
        <img src="https://cdn-icons.flaticon.com/png/512/3059/premium/3059518.png?token=exp=1656986759~hmac=7141c6bf14466c3b1dab5cfd568fe3a4"
             height="25" width="25"
             style="margin: 25px 10px 25px 900px"/>
        <a href="" class="link-myself">Đông Đú Đởn</a>
    </div>

</div>
<div>
    <nav class="navbar navbar-expand-lg navbar-primary bg-dark">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active button-function" aria-current="page" href="home/home.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active button-function" href="/employee">Employee</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active button-function" href="/customer">Customer</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active button-function" href="#">Service</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active button-function" href="#">Contract</a>
                    </li>
                </ul>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder=" Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
</div>

<div class="col-lg-12 ">
    <center><h1>Edit Customer</h1></center>
    <div>
        <form method="post">
            <table >
                <tr>
                    <th>ID:</th>
                    <td>
                        <input disabled type="text" name="id" size="45" value="${customer.idCustomer}">
                    </td>
                </tr>
                <tr>
                    <th>Type of Customer:</th>
                    <td>
                        <input type="text" name="typeCustomer" size="45" value="${customer.idTypeCustomer}">
                    </td>
                </tr>
                <tr>
                    <th>Name of Customer:</th>
                    <td>
                        <input type="text" name="name" size="45" value="${customer.nameCustomer}">
                    </td>
                </tr>
                <tr>
                    <th>Day of Birth:</th>
                    <td>
                        <input type="date" name="dayOfBirth" size="45" value="${customer.dayOfBirth}">
                    </td>
                </tr>
                <tr>
                    <th>Gender:</th>
                    <td>
                        <select name="gender" id="">
                            <option value="0">Male</option>
                            <option value="1">Female</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>CMND:</th>
                    <td>
                        <input type="text" name="idCard" size="45" value="${customer.idCard}">
                    </td>
                </tr>
                <tr>
                    <th>Number Phone:</th>
                    <td>
                        <input type="text" name="phoneNumber" size="45" value="${customer.numberPhone}">
                    </td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td>
                        <input type="text" name="email" size="45" value="${customer.email}">
                    </td>
                </tr>
                <tr>
                    <th>Address:</th>
                    <td>
                        <input type="text" name="address" size="45" value="${customer.address}">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type="submit">Submit</button></td>
                </tr>
            </table>

        </form>
    </div>
</div>

<div id="footer-furama">
    <center>Furama resort 2022 &copy;</center>
    <%--    <div class="footer-big">--%>
    <%--        <div>--%>
    <%--            <img src="https://cdn-icons.flaticon.com/png/512/4643/premium/4643473.png?token=exp=1656983526~hmac=e1a78b5d2fb4c3bb24db15338bfa8368" alt="" width="15" height="15">--%>
    <%--        </div>--%>
    <%--        <div class="footer-text">--%>
    <%--           <p> 103 – 105 Đường Võ Nguyên Giáp, Phường Khuê Mỹ, Quận Ngũ hành Sơn, Tp. Đà Nẵng, Việt Nam.</p>--%>
    <%--            <p><span>7.0km </span>từ Sân bay Quốc tế Đà Nẵng</p>--%>
    <%--        </div>--%>
    <%--    </div>--%>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
