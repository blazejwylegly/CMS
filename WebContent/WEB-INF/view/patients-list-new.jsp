<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ page import="com.wylegly.clinic.domain.Person"
%> <%@ page import="com.wylegly.clinic.domain.Patient" %> <%@ page
import="com.wylegly.clinic.domain.Doctor" %> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
    <!-- Add reference to css -->
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
    <title>Patients list</title>
  </head>

  <body>
    <jsp:include
      page="${contextPath.request.contextPath}/WEB-INF/view/components/navigation-bar.jsp"
    ></jsp:include>

    <div class="container">
      <br />
      <div class="person-list-wrapper">
        <!-- Search bar -->
        <div class="search-bar">
          <form:form action="searchPatient" method="GET">
            <!-- Input bar -->
            <input
              type="text"
              name="searchedName"
              class="styled-input"
              placeholder="Search for patient..."
            />

            <!-- Search button -->
            <button type="submit" value="search" class="styled-button">
              <i class="fas fa-search"></i>
            </button>
          </form:form>

          <!-- Add button -->
          <input
            type="button"
            value="Add Patient"
            onclick="window.location.href ='addPatient'; return false;"
            class="styled-button"
            class="align-left"
          />
        </div>

        <!-- Table (list) of patients -->
        <table class="person-list">
          <!-- Table headers -->
          <tr>
            <th>Name</th>
            <th>Pesel</th>
            <th>Doctor in charge</th>
            <th>Action</th>
          </tr>

          <!-- Iterate all patients -->
          <c:forEach var="tempPatient" items="${patients}">
            <!-- Retrieve doctor in charge to display id -->
            <% Patient patient =
            (Patient)pageContext.getAttribute("tempPatient"); Doctor
            doctorInCharge = patient.getDoctorInCharge(); %>

            <!-- Update link with patientId parameter -->
            <c:url var="updateLink" value="/patients/updatePatient">
              <c:param name="patientId" value="${tempPatient.id}" />
            </c:url>

            <!-- Delete link with patientId parameter -->
            <c:url var="deleteLink" value="/patients/deletePatient">
              <c:param name="patientId" value="${tempPatient.id}" />
            </c:url>

            <!-- Details link -->
            <c:url var="detailsLink" value="/patients/details">
              <c:param name="patientId" value="${tempPatient.id}" />
            </c:url>

            <%-- New procedure link --%>
            <c:url var="newProcedureLink" value="/procedures/addProcedure">
              <c:param name="patientId" value="${tempPatient.id}" />
            </c:url>

            <tr>
              <td>${tempPatient.fullName}</td>
              <td>${tempPatient.pesel}</td>
              <td>
                <% if (doctorInCharge != null) { %> <%=
                doctorInCharge.getFullName() %> <% } else { %> <%= "" %> <% } %>
              </td>
              <!-- Display update and delete links -->
              <td>
                <div class="action-buttons">
                  <!-- Update icon -->
                  <a href="${updateLink}">
                    <i class="fas fa-user-edit"></i>
                  </a>

                  <!-- Delete icon -->
                  <a
                    href="${deleteLink}"
                    onclick="if (!(confirm('Are you sure you want to delete this patient?'))) return false"
                  >
                    <i class="fas fa-user-times"></i>
                  </a>

                  <!-- Details icon -->
                  <a href="${detailsLink}">
                    <i class="fas fa-info-circle"></i>
                  </a>

                  <!-- Add new procedure icon -->
                  <a href="${newProcedureLink}">
                    <i class="far fa-calendar-plus"></i>
                  </a>
          
                </div>
              </td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </div>

    <!-- Back link -->
    <p>
      <a href="${pageContext.request.contextPath}/home">Back to home page</a>
    </p>
  </body>
</html>
