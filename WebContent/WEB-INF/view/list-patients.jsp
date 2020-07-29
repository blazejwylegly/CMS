<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

<!-- Add reference to css -->
<link type="text/css" 
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"/>
<meta charset="ISO-8859-1">


<title>Patients list</title>


</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CMS - Clinic Management System</h2>
			
			<br>
			<input type="button" value="Add Patient"
				   onclick="window.location.href ='addPatient'; return false;"
				   class="add-button"/>
			<br><br>
			
			<form:form action="searchPatient" method="GET">
				Search patient: <input type="text" name="searchedName"/>
				<input type="submit" value="Search"
				   class="add-button"/>
			</form:form>
			
			
			<!-- Table (list) of patients -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Second Name</th>
					<th>Surname</th>
					<th>Pesel</th>
					<th>Action</th>
				<tr/>
				
				<c:forEach var="tempPatient" items="${patients}">
				
					<!-- Create "update" link with patient id -->
					
					<c:url var="updateLink" value="/patients/updatePatient">
						<c:param name="patientId" value="${tempPatient.id}"/>
					</c:url>
					
					<c:url var="deleteLink" value="/patients/deletePatient">
						<c:param name="patientId" value="${tempPatient.id}"/>
					</c:url>					
					
					<tr>
						<td> ${tempPatient.firstName} </td>
						<td> ${tempPatient.secondName} </td>
						<td> ${tempPatient.surname} </td>
						<td> ${tempPatient.pesel} </td>
						<!-- Display update link -->
						<td> 
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this patient?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			
			</table>
		</div>
	</div>

</body>
</html>