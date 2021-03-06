<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Form</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
<div id="header">
<h2 align="center">Student Form</h2>
</div>
</div>
<div id="container">
<h3>Save Student</h3>
<form:form action="saveStudent" modelAttribute="student" method="POST">
<form:hidden path="id"/>

<table>
<tbody>
<tr>
<td><label>First Name:</label></td>
<td><form:input path="firstName"/></td>
</tr>

<tr>
<td><label>Last Name:</label></td>
<td><form:input path="lastName"/></td>
</tr>

<tr>
<td><label>Age :</label></td>
<td><form:input path="age"/></td>
</tr>


<tr>
<td><label>Class Admission :</label></td>
<td><form:input path="classadmission"/></td>
</tr>

<tr>
<td><label></label></td>
<td><input type="submit" value="save" class="save"/> </td>
</tr>


</tbody>

</table>

</form:form>
<div style="clear";both;">
</div>
<p>
<a href="${pageContext.request.contextPath}/student/list">Back to List</a>
</p>

</div>
</body>
</html>