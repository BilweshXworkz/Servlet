<%@ page language="java" contentType="text/html; charset=US-ASCII"
        pageEncoding="US-ASCII"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
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
<div class="card shadow-lg p-4" style="width: 350px;">
    <h3 class="text-center mb-3 ">Book Train</h3>
    <form action="bookTrain" method="post">
        <div class="md-3">
            <label form="form-label">First Name</label>
            <input type="text" class="form-control" name="fName">
            <label form="form-label">Last Name</label>
            <input type="text" class="form-control" name="lName">
            <label form="form-label">Travel Date</label>
            <input type="date" class="form-control" name="dob">
            <label form="form-label">Email Id</label>
            <input type="text" class="form-control" name="email">
            <label form="form-label">Number of Seat</label>
            <input type="text" class="form-control" name="num">
        </div>
        <div class="md-3">
            <button type="submit" value="Submit" class="btn btn-primary mt-3">Submit</button>
            <a href="booking" class="btn btn-secondary mt-3">Booking Details</a>
        </div>
    </form>
</div>
</body>
</html>