<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Event-Management</title>
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
    <h3 class="text-center mb-3 ">Event Management</h3>
    <form action="addEvent" method="post">
    <div class="md-3">
        <label for="form-label">User Name</label>
        <input type="text" name="uName">
        <label for="form-label">Date Of Birth</label>
        <input type="text" name="dob">
        <label for="form-label">Email ID</label>
        <input type="text" name="email">
        <label for="form-label">Address</label>
        <input type="text" name="address">
        <label for="form-label">Event Type</label>
        <input type="text" name="eventType">
         </div>
         <div class="md-3">
        <button type="submit" value="Add Event" class="btn btn-primary mt-3">Submit</button>
        <a href="event" class="btn btn-secondary mt-3">Get All Event</a>
    </div>
        </form>
    </div>
</body>
</html>