<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> 

<%@ taglib 
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib 
prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page
import="com.wylegly.clinic.domain.procedures.DentalProcedure" %>


<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Procedures</title>

    <link
      type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css"
    />

    <link
      type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/person-list-style.css"
    />

    <link
      type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/default-elements.css"
    />

    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.12.1/css/all.css"
    />

    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap"
      rel="stylesheet"
    />
  </head>

  <body>
    <!-- Include navigation bar -->
    <jsp:include
      page="${contextPath.request.contextPath}/WEB-INF/view/components/navigation-bar.jsp"
    ></jsp:include>

    <div class="container">
      <div class="person-list-wrapper">
        <div class="search-bar">
          <input
            type="button"
            class="styled-button"
            value="Add Procedure"
            onclick="window.location.href = 'addProcedure'; return false;"
          />
        </div>

        <table class="person-list">
          <!-- Headers row -->
          <tr>
            <th>Patient</th>
            <th>Doctor</th>
            <th>Date</th>
            <th>Time</th>
            <th>Name</th>
            <th>Cost</th>
            <th>Duration</th>
          </tr>

          <!-- Data rows -->

          <c:forEach var="tempProcedure" items="${procedures}">
            <!-- Define action links -->

            <!-- Retrieve current procedure as java object -->
            <% DentalProcedure procedure = (DentalProcedure)pageContext.getAttribute("tempProcedure"); %>
            <tr>
              <td>
                <% if(procedure.getPatient() != null) {%>
                <%= procedure.getPatient().getFullName() %>
                <% } else { %>
                <%= "" %>
                <% } %>
              </td>

              <td>
                <% if(procedure.getDoctor() != null) {%>
                <%= procedure.getDoctor().getFullName() %>
                <% } else { %>
                <%= "" %>
                <% } %>
              </td>

              <td>${tempProcedure.date}</td>
              <td>${tempProcedure.time}</td>
              <td>Temp name</td>
              <td>Temp cost</td>
              <td>Temp duration</td>

            </tr>
          </c:forEach>
        </table>
      </div>
    </div>
  </body>
</html>
