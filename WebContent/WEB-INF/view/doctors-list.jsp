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


<title>Doctors list</title>


</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CMS - Clinic Management System</h2>
			
			<br>
			<input type="button" value="Add Doctor"
				   onclick="window.location.href ='addDoctor'; return false;"
				   class="add-button"/>
			<br><br>
			
			<form:form action="searchDoctor" method="GET">
				Search doctor: <input type="text" name="searchedName"/>
				<input type="submit" value="Search"
				   class="add-button"/>
			</form:form>
			
			
			<!-- Table (list) of doctors -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Second Name</th>
					<th>Surname</th>
					<th>Pesel</th>
					<th>Children Doctor</th>
					<th>Work start</th>
					<th>Work end</th>
					<th>Action</th>
				<tr/>
				
				<c:forEach var="tempDoctor" items="${doctors}">
				
					<!-- Create "update" link with patient id -->
					
					<c:url var="updateLink" value="/doctors/updateDoctor">
						<c:param name="doctorId" value="${tempDoctor.id}"/>
					</c:url>
					
					<c:url var="deleteLink" value="/doctors/deleteDoctor">
						<c:param name="doctorId" value="${tempDoctor.id}"/>
					</c:url>
					
					<c:url var="detailsLink" value="/doctors/details">
						<c:param name="doctorId" value="${tempDoctor.id}"/>
					</c:url>					
					
					<tr>
						<td> ${tempDoctor.firstName} </td>
						<td> ${tempDoctor.secondName} </td>
						<td> ${tempDoctor.surname} </td>
						<td> ${tempDoctor.pesel} </td>
						<td> ${tempDoctor.childrenDoctor} </td>
						<td> ${tempDoctor.workStart} </td>
						<td> ${tempDoctor.workEnd} </td>
						
						<!-- Display update and delete link -->
						<td> 
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this doctor?'))) return false">Delete</a>
							|
							<a href="${detailsLink}">Details</a>
						</td>
					</tr>
				</c:forEach>
			
			</table>
		</div>
	</div>
	
	<p>
		<a href="${pageContext.request.contextPath}/home">Back to home page</a>
	</p>
	

</body>
</html>