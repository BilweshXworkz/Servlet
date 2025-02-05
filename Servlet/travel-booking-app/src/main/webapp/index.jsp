<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Travel Booking</title>
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
    <h3 class="text-center mb-3 ">Travel Booking</h3>
    <form action="book" method="post">
    <div class="md-3">
        <label form="form-label">First Name</label>
        <input type="text" name="firstName">
        <label form="form-label">Phone Number</label>
        <input type="text" name="phoneNumber">
        <label form="form-label">Start Trip</label>
        Start Trip : <input type="text" name="start">
        <label form="form-label">Traveling</label>
        <input type="text" name="traveling">
        <label form="form-label">Vehicle</label>
        Vehicle : <input type="text" name="vehicle">
        </div>
        <div class="md-3">
        <button type="submit" value="Book" class="btn btn-primary mt-3">Submit</button>
        <a href="booking" class="btn btn-secondary mt-3">Booking Details</a>
    </form>
</div>
</body>
</html>