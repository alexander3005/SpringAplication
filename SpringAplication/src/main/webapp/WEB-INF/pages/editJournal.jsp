<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">




<html>
<head>
  <title>Journal Update</title>
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



  <b> Journal | Update Form </b>

  <div>
    <form:form method="POST" action="updateJournal" modelAttribute="journal">
      <table>

        <tr>
          <td>Id:</td>
          <td><form:input readonly="true" path="id"/> </td>
        </tr>
        <tr>
          <td>Id Student :</td>
          <td><form:input path="studentId" /></td>

        </tr>
        <tr>
          <td>Id Discipline :</td>
          <td><form:input path="disciplineId" /></td>
        </tr>

        <tr>
          <td> </td>
          <td><input type="submit" value="Save" /></td>
        </tr>
        <tr>

      </table>
    </form:form>
  </div>
</center>
</body>
</html>