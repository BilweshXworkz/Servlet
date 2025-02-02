<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Flight Booking</title>
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
<div class="card shadow-lg p-4" style="width: 270px;">
    <h3 class="text-center mb-3 ">Flight Booking</h3>
    <form action="apply" method="post">
        <div class="md-3">
            <label form="form-label">First Name</label>
            <input type="text" name="fName">
            <label form="form-label">Starting From</label>
            <input type="text" name="from">
            <label form="form-label">Starting Date</label>
            <input type="date" name="departure">
            <label form="form-label">Return Date</label>
            <input type="date" name="returns">
            <label form="form-label">Number Of Travels</label>
            <input type="text" name="num">
        </div>
        <div class="md-3">
            <button type="submit" value="apply" class="btn btn-primary mt-3">Submit</button>
            <a href="flightDetails" class="btn btn-secondary mt-3"> Flight Details </a>
        </div>
    </form>
</div>
</body>
</html>