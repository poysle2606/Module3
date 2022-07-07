<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/4/2022
  Time: 4:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../../home/css_furama.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="/boostrap/bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/boostrap/datatables/css/dataTables.bootstrap4.min.css"/>

    <style>
        button {
            border: none;
            border-radius: 10px;
        }

        .gun:hover {
            background-color: chartreuse;
            color: black;
        }

        a {
            text-decoration: none;
        }

        th, td {
            text-align: center;
        }

        .gradient-header {
            background: #4facfe;

            background: -webkit-linear-gradient(to right, rgba(79, 172, 254, 0.5), rgba(0, 242, 254, 0.5));

            background: linear-gradient(to right, rgba(79, 172, 254, 0.5), rgba(0, 242, 254, 0.5))
        }
    </style>
</head>
<body style="width: 130%">
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
<nav class="navbar navbar-expand-lg navbar-primary bg-dark">
    <div class="container-fluid col-lg-12">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active button-function" aria-current="page" href="home/home.jsp">Home</a>
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
            <form class="d-flex" style="margin-top: 15px">
                <input name="name" class="form-control col-lg-2 me-2" type="search" placeholder=" Search Name" aria-label="Search">
                <input name="email" class="form-control col-lg-2 me-2" type="search" placeholder=" Search Email" aria-label="Search">
                <input name="address" class="form-control col-lg-2 me-2" type="search" placeholder=" Search Address" aria-label="Search">
                <input name="action" class="btn btn-outline-success" type="submit" value="search">
            </form>
        </div>
    </div>
</nav>

<center><h1>Employee List</h1></center>
<button class="gun"><a href="/employee?action=create">Create New Employee</a></button>
<div class="col-lg-12 gradient-header" style="width: 100%;height: auto" >

    <table class="table text-center table-striped" id="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Day Of Birth</th>
            <th>ID Card</th>
            <th>Salary</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Address</th>
            <th>Position</th>
            <th>Division</th>
            <th>Education Degree</th>
            <th>User name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employee}" var="employee">
            <tr>
                <td>${employee.idEmployee}></td>
                <td>${employee.nameEmployee}</td>
                <td>${employee.dayOfBirth}</td>
                <td>${employee.idCard}</td>
                <td>${employee.salary}</td>
                <td>${employee.numberPhone}</td>
                <td>${employee.email}</td>
                <td>${employee.address}</td>
                <td>
                    <c:forEach items="${position}" var="position">
                        <c:if test="${position.id == employee.positionId}">
                            ${position.name}
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${division}" var="division">
                        <c:if test="${division.id == employee.divisionId}">
                            ${division.name}
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${education}" var="education">
                        <c:if test="${education.id == employee.educationDegreeId}">
                            ${education.name}
                        </c:if>
                    </c:forEach>
                </td>
                <td>${employee.userName}</td>
                <td>
                    <button class="gun"><a href="/employee?action=edit&id=${employee.idEmployee}">Edit</a></button>
                    <button class="gun" type="button"
                            onclick="infoDelete('${employee.idEmployee}','${employee.nameEmployee}')"
                            data-bs-toggle="modal" data-bs-target="#exampleModal">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%--Modal--%>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/employee" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" hidden name="idDelete" id="idDelete">
                    <input type="text" hidden name="action" value="delete">
                    <span>Bạn có muốn xóa khách hàng: </span>
                    <span id="nameDelete"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </div>
        </form>
    </div>
</div>

<div id="footer-furama">
    <center>Furama resort 2022 &copy;</center>
</div>

<script>
    function infoDelete(id, name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerText = name;
    }
</script>

<script src="/boostrap/jquery/jquery-3.5.1.min.js"></script>
<script src="/boostrap/datatables/js/jquery.dataTables.min.js"></script>
<script src="/boostrap/datatables/js/dataTables.bootstrap4.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="/boostrap/bootstrap413/js/bootstrap.bundle.min.js"></script>

<script>
    $(document).ready(function () {
        $('#table').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 4
        });
    })
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
