<%@ page language="java" contentType="text/html; charset=US-ASCII"
        pageEncoding="US-ASCII"%>
 <%@ page isELIgnored="false" %>
<%@ taglib prefix="ref" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book Your Train</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f8f9fa;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <table class="table table-bordered text-center bg-white shadow-lg">
                <thead class="table-dark">
                    <tr>
                        <th>Name</th>
                        <th>Phone Number</th>
                        <th>Email Id</th>
                        <th>Appointment Date</th>
                        <th>Action</th>
                     </tr>
                </thead>
                <ref:forEach items="${appointment}" var="appointment">
                     <tr>
                        <td>${appointment.name}</td>
                        <td>${appointment.phoneNumber}</td>
                        <td>${appointment.emailid}</td>
                        <td>${appointment.adate}</td>
                        <td><a href="delete?userId=${appointment.getId()}">DELETE</a></td>
                    </tr>
                </ref:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
