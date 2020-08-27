<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %> <%@ page
import="com.wylegly.clinic.domain.Person" %> <%@ page
import="com.wylegly.clinic.domain.Doctor" %>

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

    <meta charset="ISO-8859-1" />

    <title>Doctors list</title>
  </head>
  <body>
    <!-- Include navigation bar -->
    <jsp:include
      page="${contextPath.request.contextPath}/WEB-INF/view/components/navigation-bar.jsp"
    ></jsp:include>

    <div class="container">
      <br />
      <div class="person-list-wrapper">
        <!-- Search doctor bar -->
        <div class="search-bar">
          <form:form style="width: 100%" action="searchDoctor" method="GET">
            <!-- Input bar -->
            <input
              class="styled-input"
              type="text"
              name="searchedName"
              placeholder="Search for doctor..."
            />
            <!-- Search Button -->
            <button type="submit" value="search" class="styled-button">
              <i class="fas fa-search"></i>
            </button>

            <!-- Add button -->
            <input
              type="button"
              value="Add Doctor"
              onclick="window.location.href ='addDoctor'; return false;"
              class="styled-button"
              class="align-left"
            />
          </form:form>
        </div>

        <!-- Table (list) of doctors -->
        <table class="person-list">
          <tr>
            <th>Name</th>
            <th>Pesel</th>
            <th>Children Doctor</th>
            <th>Work start</th>
            <th>Work end</th>
            <th>Action</th>
          </tr>

          <c:forEach var="tempDoctor" items="${doctors}">
            <!-- Update link -->
            <c:url var="updateLink" value="/doctors/updateDoctor">
              <c:param name="doctorId" value="${tempDoctor.id}" />
            </c:url>

            <!-- Delete link -->
            <c:url var="deleteLink" value="/doctors/deleteDoctor">
              <c:param name="doctorId" value="${tempDoctor.id}" />
            </c:url>

            <!-- Details link -->
            <c:url var="detailsLink" value="/doctors/details">
              <c:param name="doctorId" value="${tempDoctor.id}" />
            </c:url>

            <!-- Retrieve doctor for convenience of use -->
            <% Doctor currentDoctor =
            (Doctor)pageContext.getAttribute("tempDoctor"); %>

            <tr>
              <td>${tempDoctor.fullName}</td>
              <td>${tempDoctor.pesel}</td>
              <td>
                <% if (currentDoctor.getChildrenDoctor()) { %>
                <i style="color: #26a637" class="fas fa-check"></i>
                <% } else { %>
                <i style="color: #d71d2d" class="fas fa-times"></i>
                <% } %>
              </td>
              <td>${tempDoctor.workStart}</td>
              <td>${tempDoctor.workEnd}</td>

              <!-- Display update, update, details links -->
              <td>
                <div class="action-buttons">
                  <a href="${updateLink}">
                    <i class="fas fa-user-edit"></i>
                  </a>
                  <a
                    href="${deleteLink}"
                    onclick="if (!(confirm('Are you sure you want to delete this doctor?'))) return false"
                  >
                    <i class="fas fa-user-times"></i>
                  </a>

                  <a href="${detailsLink}">
                    <i class="fas fa-info-circle"></i
                  ></a>
                </div>
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
