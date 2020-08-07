<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ page import="com.wylegly.clinic.domain.Person" %>
<%@ page import="com.wylegly.clinic.domain.Patient" %>
<%@ page import="com.wylegly.clinic.domain.Doctor" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	
	<title>CMS - Add new patient</title>
	<link type="text/css"
		rel = "stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css">
		
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-patient-style.css">
	


</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CMS - Clinic Management System</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add Patient</h3>
		
		<form:form action="savePatient" modelAttribute="patient" method="POST">
		
			<!-- Retrieve doctor in charge to display id -->
				<%
					Patient patient = (Patient)request.getAttribute("patient");
					Doctor doctorInCharge = patient.getDoctorInCharge();
				%>
		<form:hidden path="id"/>
			<table>
				<tbody>
					
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName"/></td>
					</tr>
							
					<tr>				
						<td><label>Second name:</label></td>
						<td><form:input path="secondName"/></td>
					</tr>	
					
					<tr>
						<td><label>Surname:</label></td>
						<td><form:input path="surname"/></td>
					</tr>
					
					<tr>
						<td><label>Pesel:</label></td>
						<td><form:input path="pesel"/></td>
					</tr>
					
					<tr>
						<td><label>Select doctor in charge:</label></td>
						<td>
							
							<form:select var="doc" path="doctorInCharge" name="selectedDoctor">
							
								<form:option value=""/>
								<form:options 
									items="${doctorList}" 
									itemValue="id" 
									itemLabel="fullName"
								/>								
							</form:select>
							
						</td>	
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Add" class="save"/></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/patients/list">Back to patients list</a>
		</p>
		
	</div>

</body>
</html>