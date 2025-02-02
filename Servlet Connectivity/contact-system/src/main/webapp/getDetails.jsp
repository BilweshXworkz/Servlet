<%@ page language="java" contentType="text/html; charset=US-ASCII"
        pageEncoding="US-ASCII"%>
 <%@ page isELIgnored="false" %>
<%@ taglib prefix="ref" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contact Details</title>
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
        <h3 class="text-center">Contact Details</h3>
        <div class="col-md-8">
            <table class="table table-bordered text-center bg-white shadow-lg">
                <thead class="table-dark">
                    <tr>
                        <th>Full Name</th>
                        <th>Last Name</th>
                        <th>Phone Number</th>
                        <th>Email ID</th>
                        <th>Description</th>
                        <th>Action</th>
                    </tr>
               </thead>
               <ref:forEach items="${contact}" var="contact">
               <tbody>
               <tr>
                    <td>${ contact.getFirstName() }</td>
                    <td>${ contact.getLastName() }</td>
                    <td>${ contact.getPhoneNumber() }</td>
                    <td>${ contact.getEmailId() }</td>
                    <td>${ contact.getDescription() }</td>
                    <td><a href="delete?userId=${contact.getId()}">DELETE</a></td>
               </tr>
            </tbody>
            </ref:forEach>
            </table>
            </div>
        </div>
    </div>
</body>
</html>