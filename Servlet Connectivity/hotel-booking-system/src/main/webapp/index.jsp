<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hotel Booking</title>
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
        <h3 class="text-center mb-4 ">Hotel Booking</h3>
        <form action="makeOrder" method="post">
            <div class="md-5">
                <label for="form-label">First Name</label>
                <input type="text" name="firstName">
                <label for="form-label">Phone Number</label>
                <input type="text" name="phoneNumber">
                <label for="form-label">Hotel Name</label>
                <input type="text" name="hotel">
                <label for="form-label">Stay Time</label>
                <input type="text" name="stayTime">
                <label for="form-label">Number of Room</label>
                <input type="text" name="numberRoom">
            </div>
            <div class="md-3">
                <button type="submit" value="Order" class="btn btn-primary mt-3">Order</button>
                <a href="details" class="btn btn-secondary mt-3">Hotel Details</a>
            </div>
        </form>
    </div>
</body>
</html>