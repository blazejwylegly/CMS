<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
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
    
   
    <!-- Display user ID and user authorities -->
    <div class="home-bg"></div>
  </body>
</html>
