<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 09.09.2015
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Discipline List</title>
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
      text-align: left;
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
  <h3>Discipline List</h3>
  <table border="1">

    <tr>
      <td class = " heading">Id</td>
      <td class = "heading" >Name Discipline</td>
      <td class="heading">Edit</td>
      <td class="heading">Delete</td>
    </tr>
    <c:forEach items = "${disciplines}" var ="discipline">
    <tr>
      <td>
        ${discipline.id}
      </td>
    <td>
      ${discipline.nameDiscipline}
    </td>
      <td> <a href="editDiscipline?id=${discipline.id}">Edit</a></td>
      <td> <a href="deleteDiscipline?id=${discipline.id}">Delete</a></td>

    </tr>

    </c:forEach>
    <td colspan ="7"><a href="discipline">Click here to Add Discipline</a> </td>
</table>
  <p></p>
  <a href="journalList">Journal  DataBase</a>
  </center>

</body>
</html>
