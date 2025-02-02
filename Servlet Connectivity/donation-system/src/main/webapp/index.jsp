<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Donation</title>
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
<div class="card shadow-lg p-4" style="width: 280px;">
    <h3 class="text-center mb-3 ">Donation</h3>
    <form action="donate" method="post">
    <div class="md-3">
        <label for="form-label">Name</label>
        <input type="text" name="name">
        <label for="form-label">Phone Number</label>
        <input type="text" name="phoneNumber">
        <label for="form-label">Donation Amount</label>
        <input type="text" name="dAmount">
        <label for="form-label">Payment</label>
        <input type="text" name="payment">
        <div class="md-3">
        <button type="submit" value="Order" class="btn btn-primary mt-3">Submit</button>
        <a href="donation" class="btn btn-secondary mt-3">Donation Details</a>
     </div>
        </form>
    </div>
</div>
</body>
</html>