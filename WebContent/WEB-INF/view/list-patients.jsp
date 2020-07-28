<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

<!-- Add reference to css -->
<link type="text/css" 
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"/>
<meta charset="ISO-8859-1">


<title>Patients</title>


</head>
<body>

	<div id="primaryStyle">
		<div id="header">
			<h2>CMS - Clinic Management System</h2>
			<!-- Table (list) of patients -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Second Name</th>
					<th>Surname</th>
					<th>Pesel</th>
				<tr/>
				
				<c:forEach var="tempPatient" items="${patients}">
					<tr>
						<td> ${tempPatient.firstName} </td>
						<td> ${tempPatient.secondName} </td>
						<td> ${tempPatient.surname} </td>
						<td> ${tempPatient.pesel} </td>
					</tr>
				</c:forEach>
			
			</table>
		</div>
	</div>

</body>
</html>