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
	<form:form modelAttribute="student" action="instudent">
		<form:input type="text" placeholder="Student name" path="studentName"></form:input>
		</br>
		<form:input type="text" placeholder="Dept"
			path="studentDepartment"></form:input>
		</br>

		<select name="lol">
			<c:forEach items="${colleges}" var="pd">
				<option value="${pd.getCollegeId()}" label="${pd.getCollegeName()}">
			</c:forEach>
		</select>
		</br>
		<input type="submit" value="SUBMIT">
	</form:form>
</body>
</html>