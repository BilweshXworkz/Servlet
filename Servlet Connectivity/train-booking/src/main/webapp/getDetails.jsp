<%@ page language="java" contentType="text/html; charset=US-ASCII"
        pageEncoding="US-ASCII"%>
 <%@ page isELIgnored="false" %>
<%@ taglib prefix="ref" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Train Booking Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
         <style>
                body {
                    height: 100vh;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    background-color: #f8f9fa;
                }
            </style>
    </style>
</head>
<div class="container">
    <div class="row justify-content-center">
        <h3 class="text-center">Train Booking Details*</h3>
        <div class="col-md-8">
            <table class="table table-bordered text-center bg-white shadow-lg">
                <thead class="table-dark">
                    <tr>
                        <th>SL No</txh>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Date Of Birth</th>
                        <th>Email Id</th>
                        <th>Number</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <ref:forEach items="${booking}" var="booking" varStatus = "status">
                <tbody>
                <tr>
                    <td>${status.count}</td>
                    <td>${booking.getFName()}</td>
                    <td>${booking.getLName()}</td>
                    <td>${booking.getDob()}</td>
                    <td>${booking.getEmail()}</td>
                    <td>${booking.getNum()}</td>
                    <td><a href="delete?userId=${booking.getId()}" class="btn btn-secondary mt-3">DELETE</a> &nbsp
                     <a href="getProfileById?userId=${booking.getId()}" class="btn btn-secondary mt-3">Update</a></td>
                </tr>
                </tbody>
                </ref:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>

