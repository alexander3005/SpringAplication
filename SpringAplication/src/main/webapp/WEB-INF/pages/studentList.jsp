<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>

<html>
<head>
  <title>List Student</title>
  <style>
    body {
      font-size: 20px;
      color: teal;
      font-family: Calibri;
    }

    td {
      font-size: 15px;
      color: black;
      width: 100px;
      height: 22px;
      text-align: center;
    }

    .heading {
      font-size: 18px;
      color: white;
      font: bold;
      background-color: orange;
      border: thick;
    }
  </style>
</head>
<body>
<center>
  <h3> Student List</h3>


  <table border="1">

    <tr>
      <td class="heading">Id</td>
      <td class ="heading">Name</td>
      <td class = "heading">Second Name</td>
      <td class="heading">Edit</td>
      <td class="heading">Delete</td>

    </tr>

    <c:forEach items="${students}" var="student">
      <tr>
        <td>
            ${student.id}
        </td>
        <td>
            ${student.firstName}
        </td>
        <td>
            ${student.secondName}
        </td>
        <td> <a href="/edit?id=${student.id}">Edit</a></td>
        <td> <a href="/delete?id=${student.id}">Delete</a></td>

      </tr>
    </c:forEach>

    <td colspan="7"><a href="/student">Click Here to Add Student</a></td>
  </table>

</center>

</body>
</html>