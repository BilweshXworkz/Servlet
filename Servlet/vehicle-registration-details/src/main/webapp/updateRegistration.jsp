<%@ page language="java" contentType="text/html; charset=US-ASCII"
        pageEncoding="US-ASCII"%>
 <%@ page isELIgnored="false" %>
 <!DOCTYPE html>
 <html lang="en">
 <head>
     <meta charset="UTF-8">
     <title>Vehicle Registration</title>
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
     <h3 class="text-center mb-3 ">Vehicle Registration</h3>
     <form action="update" method="post">
     <div class="md-3">
         <input type="text" hidden name="id" value="${dto.getId()}">
         <label form="form-label">First Name</label>
         <input type="text" name="firstName" value="${dto.getFirstName()}">
         <label form="form-label">Last Name</label>
         <input type="text" name="lastName" value="${dto.getLastName()}">
         <label form="form-label">Phone Number</label>
         Phone Number : <input type="text" name="phoneNumber" value="${dto.getPhoneNumber()}">
         <label form="form-label">Email ID</label>
         <input type="text" name="emailId" value="${dto.getEmailId()}">
         <label form="form-label">Vehicle Name</label>
         <input type="text" name="vehicleName" value="${dto.getVehicleName()}">
         <label form="form-label">Vehicle Type</label>
         <input type="text" name="vehicleType" value="${dto.getVehicleType()}">
         <label form="form-label">RTO Code</label>
         <input type="text" name="code" value="${dto.getCode()}">
         </div>
         <div class="md-3">
             <button type="submit" value="update" class="btn btn-primary mt-3">Update</button>
             <a href="details" class="btn btn-secondary mt-3">Vehicle Details</a>
         </div>
     </form>
 </div>
 </body>
 </html>