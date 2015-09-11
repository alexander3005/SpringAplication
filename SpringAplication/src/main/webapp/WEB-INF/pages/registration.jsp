<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">




<html>
<head>
    <title>Student Registration</title>
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



<b> Student | Registration Form </b>

<div>
    <form:form method="POST" action="addStudent" modelAttribute="student">
<table>

       <tr>
           <td>First Name :</td>
           <td><form:input path="firstName" /></td>
       </tr>
    <tr>
        <td>Second Name :</td>
        <td><form:input path="secondName" /></td>
    </tr>

    <tr>
        <td> </td>
        <td><input type="submit" value="Save" /></td>
    </tr>


</table>
    </form:form>
    </div>
    </center>
</body>
</html>