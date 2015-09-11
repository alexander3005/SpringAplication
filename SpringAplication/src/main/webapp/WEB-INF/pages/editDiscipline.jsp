<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 10.09.2015
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Student Update</title>
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



  <b> Discipline | Update Form </b>

  <div>
    <form:form method="POST" action="updateDiscipline" modelAttribute="discipline">
      <table>

        <tr>
          <td>Id:</td>
          <td><form:input readonly="true" path="id"/> </td>
        </tr>
        <tr>
          <td>Discipline Name :</td>
          <td><form:input path="nameDiscipline" /></td>
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
