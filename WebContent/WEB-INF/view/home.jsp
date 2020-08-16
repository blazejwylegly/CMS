<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>CMS - Home page</title>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css"
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
    <!-- <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <h1>Welcome to Clinic Management System</h1>

    <P>The time on the server is ${serverTime}.</P>

    <ul>
      <li>
        <a href="${pageContext.request.contextPath}/patients/list">Patients</a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath}/doctors/list">Doctors</a>
      </li>
    </ul> -->
  </body>
</html>
