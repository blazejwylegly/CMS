<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Login confirmation</title>
</head>
<body>

Login confirmed, welcome ${user.username}
<br><br>
Your current password: ${user.password}
<br><br>
Test var value: ${user.testVar}
</body>
</html>