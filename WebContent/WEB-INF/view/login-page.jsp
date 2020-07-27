<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Clinic management system</title>

	<style>
		.error {color:red}
	</style>
</head>
<body>

<h1>Enter login data</h1>

<i>Fill out the form. Asterisk (*) means required. </i>
	<br><br>
	
	<form:form action="processLogin" modelAttribute="user">
	
		User name (*): <form:input path="username"/>
		<form:errors path="username" cssClass="error"/>
		<br><br>
		
		Password (*): <form:input path="password"/>
		<form:errors path="password" cssClass="error"/>
		
		<br><br>
		
		Test var: <form:input path="testVar"/>
		<form:errors path="testVar" cssClass="error"/>
		
		<br><br>
		
		MedCode: <form:input path="medCode"/>
		<form:errors path="medCode" cssClass="error"/>
		<br><br>
		<input type="submit" value="Proceed"/>
	</form:form>
</body>
</html>