<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Doctor Details</title>

    <!-- Add reference to css -->
    <link
      type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css"
    />

    <link
      type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/add-patient-style.css"
    />

    <link
      href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap"
      rel="stylesheet"
    />
  </head>

  <body>
    <jsp:include
      page="${contextPath.request.contextPath}/WEB-INF/view/components/navigation-bar.jsp"
    ></jsp:include>

    <div id="wrapper">
      <div id="header">
        <h2>CMS - Clinic Management System</h2>

        <hr />
        <h3>Doctor details</h3>

        <div id="outer">
          <div class="inner">
            <!-- Modify button -->
            <form:form action="updateDoctor" method="GET">
              <input type="hidden" value=<%= request.getParameter("doctorId") %>
              name="doctorId"/>

              <input type="submit" value="Modify" class="add-button" />
            </form:form>
          </div>

          <div class="inner">
            <!-- Delete button -->
            <form:form action="deleteDoctor" method="GET">
              <input type="hidden" value=<%= request.getParameter("doctorId") %>
              name="doctorId"/>

              <input
                type="submit"
                value="Delete"
                class="add-button"
                onclick="if (!(confirm('Are you sure you want to delete this doctor?'))) return false"
              />
            </form:form>
          </div>
        </div>

        <!-- Personal details -->
        First name: ${doctor.firstName}
        <br />
        Second name: ${doctor.secondName}
        <br />
        Surname: ${doctor.surname}
        <br />
        Pesel number: ${doctor.pesel}
        <br />
        Work start time: ${doctor.workStart}
        <br />
        Work end time: ${doctor.workEnd}
        <br />
        <br />

        <!-- Doctors patients -->
        <table>
          <!-- Headers -->
          <tr>
            <th>First Name</th>
            <th>Second Name</th>
            <th>Surname</th>
            <th>Pesel</th>
            <th>Action</th>
          </tr>

          <!-- Patients data -->
          <c:forEach var="item" items="${patients}">
            <!-- Setup link for patients details -->
            <c:url var="detailsLink" value="patients/details">
              <c:param name="patientId" value="${item.id}" />
            </c:url>

            <tr>
              <!-- Display data -->
              <td>${item.firstName}</td>
              <td>${item.secondName}</td>
              <td>${item.surname}</td>
              <td>${item.pesel}</td>

              <!-- Display details link -->
              <td>
                <a href="${detailsLink}">Details</a>
              </td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </div>
  </body>
</html>
