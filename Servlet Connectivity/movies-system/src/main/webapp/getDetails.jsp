<%@ page language="java" contentType="text/html; charset=US-ASCII"
        pageEncoding="US-ASCII"%>
 <%@ page isELIgnored="false" %>
<%@ taglib prefix="ref" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>The Responses</title>
    <style>
         <style>
                table {
                    width: 50%;
                    border-collapse: collapse;
                    margin: 20px auto;
                }
                th, td {
                    border: 1px solid #000;
                    padding: 8px;
                    text-align: center;
                }
                th {
                    background-color: #f2f2f2;
                }
            </style>
    </style>
</head>
<body>
    <table>
      <tr>
        <th>Movie Name</th>
        <th>Hero </th>
        <th>Heroin</th>
        <th>Action</th>
      </tr>
        <ref:forEach items="${movies}" var="movies">
      <tr>
        <td>${ movies.getMName() }</td>
        <td>${ movies.getHero() }</td>
        <td>${ movies.getHeroin() }</td>
        <td><a href="delete?userId=${movies.getId()}">DELETE</a></td>
      </tr>
      </ref:forEach>
    </table>
</body>
</html>