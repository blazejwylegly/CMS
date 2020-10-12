<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.wylegly.clinic.domain.procedures.details.DentalProcedureDetails" %>
<%@ page import="java.time.Duration" %>
<%@ page import="com.wylegly.clinic.domain.procedures.details.DentalDetails" %>
<%@ page import="java.text.DateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Błażej
  Date: 21.09.2020
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Services price list</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"
    >

    <link type="text/css"
          rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/person-list-style.css"
    >

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
    <jsp:include
            page="${contextPath.request.contextPath}/WEB-INF/view/components/navigation-bar.jsp"
    ></jsp:include>

    <div class="container">
        <div class="person-list-wrapper">

            <h3>Single procedures</h3>
            <table class="person-list">
                <tr>
                    <th>Procedure name</th>
                    <th>Cost</th>
                    <th>Duration</th>
                    <th>Description</th>
                </tr>

                <c:forEach var="serviceDetails" items="${availableServices}">
                    <tr>
                        <td>${serviceDetails.name}</td>

                        <td>
                            <%
                                DentalDetails details =
                                        (DentalDetails) pageContext.getAttribute("serviceDetails");
                                DecimalFormat formatter = new DecimalFormat("#0.00 PLN");
                            %>
                            <% if (details.getCost() != null){ %>
                            <%= formatter.format(details.getCost().doubleValue())%>
                            <% } else {%>
                            Not provided
                            <% } %>

                        </td>

                        <td>
                            <% if(details.getDuration() != null) { %>
                            <%
                                Duration duration = details.getDuration();
                                long seconds = duration.getSeconds();
                                long absSeconds = Math.abs(seconds);
                                String positive = String.format(
                                        "%d:%02d:%02d",
                                        absSeconds / 3600,
                                        (absSeconds % 3600) / 60,
                                        absSeconds % 60);
                            %>
                            <%= positive%>
                            <% } else { %>
                            Not provided
                            <% } %>
                        </td>

                        <td>${serviceDetails.description}</td>
                    </tr>
                </c:forEach>
            </table>

            <br/>
            <h3>Procedure bundles</h3>
            <br/>

            <table class="person-list">
                <tr>
                    <th>Bundle name</th>
                    <th>Cost</th>
                    <th>Duration</th>
                    <th>Money saved</th>
                    <th>Description</th>
                    <th>Contents</th>
                </tr>

                <c:forEach var="bundleDetails" items="${availableBundles}">
                    <tr>
                        <td>${bundleDetails.name}</td>

<%--                        Cost display--%>
                        <td>
                            <%
                                DentalDetails details =
                                        (DentalDetails) pageContext.getAttribute("bundleDetails");
                                DecimalFormat formatter = new DecimalFormat("#0.00 PLN");
                            %>
                            <% if (details.getCost() != null){ %>
                            <%= formatter.format(details.getCost().doubleValue())%>
                            <% } else {%>
                            Not provided
                            <% } %>

                        </td>

                        <td>
                            <% if(details.getDuration() != null) { %>
                            <%
                                Duration duration = details.getDuration();
                                long seconds = duration.getSeconds();
                                long absSeconds = Math.abs(seconds);
                                String positive = String.format(
                                        "%d:%02d:%02d",
                                        absSeconds / 3600,
                                        (absSeconds % 3600) / 60,
                                        absSeconds % 60);
                            %>
                            <%= positive%>
                            <% } else { %>
                            Not provided
                            <% } %>
                        </td>
                        <td></td>
                        <td>${bundleDetails.description}</td>
                        <td></td>
                    </tr>
                </c:forEach>
            </table>


        </div>
    </div>
</body>
</html>
