<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students List</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

<div id="wrapper">
<div id="header">
<h2 align="center">Student Info</h2>


</div>

</div>

<div id="container">
<div id="content">

<input type="button" value="Add Student" onclick="window.location.href='showFormForAdd';return false;" class="add-button"/><br>

<form:form action="search" method="POST">
Search Student : <input type="text" name="theSearchName"/>
<input type="submit" value="Search" class="add-button"/>
</form:form>
<table>

<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Age</th>
<th> Class Enrolled</th>
<th>Action</th>
</tr>
<C:forEach var="tempstudent" items="${student}">
<C:url var="UpdateLink" value="/student/showFormForUpdate">
<C:param name="studentId" value="${tempstudent.id}"/>
</C:url>
<C:url var="DeleteLink" value="/student/delete">
<C:param name="studentId" value="${tempstudent.id}"/>
</C:url>
<tr>
<td>${tempstudent.firstName}</td>
<td>${tempstudent.lastName }</td>
<td>${tempstudent.age }</td>
<td>${tempstudent.classadmission}</td>
<td> <a href="${UpdateLink}">Update</a>
| 
<a href="${DeleteLink}" onclick="if(!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
</td>
</tr>
</C:forEach>
</table>

</div>

</div>


</body>
</html>