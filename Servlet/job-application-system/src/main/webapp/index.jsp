<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Apply for Job</title>
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
    <h3 class="text-center mb-3 ">Apply for Job</h3>
    <form action="apply" method="post">
    <div class="md-3">
        <label for="form-label">First Name</label>
        <input type="text" name="firstName">
        <label for="form-label">Last Name</label>
        <input type="text" name="lastName">
        <label for="form-label">Phone Number</label>
        <input type="text" name="phoneNumber">
        <label for="form-label">Email ID</label>
        <input type="text" name="emailId">
        <label for="form-label">Job Applying</label>
        <input type="text" name="jobApplying">
    </div>
    <div class="md-3">
            <button type="submit" value="submit" class="btn btn-primary mt-3">Submit</button>
            <a href="details" class="btn btn-secondary mt-3">Application Details</a>
    </div>
   </form>
</div>
</body>
</html>