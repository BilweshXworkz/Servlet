<%@ page language="java" contentType="text/html; charset=US-ASCII"
        pageEncoding="US-ASCII"%>
 <%@ page isELIgnored="false" %>
<%@ taglib prefix="ref" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>The Appointment Details</title>
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
        <th>To Mail</th>
        <th>Subject</th>
        <th>Content</th>
        <th>Action</th>
      </tr>
      </thead>
        <ref:forEach items="${email}" var="email">
      <tr>
      <tbody>
        <td>${ email.getToMail() }</td>
        <td>${ email.getSubject() }</td>
        <td>${ email.getContent() }</td>
        <td><a  href="deleteEmail?toEmail=${email.toMail}">Delete</a></td>
      </tr>
      <tbody>
      </ref:forEach>
    </table>
            </div>
        </div>
    </div>
</body>
</html>