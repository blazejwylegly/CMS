 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> 

<div class="nav-bar">
  <nav>
    <!-- Display logo -->
    <div class="logo">LOGO</div>

    <!-- Display links -->
    <ul class="nav-links">
      <li>
        <a href="${pageContext.request.contextPath}/home">
          Home
        </a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath}/patients/list">
          Patients
        </a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath}/doctors/list">
          Doctors
        </a>
      </li>
      <li>
        <a href="${pageContext.request.contextPath}/procedures/list"
          >Procedures
        </a>
      </li>
      <li>
        <a href="<c:url value="/logout" />">Logout</a>
      </li>
    </ul>

    <!-- Display burger icon -->
    <div class="burger">
      <div class="line1"></div>
      <div class="line2"></div>
      <div class="line3"></div>
    </div>
  </nav>
  <script src="${pageContext.request.contextPath}/resources/scripts/navSlide.js"></script>
</div>
