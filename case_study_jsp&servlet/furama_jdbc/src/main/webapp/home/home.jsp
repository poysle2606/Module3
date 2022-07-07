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
    <title>Furama Resort</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="css_furama.css">
</head>
<body>
<div id="header-furama">
    <div>
        <img src="https://furamavietnam.com/wp-content/uploads/2018/08/logo@2x.png" height="70" width="55" alt="">
    </div>

    <div>
        <img src="https://cdn-icons.flaticon.com/png/512/3059/premium/3059518.png?token=exp=1656917205~hmac=461c3388245578370ff666cc8fc285fb"
             height="25" width="25"
             style="margin: 25px 10px 25px 900px"/>
        <a href="" class="link-myself">Đông Đú Đởn</a>
    </div>

</div>
    <nav class="navbar navbar-expand-lg navbar-primary bg-dark" style="position: sticky; top: 0">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active button-function" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active button-function" href="/employee">Employee</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active button-function" href="/customer">Customer</a>
                    </li>
                    <li class="nav-item dropdown ">
                        <a class="nav-link dropdown-toggle button-function" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Service
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">Villa</a></li>
                            <li><a class="dropdown-item" href="#">Room</a></li>
                            <li><a class="dropdown-item" href="#">House</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active button-function" href="#">Contract</a>
                    </li>
                </ul>
                <form class="d-flex" style="margin-top: 15px">
                    <input class="form-control me-2" type="search" placeholder=" Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
<div class="col-lg-12" style="width: 100%;height: auto">
    <div class="col-lg-3 mid1" style="height: 100%;float: left"></div>
    <div class="col-lg-9 mid2" style="height: 100%; float: left">
    </div>
</div>

<div id="footer-furama">
    <center>Furama resort 2022 &copy;</center>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
