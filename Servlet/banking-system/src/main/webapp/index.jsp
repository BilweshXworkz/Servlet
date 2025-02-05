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
<div class="card shadow-lg p-4" style="width: 250px;">
    <h3 class="text-center mb-3 ">Book Train</h3>
    <form action="ok" method="post">
        <div class="md-3">
            <label form="form-label">First Name</label>
            <input type="text" name="fullName">
            <label form="form-label">Date Of Birth</label>
            <input type="date" name="dob">
            <label form="form-label">Email ID</label>
            <input type="text" name="email">
            <label form="form-label">Account Number</label>
            <input type="text" name="acNumber">
            <label form="form-label">Depository Amount</label>
            <input type="text" name="depository">
        </div>
        <div class="md-3">
            <button type="submit" value="OK" class="btn btn-primary mt-3">Submit</button>
            <a href="depositoryDetails" class="btn btn-secondary mt-3">Depository Details</a>
        </div>
   </form>
</div>
</body>
</html>