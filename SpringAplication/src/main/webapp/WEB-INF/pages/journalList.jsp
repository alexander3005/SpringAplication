<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
  <title>List Journal</title>
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
  <h3> Journal List</h3>


  <table border="1">

    <tr>
      <td class="heading">Id</td>
      <td class ="heading">Name</td>
      <td class = "heading">Second Name</td>
      <td class = "heading">Name Discipline</td>
      <td class="heading">Edit</td>
      <td class="heading">Delete</td>

    </tr>

    <c:forEach items="${journals}" var="table">
      <tr>
        <td>
            ${table.journal.id}
        </td>
        <td>
            ${table.student.firstName}
        </td>
        <td>
            ${table.student.secondName}
        </td>
        <td>
            ${table.discipline.nameDiscipline}
        </td>


        <td> <a href="editJournal?id=${table.journal.id}">Edit</a></td>
        <td> <a href="deleteJournal?id=${table.journal.id}">Delete</a></td>

      </tr>
    </c:forEach>

    <td colspan="7"><a href="journal">Click Here to Add Journal</a></td>
  </table>
  <p></p>
  <a href="studentList">Student DataBase</a>
  <p></p>
  <a href="disciplineList">Discipline DataBase</a>
  <p>

</center>

</body>
</html>