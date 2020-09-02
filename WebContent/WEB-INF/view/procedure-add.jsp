<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Save procedure</title>

    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css"
    />

    <link
      rel="stylesheet" 
      href="${pageContext.request.contextPath}/resources/css/add-person-style.css"
    />

    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap"
      rel="stylesheet"
    />
  </head>
  <body>
    <jsp:include
      page="${contextPath.request.contextPath}/WEB-INF/view/components/navigation-bar.jsp"
    />
  
    <div class="person-add-wrapper">
      <form:form action="saveProcedure" modelAttribute="newProcedure" method="POST">
        <form:hidden path="id" />
        <table class="input-list">
          <tbody>
          	<tr>
          		<td>
          		<label>Adding procedure for ${selectedPatient.fullName}</label>
          		</td>
          	</tr>
            <tr>
              <td>
                <label>Procedure date</label>
              </td>
              <td>
                <form:input path="date"/>
                <fmt:formatDate type="date" value="${date}"/>
              </td>
            </tr>
            <tr>
              <td>
                <label>Procedure time</label>
              </td>
              <td>
                <form:input path="time"/>
                <fmt:formatDate type="time" value="${time}"/>
              </td>
            </tr>
            <tr>
              <td>
              	<label>Select doctor</label>
              </td>
              <td>
              	<form:select 
	              	var="docOption" 
	              	path="doctor"
	              	name="selectedDoctor"
	            >
	              	<form:options
	              		items="${doctors}"
	              		itemValue="id"
	              		itemLabel="fullName"
	              	/>
	        
	            </form:select>
              </td>
            </tr>
            <tr>
              <td></td>
              <td></td>
            </tr>
            <tr>
              <td></td>
              <td></td>
            </tr>
          </tbody>
        </table>
      </form:form>
    </div>

  </body>
</html>
