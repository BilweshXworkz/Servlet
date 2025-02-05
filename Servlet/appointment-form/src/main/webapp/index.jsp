<%@ page language="java" contentType="text/html; charset=US-ASCII"
        pageEncoding="US-ASCII"%>
 <%@ page isELIgnored="false" %>
<%@ taglib prefix="ref" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Appointment Form</title>
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
    <div class="card shadow-lg p-5" style="width: 330px;">
    <h3 class="text-center mb-3 ">Appointment Form</h3>
    <form action="submit" method="post">
    <div class="md-3">
        <label for="form-label">Name</label>
        <input type="text" name="name">
        <label for="form-label">Phone Number</label>
        <input type="text" name="phoneNumber">
        <label for="form-label">Email Id</label>
        <input type="text" name="emailId">
        <label for="form-label">Appointment Date</label>
        <input type="text" name="aDate">
        </div>
         <div class="md-3">
        <button type="submit" value="submit" class="btn btn-primary mt-3">Submit</button>
        <a href="details" class="btn btn-secondary mt-3">Appointment Details</a>
     </div>
            </form>
        </div>
</body>
</html>