<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Procedures overview</title>

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
    />
    <br />
    <br />
    Welcome to procedures tab
  </body>
</html>
