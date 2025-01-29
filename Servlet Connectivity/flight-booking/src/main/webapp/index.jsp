<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Book Your Flight</title>
</head>
<body>
<div class = "container">
    <form action="apply" method="post">
        First Name  : <input type="text" name="fName"><br>
        <br>
        From  : <input type="text" name="from"><br>
        <br>
        Departure : <input type="date" name="departure"><br>
        <br>
        Return : <input type="date" name="return"><br>
        <br>
        Travellers : <input type="text" name="num"><br>
        <br>
        <input type="submit" value="Apply">
    </form>
</div>
</body>
</html>