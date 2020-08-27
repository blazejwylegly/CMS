<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />

    <title>CMS - Save doctor</title>
    <link
      type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css"
    />

    <link
      type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/add-person-style.css"
    />

    <link
      type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/default-elements.css"
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
      <form:form action="saveDoctor" modelAttribute="doctor" method="POST">
        <form:hidden path="id" />
        <table class="input-list">
          <tbody>
            <tr>
              <td><label>First name:</label></td>
              <td><form:input path="firstName" /></td>
            </tr>

            <tr>
              <td><label>Second name:</label></td>
              <td><form:input path="secondName" /></td>
            </tr>

            <tr>
              <td><label>Surname:</label></td>
              <td><form:input path="surname" /></td>
            </tr>

            <tr>
              <td><label>Pesel:</label></td>
              <td><form:input path="pesel" /></td>
            </tr>

            <tr>
              <td><label>Work start:</label></td>
              <td>
                <fmt:formatDate type="time" value="${workStart}" />
                <form:input path="workStart" />
              </td>
            </tr>

            <tr>
              <td><label>Work end:</label></td>
              <td>
                <form:input path="workEnd" />
                <fmt:formatDate type="time" value="${workEnd}" />
              </td>
            </tr>

            <tr>
              <td><label>Children doctor:</label></td>
              <td>
                <label class="checkbox-wrapper">
                  <!-- Hiding default checkbox element -->
                  <form:checkbox path="childrenDoctor" />
                  <!-- Showing custom styled element -->
                  <span class="checkbox-custom"></span>
                </label>
              </td>
            </tr>

            <tr>
              <td><label></label></td>
              <td><input type="submit" value="Save" class="styled-button" /></td>
            </tr>
          </tbody>
        </table>
      </form:form>
    </div>
  </body>
</html>
