<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Movies</title>
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
    <h3 class="text-center mb-3 ">Movies</h3>
    <form action="send" method="post">
        <div class="md-3">
        <label for="form-label">Movie Name</label>
        <input type="text" name="mName">
        <label for="form-label">Hero</label>
        <input type="text" name="hero">
        <label for="form-label">Heroin</label>
        <input type="text" name="heroin">
        <div class="md-3">
        <button type="submit" value="Send" class="btn btn-primary mt-3">Submit</button>
        <a href = "details" class="btn btn-secondary mt-3">Movies Details</a>
    </div>
        </form>
    </div>
</div>
</body>
</html>