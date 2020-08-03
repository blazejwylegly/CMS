<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CMS - Home page</title>
</head>
<body>
	<h1>Welcome to Clinic Management System</h1>

	<P>The time on the server is ${serverTime}.</p>
	
	<p>
		<a href="${pageContext.request.contextPath}/patients/list">Patients tab</a>
	</p>
	
	<p>
		<a href="${pageContext.request.contextPath}/doctors/list">Doctors tab</a>
	</p>

</body>
</html>