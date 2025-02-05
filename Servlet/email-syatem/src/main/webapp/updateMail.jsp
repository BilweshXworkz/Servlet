<%@ page language="java" contentType="text/html; charset=US-ASCII"
        pageEncoding="US-ASCII"%>
 <%@ page isELIgnored="false" %>
<%@ taglib prefix="ref" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Email</title>
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
        <h3 class="text-center mb-4 ">Email</h3>
    <form action="update" method="post">
    <div class="md-5">
        <input type="text" hidden name="id" value="${dto.getId()}">
        <label for="form-label">To Email</label>
        <input type="text" name="toEmail" value="${dto.getToMail()}">
        <label for="form-label">Subject</label>
        <input type="text" name="subject" value="${dto.getSubject()}">
        <label for="form-label">Content</label>
        <textarea name="content" value="${dto.getContent()}"></textarea>
        </div>
            <div class="md-3">
        <button type="submit" value="update" class="btn btn-primary mt-3">update</button>
        <a href="details"class="btn btn-secondary mt-3">Email Details</a>
   </div>
           </form>
       </div>
</body>
</html>