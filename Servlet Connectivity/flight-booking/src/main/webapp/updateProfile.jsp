<%@ page language="java" contentType="text/html; charset=US-ASCII"
        pageEncoding="US-ASCII"%>
 <%@ page isELIgnored="false" %>
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
     <h5>${Message}</h5>
     <form action="update" method="post">
         <div class="md-3">
            <input type="test" name="id" hidden value="${dto.getId()}">
             <label form="form-label">First Name</label>
             <input type="text" name="fName" value = "${dto.getFirstName()}">
             <label form="form-label">Starting From</label>
             <input type="text" name="from" value = "${dto.getFrom()}">
             <label form="form-label">Starting Date</label>
             <input type="date" name="departure" value = "${dto.getDeparture()}">
             <label form="form-label">Return Date</label>
             <input type="date" name="returns" value = "${dto.getReturns()}">
             <label form="form-label">Number Of Travels</label>
             <input type="text" name="num" value = "${dto.getNumber()}">
         </div>
         <div class="md-3">
             <button type="submit" value="update" class="btn btn-primary mt-3">Update</button>
         </div>
     </form>
 </div>
 </body>
 </html>