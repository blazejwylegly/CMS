<%--
  Created by IntelliJ IDEA.
  User: Błażej
  Date: 08.09.2020
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link
        type="text/css"
        rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/style.css"
    />
</head>
<body>
    <jsp:include page="components/navigation-bar.jsp"/>
    <br>
    
    <h2>
        Access denied!
    </h2>
    <br>
    <a href = "${pageContext.request.contextPath}/home">
        Home page
    </a>
</body>
</html>
