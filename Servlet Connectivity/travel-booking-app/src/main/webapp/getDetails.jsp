<%@ page language="java" contentType="text/html; charset=US-ASCII"
        pageEncoding="US-ASCII"%>
 <%@ page isELIgnored="false" %>
<%@ taglib prefix="ref" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Travel Booking Details</title>
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
        <h3 class="text-center">Booking Details</h3>
        <div class="col-md-8">
            <table class="table table-bordered text-center bg-white shadow-lg">
                <thead class="table-dark">
                    <tr>
                        <th>First Name</th>
                        <th>Phone Number</th>
                        <th>Start</th>
                        <th>Traveling</th>
                        <th>Vehicle</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <ref:forEach items="${booking}" var="booking">
                <tbody>
                  <tr>
                    <td>${ booking.getFirstName() }</td>
                    <td>${ booking.getPhoneNumber() }</td>
                    <td>${ booking.getStart() }</td>
                    <td>${ booking.getTraveling() }</td>
                    <td>${ booking.getVehicle() }</td>
                    <td><a href="delete?userId=${booking.getId()}">DELETE</a>
                    <a href="updateById?userId=${booking.getId()}">Update</a></td>
                  </tr>
                </tbody>
      </ref:forEach>
       </table>
           </div>
       </div>
   </div>
</body>
</html>