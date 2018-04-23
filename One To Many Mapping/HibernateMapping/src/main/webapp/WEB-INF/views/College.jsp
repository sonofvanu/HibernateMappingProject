<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="college" action="incollege">
		<form:input type="text" placeholder="ENter ytour name"
			path="collegeName"></form:input>
		</br>
		<input type="submit" value="SUBMIT">
	</form:form>
	
	
	<table>
	<tr>
	<td>College id</td>
	<td>College Name</td>
	<td>Students</td>
	</tr>
	<c:forEach items="${colleges}" var="c">
	<tr>
	<td>${c.getCollegeId()}</td>
	<td>${c.getCollegeName()}</td>
	<c:forEach items="${c.getStudents()}" var="s">
	<td>${s.getStudentName()}</td>
	</c:forEach>
	</tr>
	</c:forEach>
	
	</table>
</body>
</html>