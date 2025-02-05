<%@ page language="java" contentType="text/html; charset=US-ASCII"
        pageEncoding="US-ASCII"%>
 <%@ page isELIgnored="false" %>
<%@ taglib prefix="ref" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Shopping</title>
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
    <h3 class="text-center mb-3 ">Shopping</h3>
    <form action="update" method="post">
    <div class="md-3">
        <input type="text" hidden name="id" value="${dto.getId()}">
        <label form="form-label">First Name</label>
        <input type="text" name="firstName" value="${dto.getFirstName()}">
        <label form="form-label">Phone Number</label>
        <input type="text" name="phoneNumber" value="${dto.getPhoneNumber()}">
        <label form="form-label">Product Name</label>
        <input type="text" name="pName" value="${dto.getPName()}">
        <label form="form-label">Product Quantity</label>
        <input type="text" name="quantity" value="${dto.getQuantity()}">
        <label form="form-label">Address</label>
        <input type="text" name="address"  value="${dto.getAddress()}">
        </div>
        <div class="md-3">
        <button type="submit" value="update" class="btn btn-primary mt-3">Update</button>
        <a href="details" class="btn btn-secondary mt-3">Shopping Details</a>
    </form>
</div>
</body>
</html>