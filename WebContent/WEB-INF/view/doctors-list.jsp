<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib prefix="form"
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
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.12.1/css/all.css"
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
      <!-- Add doctor button -->
      <input
        type="button"
        value="Add Doctor"
        onclick="window.location.href ='addDoctor'; return false;"
        class="add-button"
      />
      <br /><br />

      <!-- Search doctor bar -->
      <form:form action="searchDoctor" method="GET">
        Search doctor: <input type="text" name="searchedName" />
        <input type="submit" value="Search" class="add-button" />
      </form:form>

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

            <tr>
              <td>${tempDoctor.fullName}</td>
              <td>${tempDoctor.pesel}</td>
              <td>${tempDoctor.childrenDoctor}</td>
              <td>${tempDoctor.workStart}</td>
              <td>${tempDoctor.workEnd}</td>

              <!-- Display update, update, details links -->
              <td>
                <div class="action-buttons">
                  <a href="${updateLink}">
                    <i id="person-edit-button" class="fas fa-user-edit 2x"></i>
                  </a>
                  <a
                    href="${deleteLink}"
                    onclick="if (!(confirm('Are you sure you want to delete this doctor?'))) return false"
                  >
                    <i id="person-delete-button" class="fas fa-user-times"></i>
                  </a>

                  <a href="${detailsLink}">
                    <i id="person-detail-button" class="fas fa-info-circle"></i
                  ></a>
                </div>
              </td>
            </tr>
          </c:forEach>
        </tr>
      </table>
    </div>

    <p>
      <a href="${pageContext.request.contextPath}/home">Back to home page</a>
    </p>
  </body>
</html>
