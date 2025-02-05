<%@ page language="java" contentType="text/html; charset=US-ASCII"
        pageEncoding="US-ASCII"%>
 <%@ page isELIgnored="false" %>
<%@ taglib prefix="ref" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Contact</title>
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
<div class="card shadow-lg p-4" style="width: 290px;">
    <h3 class="text-center mb-3 ">Save Your Contact</h3>
    <form action="update" method="post">
        <div class="md-3">
            <input type="text" hidden name="id" value="${dto.getId()}">
            <label for="form-label">First Name</label>
            <input type="text" name="firstName" value="${dto.getFirstName()}">
            <label for="form-label">Last Name</label>
            <input type="text" name="lastName" value="${dto.getLastName()}">
            <label for="form-label">Phone Number</label>
            <input type="text" name="phoneNumber" value="${dto.getPhoneNumber()}">
            <label for="form-label">Email ID</label>
            <input type="text" name="emailId" value="${dto.getEmailId()}">
            <label for="form-label">Description</label>
            <input type="text" name="description" value="${dto.getDescription()}">
        </div>
        <div class="md-3">
            <button type="submit" value="update" class="btn btn-primary mt-3">Update</button>
            <a href = "details" class="btn btn-secondary mt-3">Contact Details</a>
        </div>
    </form>
</div>
</body>
</html>